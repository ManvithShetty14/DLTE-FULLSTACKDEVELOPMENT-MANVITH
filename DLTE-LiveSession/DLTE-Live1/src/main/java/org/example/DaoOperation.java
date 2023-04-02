package org.example;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoOperation {
    private Driver driver;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;

    public DaoOperation() throws SQLException {
        driver = new OracleDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
        preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
        preparedStatement.executeQuery();
    }


    public List<Loan> fetch(int cust_id) throws SQLException {
        query = "select * from loan_e,loan_mapper where loan_e.loan_number=loan_mapper.loan_number and loan_mapper.customer_id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,cust_id);
        resultSet = preparedStatement.executeQuery();
        List<Loan> data = new ArrayList<Loan>();
        while (resultSet.next()) {
            Loan loan = new Loan();
            loan.setLoan_number(resultSet.getInt("loan_number"));
            loan.setBorrower_name(resultSet.getString("borrower_name"));
            loan.setLoan_type(resultSet.getString("loan_type"));
            loan.setLoan_amount(resultSet.getInt("loan_amount"));
            loan.setLoan_issued_date(resultSet.getString("loan_issued_date"));
            data.add(loan);
        }
        return data;
    }

    public String login(int cust_id,int pin) throws SQLException {
        query="select * from customer_e where customer_id=? and customer_pin=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,cust_id);
        preparedStatement.setInt(2,pin);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString("customer_name");
        }
        else{
            return null;
        }
    }

    public Loan insert(Loan loan) throws SQLException {
        query="insert into loan_e values(loan_seq.NEXTVAL,?,?,?,?)";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,loan.getBorrower_name());
        preparedStatement.setString(2,loan.getLoan_type());
        preparedStatement.setInt(3,loan.getLoan_amount());
        preparedStatement.setString(4,loan.getLoan_issued_date());
        int acknowledgement=preparedStatement.executeUpdate();
        if(acknowledgement>0){
            return loan;

        }else{
            return null;
        }


    }
}