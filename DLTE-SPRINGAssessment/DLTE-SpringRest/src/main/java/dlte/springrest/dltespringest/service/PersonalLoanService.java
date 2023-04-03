package dlte.springrest.dltespringest.service;

import dlte.springrest.dltespringest.model.PersonalLoan;
import dlte.springrest.dltespringest.remote.PersonalLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.util.List;

@Service
public class PersonalLoanService {
    @Autowired
    PersonalLoanRepository personalLoanRepository;

    public PersonalLoan implementationOfSave(PersonalLoan personalLoan){
        return personalLoanRepository.save(personalLoan);
    }

    public List<PersonalLoan> implementationOfFindAll() {
        return (List<PersonalLoan>) personalLoanRepository.findAll();
    }

    public  void implementUpdate(){
        personalLoanRepository.updatestatus();
    }

    public  void implementReject(){
        personalLoanRepository.updaterejected();
    }

    public List<PersonalLoan> implementationOfFindAllByStatus(String loan_status) {
        return personalLoanRepository.findAllByStatus(loan_status);
    }

//    public void implementUpdate(){
//        personalLoanRepository.updatestatus();
//    }
}
