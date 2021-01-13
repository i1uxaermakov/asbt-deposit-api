package uz.asbt.asbtdepositapi.payload;

import uz.asbt.asbtdepositapi.repository.model.OpenDepositProcedureResultModel;

import java.util.Date;

public class OpenDepositResponse extends GeneralResponse {
//    protected Integer error;
//    protected String message;
//    protected Date run;
//    protected Integer requestId;

    protected Long bank;
    protected String account;
    protected Date open;
    protected Date close;
    protected Long amount;


    /*
    // Query output
    private Integer codeVklad;
    private Integer bank;
    private Integer clientId;
    private Integer amount;

    // Query Out parameters
    private String account;
    private Date dateOpen;
    private Date dateClose;
    private Integer errorCode;
    private String errorMessage;
     */
    public OpenDepositResponse(OpenDepositProcedureResultModel queryResult) {
        super();

        this.account = queryResult.getAccount();
        this.open = queryResult.getDateOpen();
        this.close = queryResult.getDateClose();
        this.error = queryResult.getErrorCode();
        this.message = queryResult.getErrorMessage();
    }

    public OpenDepositResponse() {
        super();
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClose() {
        return close;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
