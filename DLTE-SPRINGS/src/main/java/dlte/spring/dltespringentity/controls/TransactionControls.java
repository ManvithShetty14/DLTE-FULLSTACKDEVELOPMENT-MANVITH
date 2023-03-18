package dlte.spring.dltespringentity.controls;


import dlte.spring.dltespringentity.models.Transaction;
import dlte.spring.dltespringentity.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TransactionControls {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/insert")
    public Transaction callingSave(@RequestBody Transaction transaction) {
        return transactionService.implementationOfSave(transaction);
    }
}