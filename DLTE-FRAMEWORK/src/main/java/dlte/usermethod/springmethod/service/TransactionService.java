package dlte.usermethod.springmethod.service;


import dlte.usermethod.springmethod.model.Transaction;
import dlte.usermethod.springmethod.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

//    public List<Transaction> implementationOfFindAll(){
//        return (List<Transaction>) transactionRepository.findAll();
//    }

    public Transaction implementationOfSave(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

//    public List<Transaction> implementofFindAllByDate(String date) {
//        return TransactionRepository.findAllByDate(date);
//    }
}