package dlte.usermethod.springmethod.control;


import dlte.usermethod.springmethod.model.Transaction;
import dlte.usermethod.springmethod.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionControl {
    @Autowired
    private TransactionService transactionService;

//    @GetMapping("/retrieve")
//    public List<Transaction> callingFindAll(){
//        return transactionService.implementationOfFindAll();
//    }

    @PostMapping("/insert")
    public Transaction callingSave(@RequestBody Transaction transaction){
        return transactionService.implementationOfSave(transaction);
    }


//    @GetMapping("/min/{amnt}")
//    public List<Transaction> callMinimumBalance(@PathVariable("amnt") int amnt){
//        return transactionService.implementMaximumAmount(amnt);
//    }

//    @GetMapping("/date/{date}")
//    public  List<Transaction> callingFindAllByInterestRate(@PathVariable("date") String date){
//        return transactionService.implementofFindAllByDate(date);
//    }
}
