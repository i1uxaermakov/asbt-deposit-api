package uz.asbt.asbtdepositapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.asbt.asbtdepositapi.payload.GeneralRequest;
import uz.asbt.asbtdepositapi.payload.GeneralResponse;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "PERSISTED_REQUEST_RESPONSES")
/*
, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "requestId"
        }),
}
 */
public class PersistedRequestResponsePair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer errorInResponse;

    private String messageInResponse;

    @NotNull
    private Date runInResponse;

    @NotNull
    private Integer serviceParameterInRequest;

    @NotNull
    private Integer serviceParameterInResponse;

    @NotNull
    private Long requestIdInRequest;

    @Lob
    @NotNull
    private String requestJsonString;

    @Lob
    @NotNull
    private String responseJsonString;


    public PersistedRequestResponsePair(GeneralRequest request, GeneralResponse response) throws JsonProcessingException {
        errorInResponse = response.getError();
        messageInResponse = response.getMessage();
        runInResponse = response.getRun();
        serviceParameterInResponse = response.getService();

        requestIdInRequest = request.getRequestId();
        serviceParameterInRequest = request.getService();

        ObjectMapper objectMapper = new ObjectMapper();
        this.responseJsonString = objectMapper.writeValueAsString(response);
        this.requestJsonString = objectMapper.writeValueAsString(request);
    }


    public PersistedRequestResponsePair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getErrorInResponse() {
        return errorInResponse;
    }

    public void setErrorInResponse(Integer errorInResponse) {
        this.errorInResponse = errorInResponse;
    }

    public String getMessageInResponse() {
        return messageInResponse;
    }

    public void setMessageInResponse(String messageInResponse) {
        this.messageInResponse = messageInResponse;
    }

    public Date getRunInResponse() {
        return runInResponse;
    }

    public void setRunInResponse(Date runInResponse) {
        this.runInResponse = runInResponse;
    }

    public Integer getServiceParameterInRequest() {
        return serviceParameterInRequest;
    }

    public void setServiceParameterInRequest(Integer serviceParameterInRequest) {
        this.serviceParameterInRequest = serviceParameterInRequest;
    }

    public Integer getServiceParameterInResponse() {
        return serviceParameterInResponse;
    }

    public void setServiceParameterInResponse(Integer serviceParameterInResponse) {
        this.serviceParameterInResponse = serviceParameterInResponse;
    }

    public Long getRequestIdInRequest() {
        return requestIdInRequest;
    }

    public void setRequestIdInRequest(Long requestIdInRequest) {
        this.requestIdInRequest = requestIdInRequest;
    }

    public String getRequestJsonString() {
        return requestJsonString;
    }

    public void setRequestJsonString(String requestJsonString) {
        this.requestJsonString = requestJsonString;
    }

    public String getResponseJsonString() {
        return responseJsonString;
    }

    public void setResponseJsonString(String responseJsonString) {
        this.responseJsonString = responseJsonString;
    }
}
