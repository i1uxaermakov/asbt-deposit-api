package uz.asbt.asbtdepositapi.payload;

public class DepositInfo {

    private String code;

    private String name;

    private Integer period;

    private String typePeriod;

    private String terms;

    private String percent;

    private Long minOpen;

    private Short capitalization;

    private Short earlyClosing;

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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
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

    public Short getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Short capitalization) {
        this.capitalization = capitalization;
    }

    public Short getEarlyClosing() {
        return earlyClosing;
    }

    public void setEarlyClosing(Short earlyClosing) {
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
