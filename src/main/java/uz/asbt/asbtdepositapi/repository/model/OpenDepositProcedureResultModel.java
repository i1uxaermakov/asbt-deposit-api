package uz.asbt.asbtdepositapi.repository.model;

import java.util.Date;

public class OpenDepositProcedureResultModel {

    // Query Out parameters
    private String account;
    private Date dateOpen;
    private Date dateClose;
    private Integer errorCode;
    private String errorMessage;

    public OpenDepositProcedureResultModel() {
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
