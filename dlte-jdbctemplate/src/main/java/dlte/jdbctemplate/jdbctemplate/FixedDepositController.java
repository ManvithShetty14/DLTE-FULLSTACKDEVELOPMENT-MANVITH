package dlte.jdbctemplate.jdbctemplate;

import jdk.jfr.Threshold;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/template")
public class FixedDepositController {
    @Autowired
    private FixedDepositService fixedDepositService;
    private Logger logger= LoggerFactory.getLogger(FixedDeposit.class);


    @PostMapping("/")
    public String adding(@RequestBody FixedDeposit fixedDeposit){
        logger.trace(fixedDeposit.getDepositId()+"successfully inserted");

        return fixedDepositService.insertion(fixedDeposit);
    }

    @GetMapping("/bydate/{dep_date}")
    public List<FixedDeposit> callReadByName(@PathVariable("dep_date") Date dep_date){
        logger.warn("Through the department date of "+dep_date+" controller trying to find the records");
        return fixedDepositService.fetchByDate(dep_date);
    }


}
