package uz.asbt.asbtdepositapi.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GeneralRequest {

    @NotBlank
    protected Short service;

    @NotBlank
    @Size(max = 25)
    protected String application;

    @NotBlank
    @Size(min = 5, max = 5)
    protected Long requestId;

    public Short getService() {
        return service;
    }

    public void setService(Short service) {
        this.service = service;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }
}
