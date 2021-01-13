package uz.asbt.asbtdepositapi.payload;

public class ListActiveDepositsRequest extends GeneralRequest {
    protected String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
