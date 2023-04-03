package dlte.springrest.dltespringest.remote;

import dlte.springrest.dltespringest.model.PersonalLoan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonalLoanRepository extends CrudRepository<PersonalLoan,Integer> {
    @Modifying
    @Transactional
    @Query("update PersonalLoan SET statusApproval='APPROVED' where cibil>700 and profession in ('salaried','self-employeed') and incomePerAnnum>req_amount+req_amount+req_amount")
    void updatestatus();

    @Modifying
    @Transactional
    @Query("update PersonalLoan SET statusApproval='REJECTED' where cibil<=700 OR profession NOT in ('salaried','self-employeed') OR incomePerAnnum<=req_amount+req_amount+req_amount")
    void updaterejected();

    @Query("from PersonalLoan where statusApproval like %:status%")
    List<PersonalLoan> findAllByStatus(String status);



}
