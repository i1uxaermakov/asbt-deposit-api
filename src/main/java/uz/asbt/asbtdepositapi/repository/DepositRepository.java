package uz.asbt.asbtdepositapi.repository;

import org.springframework.stereotype.Repository;
import uz.asbt.asbtdepositapi.controller.ServiceType;
import uz.asbt.asbtdepositapi.exception.ApiException;
import uz.asbt.asbtdepositapi.exception.ApiExceptionType;
import uz.asbt.asbtdepositapi.repository.model.OpenDepositProcedureParametersModel;
import uz.asbt.asbtdepositapi.repository.model.OpenDepositProcedureResultModel;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class DepositRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /*
    (
      inID_MFO in number,
      inID_CLIENT in number,
      inVklad in number,
      inAmount in number,
      inAccountCor in Varchar2,
      outDateOpen out Date,
      outDateClose out Date,
      outAccount out Varchar2,
      outErr out number,
      outMes out Varchar2)
     */
    public OpenDepositProcedureResultModel openDeposit(OpenDepositProcedureParametersModel parametersModel) {
        OpenDepositProcedureResultModel resultModel = new OpenDepositProcedureResultModel();

        try {
            // Getting the procedure open_vklad
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ASBT_VKLAD.open_vklad");

            // Declaring the parameters in the same order they appear in the procedure
            query.registerStoredProcedureParameter("inVklad", Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("inID_MFO", Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("inID_CLIENT", Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("inAmount", Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("inAccountCor", String.class, ParameterMode.IN);

            query.registerStoredProcedureParameter("outAccount", String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("outDateOpen", Date.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("outDateClose", Date.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("outErr", Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("outMes", String.class, ParameterMode.OUT);


            // Passing the parameter values
            query.setParameter("inVklad", parametersModel.getCodeVklad());
            query.setParameter("inID_MFO", parametersModel.getBank());
            query.setParameter("inID_CLIENT", parametersModel.getClientId());
            query.setParameter("inAmount", parametersModel.getAmount());
            query.setParameter("inAccountCor", parametersModel.getAccountCor());

            // Execute query
            query.execute();

            // Setting results from the OUT parameters to return back to the caller
            resultModel.setAccount((String) query.getOutputParameterValue("outAccount"));
            resultModel.setDateOpen((Date) query.getOutputParameterValue("outDateOpen"));
            resultModel.setDateClose((Date) query.getOutputParameterValue("outDateClose"));
            resultModel.setErrorCode((Integer) query.getOutputParameterValue("outErr"));
            resultModel.setErrorMessage((String) query.getOutputParameterValue("outMes"));
        }
        catch (Exception e) {
            throw new ApiException(
                    ServiceType.OPEN_DEPOSIT.serviceNumber,
                    ApiExceptionType.UNABLE_TO_WORK_WITH_DATABASE.errorCode,
                    ApiExceptionType.UNABLE_TO_WORK_WITH_DATABASE.message + " " + e.getMessage(),
                    new Date(System.currentTimeMillis()),
                    parametersModel.getRequestId());
        }

        return resultModel;
    }

}
