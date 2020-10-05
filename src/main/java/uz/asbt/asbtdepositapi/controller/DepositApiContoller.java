package uz.asbt.asbtdepositapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.asbt.asbtdepositapi.model.PersistedResponse;
import uz.asbt.asbtdepositapi.payload.*;
import uz.asbt.asbtdepositapi.repository.PersistedResponseRepository;

import java.util.Date;

@Controller
@RequestMapping("/api/v1/contribution")
public class DepositApiContoller {

    @Autowired
    private PersistedResponseRepository persistedResponseRepository;

    @PostMapping(value="/list", consumes = "application/json; charset=utf-8",
                                produces = "application/json; charset=utf-8" )
    public @ResponseBody ListDepositsResponse open(@RequestBody ListDepositsRequest listDepositsRequestData) {
        ListDepositsResponse response = new ListDepositsResponse();
        response.setError((short) 0);
        response.setMessage("ok");

        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        response.setRun(new Date());
        response.setRequestId(listDepositsRequestData.getRequestId());

        DepositInfo depositInfo1 = new DepositInfo();
        depositInfo1.setCode("20206901");
        depositInfo1.setName("Депозит до востребования");
        depositInfo1.setPeriod(0);

        DepositInfo depositInfo2 = new DepositInfo();
        depositInfo2.setCode("20606901");
        depositInfo2.setName("Срочный депозит 1");
        depositInfo2.setPeriod(3);

        response.addToRows(depositInfo1);
        response.addToRows(depositInfo2);

        saveResponse(response);

        return response;
    }



//    @PostMapping(value="/open", consumes = "application/json; charset=utf-8",
//                                produces = "application/json; charset=utf-8" )
//    public @ResponseBody OpenDepositResponse open(@RequestBody OpenDepositRequest openDepositRequestData) {
//
//        OpenDepositResponse response = new OpenDepositResponse();
//
//        saveResponse(response);
//    }

    private void saveResponse(GeneralResponse response) {
        try {
            PersistedResponse responseToPersist = new PersistedResponse(response);
            persistedResponseRepository.save(responseToPersist);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
