package uz.asbt.asbtdepositapi.repository.model;

import uz.asbt.asbtdepositapi.payload.OpenDepositRequest;

public class OpenDepositProcedureParametersModel {
    private Long codeVklad;
    private Long bank;
    private Long clientId;
    private Long amount;
    private String accountCor;
    private Long requestId;

    public OpenDepositProcedureParametersModel(OpenDepositRequest request) {
        codeVklad = request.getCode();
        bank = request.getBank();
        clientId = request.getClientId();
        amount = request.getAmount();
        accountCor = request.getAccountCor();
        requestId = request.getRequestId();
    }

    public Long getCodeVklad() {
        return codeVklad;
    }

    public void setCodeVklad(Long codeVklad) {
        this.codeVklad = codeVklad;
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
        this.bank = bank;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAccountCor() {
        return accountCor;
    }

    public void setAccountCor(String accountCor) {
        this.accountCor = accountCor;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
