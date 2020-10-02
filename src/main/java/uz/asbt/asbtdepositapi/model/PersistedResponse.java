package uz.asbt.asbtdepositapi.model;

import uz.asbt.asbtdepositapi.payload.GeneralResponse;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PERSISTED_RESPONSES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "requestId"
        }),
})
public class PersistedResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected short error;
    protected String message;
    protected Date run;
    protected long requestId;
    protected String response;

    public PersistedResponse(GeneralResponse response, String responseJSON) {
        error = response.getError();
        message = response.getMessage();
        run = response.getRun();
        requestId = response.getRequestId();
        this.response = responseJSON;
    }

    public PersistedResponse() {
    }

    public short getError() {
        return error;
    }

    public void setError(short error) {
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

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
