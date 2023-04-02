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
    //insert the input
    @PostMapping("/insert")
    public Transactions callingSave(@RequestBody Transactions transactions){
        return transactionService.implementationOfSave(transactions);
    }

    //to view all records
    @PostMapping("/findAll")
    public List<Transactions> findAllMethodCalling() {
        return transactionService.implementationOfFindAll();
    }

    // to view by providing the transaction id
    @GetMapping("/findById/{transactionId}")
    public Optional<Transactions> findByIdMethodCalling(@PathVariable("transactionId") long transactionId){
        return transactionService.implementationOfFindById(transactionId);
    }

    //to view the record by specifying the sender name
    @GetMapping("/findAllBySender/{sent}")
    public List<Transactions> findAllBySenderMethodCalling(@PathVariable("sent") String sent){
        return transactionService.implementationOfFindAllBySender(sent);
    }

    //to view the list of transaction whose amount is greater than input amount
    @GetMapping("/findAllByAmount/{balance}")
    public List<Transactions> findAllByAmountMethodCalling(@PathVariable("balance") Double balance){
        return transactionService.implementationOfFindAllByGreaterAmount(balance);
    }

    //to view the amount list by specifying the type of transaction
    @GetMapping("/findAllByType/{option}")
    public List<Double> findAllByTypeMethodCalling(@PathVariable("option") String option){
        return transactionService.implementOfFindAllByType(option);
    }

    // to delete the record from the transaction by giving the id
    @DeleteMapping("/delete/{transactionId}")
    public String deleteByIdMethodCalling(@PathVariable("transactionId") long transactionId){
        return transactionService.implementationOfDeleteById(transactionId);
    }

    // to update the values
    @PutMapping("/update")
    public Transactions updateMethodImplementation(@RequestBody Transactions transactions){
        return transactionService.implementationOfSave(transactions);
    }



}
