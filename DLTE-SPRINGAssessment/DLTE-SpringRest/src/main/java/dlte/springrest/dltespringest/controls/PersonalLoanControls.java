package dlte.springrest.dltespringest.controls;

import dlte.springrest.dltespringest.model.PersonalLoan;
import dlte.springrest.dltespringest.service.PersonalLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

import java.util.List;

@RestController
public class PersonalLoanControls {
    @Autowired
    PersonalLoanService personalLoanService;
// insert into the table
    @PostMapping("/insert")
    public PersonalLoan callingSave(@RequestBody PersonalLoan personalLoan){
        return personalLoanService.implementationOfSave(personalLoan);
    }
    // display all the records
    @PostMapping("/display")
    public List<PersonalLoan> findallMethodCalling(){
        return personalLoanService.implementationOfFindAll();
    }
    //update the status to approved
    @PutMapping("/update")
    public void setUpdate(){
        personalLoanService.implementUpdate();
    }

    //update the status to rejected
    @PutMapping("/updaterejected")
    public void setReject(){
        personalLoanService.implementReject();
    }

    //retrieve the list of rejected or approved loans
    @GetMapping("/findAllByStatus/{loan_status}")
    public List<PersonalLoan> findAllByStatusMethodCalling(@PathVariable("loan_status") String loan_status){
        return personalLoanService.implementationOfFindAllByStatus(loan_status);
    }

}
