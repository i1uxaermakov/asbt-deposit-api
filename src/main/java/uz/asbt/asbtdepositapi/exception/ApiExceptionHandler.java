package uz.asbt.asbtdepositapi.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.asbt.asbtdepositapi.controller.ServiceType;
import uz.asbt.asbtdepositapi.exception.ApiExceptionType;
import uz.asbt.asbtdepositapi.payload.GeneralResponse;

import java.util.Date;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    protected ResponseEntity<Object> handleApiException(ApiException exception) throws JsonProcessingException {
        //todo log
        ApiExceptionResponsePayload payload = new ApiExceptionResponsePayload(exception);
        return new ResponseEntity(payload, HttpStatus.OK);
        //return handleExceptionInternal(exception, getJsonStringOfGeneralResponse(response), getCommonResponseHttpHeaders(), HttpStatus.OK, request);
    }


    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleUnspecifiedExceptions(Exception exception) throws JsonProcessingException {
        //todo log

        ApiExceptionResponsePayload payload = new ApiExceptionResponsePayload(
                null,
                ApiExceptionType.UNSPECIFIED_EXCEPTION.errorCode,
                ApiExceptionType.UNSPECIFIED_EXCEPTION.message + " " + exception.getMessage(),
                new Date(System.currentTimeMillis()),
                null);
        return new ResponseEntity(payload, HttpStatus.OK);
    }




//    private HttpHeaders getCommonResponseHttpHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        return headers;
//    }
//
//    private String getJsonStringOfGeneralResponse(GeneralResponse response) throws JsonProcessingException {//todo JSON exception
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(response);
//    }
}