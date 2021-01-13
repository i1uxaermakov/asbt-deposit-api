package uz.asbt.asbtdepositapi.exception;

public enum ApiExceptionType {
    PROCEDURE_RETURNED_NULL_ERROR_OR_MESSAGE (90, "Error или Message, полученные из процедуры, равны null."),
    UNABLE_TO_WORK_WITH_DATABASE(91, "Приложение не смогло работать с базой данных."),
    INVALID_SERVICE_PARAMETER(11, "Параметр запроса указан неверно"),
    UNSPECIFIED_EXCEPTION(92, "Системная Ошибка. ");

    ApiExceptionType(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public final Integer errorCode;
    public final String message;
}
