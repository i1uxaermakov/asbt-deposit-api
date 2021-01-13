package uz.asbt.asbtdepositapi.model;


public class DepositInfo {

    private String code;

    private String name;

    private Long period;

    private String typePeriod;

    private String terms;

    private String percent;

    private Long minOpen;

    private Long capitalization;

    private Long earlyClosing;

    private String currency;

    private Long minAdd;

    public DepositInfo() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public String getTypePeriod() {
        return typePeriod;
    }

    public void setTypePeriod(String typePeriod) {
        this.typePeriod = typePeriod;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Long getMinOpen() {
        return minOpen;
    }

    public void setMinOpen(Long minOpen) {
        this.minOpen = minOpen;
    }

    public Long getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Long capitalization) {
        this.capitalization = capitalization;
    }

    public Long getEarlyClosing() {
        return earlyClosing;
    }

    public void setEarlyClosing(Long earlyClosing) {
        this.earlyClosing = earlyClosing;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getMinAdd() {
        return minAdd;
    }

    public void setMinAdd(Long minAdd) {
        this.minAdd = minAdd;
    }
}
