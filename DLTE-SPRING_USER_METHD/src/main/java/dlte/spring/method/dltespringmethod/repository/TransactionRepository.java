package dlte.spring.method.dltespringmethod.repository;
import dlte.spring.method.dltespringmethod.model.Transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {


}
