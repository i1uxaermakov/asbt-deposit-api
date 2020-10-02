package uz.asbt.asbtdepositapi.payload;

import java.util.Date;

public class GeneralResponse {
    protected Short error;
    protected String message;
    protected Date run;
    protected Long requestId;


    public Short getError() {
        return error;
    }

    public void setError(Short error) {
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
