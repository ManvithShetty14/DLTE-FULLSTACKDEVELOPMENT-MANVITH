package dlte.springhibernate.dltehibernate.services;

import dlte.springhibernate.dltehibernate.model.Transactions;
import dlte.springhibernate.dltehibernate.remote.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transactions implementationOfSave(Transactions transactions){
        return transactionRepository.save(transactions);
    }

    public List<Transactions> implementationOfFindAll() {

        return (List<Transactions>) transactionRepository.findAll();
    }

    public Optional<Transactions> implementationOfFindById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public List<Transactions> implementationOfFindAllBySender(String sent) {
        return transactionRepository.findAllBySender(sent);
    }

    public List<Transactions> implementationOfFindAllByGreaterAmount(Double balance){
        return transactionRepository.findAllByAmount(balance);
    }

    public String implementationOfDeleteById(long transactionId) {
        Transactions transactions = transactionRepository.findById(transactionId).get();
        String information = transactions.getTransaction_id() + " has been Deleted";
        transactionRepository.deleteById(transactionId);
        return information;
    }

    public List<Double> implementOfFindAllByType(String option){
        return transactionRepository.findAllByType(option);
    }
}
