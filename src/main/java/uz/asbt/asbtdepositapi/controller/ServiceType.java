package uz.asbt.asbtdepositapi.controller;

public enum ServiceType {
    LIST_ACTIVE_DEPOSITS(1),
    OPEN_DEPOSIT(2);

    public final Integer serviceNumber;

    ServiceType(Integer serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

}
