package dlte.spring.dltespringentity.services;

import dlte.spring.dltespringentity.models.Transaction;
import dlte.spring.dltespringentity.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionrepository;
    public Transaction implementationOfSave(Transaction transaction) {
        return transactionrepository.save(transaction);

}
}
