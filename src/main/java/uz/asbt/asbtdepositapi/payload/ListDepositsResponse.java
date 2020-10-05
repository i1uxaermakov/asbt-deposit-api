package uz.asbt.asbtdepositapi.payload;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class ListDepositsResponse extends GeneralResponse {
    private List<DepositInfo> rows = new LinkedList<>();

    public ListDepositsResponse() {
    }

    public ListDepositsResponse(List<DepositInfo> rows) {
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
