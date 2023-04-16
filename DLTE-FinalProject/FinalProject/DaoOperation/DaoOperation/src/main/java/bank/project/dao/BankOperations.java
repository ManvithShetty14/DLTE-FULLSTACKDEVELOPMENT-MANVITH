package bank.project.dao;

import java.util.List;

public interface BankOperations {
    public Role loginByName(String uname);
    public void failedAttempts(int id);
    public String insertion(Loan_scheme loan_scheme);
    public List<Loan_scheme> listAllLoan();
}
