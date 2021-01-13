package uz.asbt.asbtdepositapi.payload;

import uz.asbt.asbtdepositapi.model.DepositInfo;

import java.util.LinkedList;
import java.util.List;

public class ListActiveDepositsResponse extends GeneralResponse {
    private List<DepositInfo> rows = new LinkedList<>();

    public ListActiveDepositsResponse() {
    }

    public ListActiveDepositsResponse(List<DepositInfo> rows) {
        this.rows = rows;
    }

    public List<DepositInfo> getRows() {
        return rows;
    }

    public void setRows(List<DepositInfo> rows) {
        this.rows = rows;
    }

    public void addToRows(DepositInfo depositInfo) {
        rows.add(depositInfo);
    }
}
