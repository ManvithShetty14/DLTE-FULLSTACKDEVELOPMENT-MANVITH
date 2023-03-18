package dlte.usermethod.springmethod.repository;

import dlte.usermethod.springmethod.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
//    List<Integer> findAllByDate(String date);

}
