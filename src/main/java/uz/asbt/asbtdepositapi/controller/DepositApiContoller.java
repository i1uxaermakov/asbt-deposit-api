package uz.asbt.asbtdepositapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.asbt.asbtdepositapi.payload.*;

@Controller
@RequestMapping("/api/v1/contribution")
public class DepositApiContoller {

    @PostMapping(value="/list", consumes = "application/json; charset=utf-8",
                                produces = "application/json; charset=utf-8" )
    public @ResponseBody ListDepositsResponse open(@RequestBody ListDepositsRequest listDepositsRequestData) {
        return null;
    }



    @PostMapping(value="/open", consumes = "application/json; charset=utf-8",
                                produces = "application/json; charset=utf-8" )
    public @ResponseBody OpenDepositResponse open(@RequestBody OpenDepositRequest openDepositRequestData) {
        return null;
    }

    private void saveResponse(GeneralResponse response) {

    }
}
