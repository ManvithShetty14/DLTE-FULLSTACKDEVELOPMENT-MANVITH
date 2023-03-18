package dlte.springhibernate.dltehibernate.controls;


import dlte.springhibernate.dltehibernate.model.Transactions;
import dlte.springhibernate.dltehibernate.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionControls {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/insert")
    public Transactions callingSave(@RequestBody Transactions transactions){
        return transactionService.implementationOfSave(transactions);
    }

    @PostMapping("/findAll")
    public List<Transactions> findAllMethodCalling(){
        return transactionService.implementationOfFindAll();
    }

    @GetMapping("/findById/{transactionId}")
    public Optional<Transactions> findByIdMethodCalling(@PathVariable("transactionId") long transactionId){
        return transactionService.implementationOfFindById(transactionId);
    }

    @DeleteMapping("/delete/{transactionId}")
    public String deleteByIdMethodCalling(@PathVariable("transactionId") long transactionId){
        return transactionService.implementationOfDeleteById(transactionId);
    }

    @PutMapping("/update")
    public Transactions updateMethodImplementation(@RequestBody Transactions transactions){
        return transactionService.implementationOfSave(transactions);
    }



}
