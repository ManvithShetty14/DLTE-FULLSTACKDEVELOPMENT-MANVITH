package dlte.spring.method.dltespringmethod.control;


import dlte.spring.method.dltespringmethod.model.Transaction;
import dlte.spring.method.dltespringmethod.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionControl {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/insert")
    public Transaction callingSave(@RequestBody Transaction transaction){
     return transactionService.implementationOfSave(transaction);
    }
}
