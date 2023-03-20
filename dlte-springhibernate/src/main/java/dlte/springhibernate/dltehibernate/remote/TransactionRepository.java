package dlte.springhibernate.dltehibernate.remote;

import dlte.springhibernate.dltehibernate.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions,Long> {

    @Query("from Transactions where sender like %:sender_name%")
    List<Transactions> findAllBySender(String sender_name);

    @Query("from Transactions where amount>= :balance")
    List<Transactions> findAllByAmount(Double  balance);

    @Query("select amount from Transactions where type like %:option%")
    List<Double> findAllByType(String option);
}
