package dlte.spring.dltespringentity.repository;

import dlte.spring.dltespringentity.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;



@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("from Transaction where amount>= :amnt")
     List<Transaction> findAllByMaximumAmount(Integer amnt);

}
