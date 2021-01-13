package uz.asbt.asbtdepositapi.payload;

public class OpenDepositRequest extends GeneralRequest {
//    protected Integer service;
//    protected String application;
//    protected Integer requestId;
    protected Long code;
    protected Long amount;
    protected Long bank;
    protected String accountCor;
    protected Long clientId;

    public OpenDepositRequest() {
        super();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
        this.bank = bank;
    }

    public String getAccountCor() {
        return accountCor;
    }

    public void setAccountCor(String accountCor) {
        this.accountCor = accountCor;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
