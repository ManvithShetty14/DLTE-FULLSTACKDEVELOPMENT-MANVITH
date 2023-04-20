package bank.project.dao;

import java.util.List;

public interface BankOperations {
    public Role loginByName(String uname);
    public String insertLoan(LoanScheme loan_scheme);
    public List<LoanScheme> listAllLoan();
////    public void updateAttempts(String username);
//    public void updateStatus(String username);
//    public void loginSuccess(String username);

}
