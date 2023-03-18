package dlte.spring.method.dltespringmethod.service;


import dlte.spring.method.dltespringmethod.model.Transaction;
import dlte.spring.method.dltespringmethod.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
public Transaction implementationOfSave(Transaction transaction){
    return transactionRepository.save(transaction);

}

}
