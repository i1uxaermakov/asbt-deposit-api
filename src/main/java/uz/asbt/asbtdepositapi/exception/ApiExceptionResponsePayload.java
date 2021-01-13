package uz.asbt.asbtdepositapi.exception;

import java.util.Date;

public class ApiExceptionResponsePayload {
    protected Integer service;
    protected Integer error;
    protected String message;
    protected Date run;
    protected Long requestId;

    public ApiExceptionResponsePayload(ApiException exception) {
        service = exception.getService();
        error = exception.getError();
        message = exception.getMessage();
        run = exception.getRun();
        requestId = exception.getRequestId();
    }

    public ApiExceptionResponsePayload(Integer service, Integer error, String message, Date run, Long requestId) {
        this.service = service;
        this.error = error;
        this.message = message;
        this.run = run;
        this.requestId = requestId;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getRun() {
        return run;
    }

    public void setRun(Date run) {
        this.run = run;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
