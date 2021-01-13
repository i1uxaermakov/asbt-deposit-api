package uz.asbt.asbtdepositapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.asbt.asbtdepositapi.exception.ApiException;
import uz.asbt.asbtdepositapi.exception.ApiExceptionType;
import uz.asbt.asbtdepositapi.model.PersistedRequestResponsePair;
import uz.asbt.asbtdepositapi.payload.*;
import uz.asbt.asbtdepositapi.repository.DepositRepository;
import uz.asbt.asbtdepositapi.repository.PersistedRequestResponseRepository;
import uz.asbt.asbtdepositapi.repository.model.OpenDepositProcedureParametersModel;
import uz.asbt.asbtdepositapi.repository.model.OpenDepositProcedureResultModel;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contribution")
public class DepositApiContoller {

    @Autowired
    private PersistedRequestResponseRepository persistedRequestResponseRepository;

    @Autowired
    private DepositRepository depositRepository;


    @PostMapping(value="/list", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8" )
    public @ResponseBody ListActiveDepositsResponse listActiveDeposits(@RequestBody ListActiveDepositsRequest request) {
        ListActiveDepositsResponse response = new ListActiveDepositsResponse();
        return response;
    }


    //todo what if a request comes with incorrect structure
    @PostMapping(value="/open", consumes = "application/json; charset=utf-8",
                                produces = "application/json; charset=utf-8" )
    public @ResponseBody OpenDepositResponse openDeposit(@RequestBody OpenDepositRequest request) throws ApiException, JsonProcessingException {
        // If the request came to /open and service!=2, an Invalid Service response is sent
        if(request.getService() != ServiceType.OPEN_DEPOSIT.serviceNumber) {
            throw new ApiException(
                    ServiceType.OPEN_DEPOSIT.serviceNumber,
                    ApiExceptionType.INVALID_SERVICE_PARAMETER.errorCode,
                    ApiExceptionType.INVALID_SERVICE_PARAMETER.message,
                    new Date(System.currentTimeMillis()),
                    request.getRequestId());

        }

        // Check if a request with the same requestId has already been made
        Optional<PersistedRequestResponsePair> optionalPersistedResponseToPreviousRequestWithSameId =
                persistedRequestResponseRepository.findByRequestIdInRequest(request.getRequestId());

        // If a request with the provided requestId has been made before, check if it was for the same service.
        // If it was for the same service, return the previous rsponse. Otherwise, an Invalid Service response is sent
        if(optionalPersistedResponseToPreviousRequestWithSameId.isPresent()) {
            PersistedRequestResponsePair persistedResponse = optionalPersistedResponseToPreviousRequestWithSameId.get();

            if(persistedResponse.getServiceParameterInResponse() != ServiceType.OPEN_DEPOSIT.serviceNumber) {
                throw new ApiException(
                        ServiceType.OPEN_DEPOSIT.serviceNumber,
                        ApiExceptionType.INVALID_SERVICE_PARAMETER.errorCode,
                        ApiExceptionType.INVALID_SERVICE_PARAMETER.message,
                        new Date(System.currentTimeMillis()),
                        request.getRequestId());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            OpenDepositResponse previousOpenDepositResponse = objectMapper.readValue(persistedResponse.getResponseJsonString(), OpenDepositResponse.class);

            // Not saving this request/response because the response has already been saved
            return previousOpenDepositResponse;
        }

        // A request with the same requestId hasn't been made before, so we are making it
        OpenDepositProcedureResultModel queryResult = depositRepository.openDeposit(new OpenDepositProcedureParametersModel(request));

        if(queryResult.getErrorCode() == null || queryResult.getErrorMessage() == null) {
            throw new ApiException(
                    ServiceType.OPEN_DEPOSIT.serviceNumber,
                    ApiExceptionType.PROCEDURE_RETURNED_NULL_ERROR_OR_MESSAGE.errorCode,
                    ApiExceptionType.PROCEDURE_RETURNED_NULL_ERROR_OR_MESSAGE.message,
                    new Date(System.currentTimeMillis()),
                    request.getRequestId());
        }
        else {
            OpenDepositResponse response = new OpenDepositResponse(queryResult);
            assignRequestIdDateAndServiceToResponse(response, request.getRequestId(), ServiceType.OPEN_DEPOSIT.serviceNumber);
            response.setAmount(request.getAmount());
            response.setBank(request.getBank());
            saveRequestResponsePair(request, response);
            return response;
        }
    }



    private void saveRequestResponsePair(GeneralRequest request, GeneralResponse response) {
        try {
            PersistedRequestResponsePair responseToPersist = new PersistedRequestResponsePair(request, response);
            persistedRequestResponseRepository.save(responseToPersist);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    private void assignRequestIdDateAndServiceToResponse(GeneralResponse response, Long requestId, Integer serviceNumber) {
        response.setRequestId(requestId);
        response.setRun(new Date(System.currentTimeMillis()));
        response.setService(serviceNumber);
    }
}
