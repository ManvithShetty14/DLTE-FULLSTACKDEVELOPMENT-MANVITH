package dlte.springhibernate.dltehibernate.remote;

import dlte.springhibernate.dltehibernate.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions,Long> {
}
