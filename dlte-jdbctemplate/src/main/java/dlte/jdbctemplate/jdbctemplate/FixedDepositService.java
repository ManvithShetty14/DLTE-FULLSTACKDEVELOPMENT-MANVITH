package dlte.jdbctemplate.jdbctemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class FixedDepositService {

    private JdbcTemplate jdbcTemplate;

    public String insertion(FixedDeposit fixedDeposit)
    {
//        String information=fixedDeposit.getDepositId()+"is created.";
        jdbcTemplate.update("insert into fixed_deposit values(?,?,?,?,?,?,?,?)",new Object[]{fixedDeposit.getDepositId(),fixedDeposit.getDepositTenure(),fixedDeposit.getDepositAmount(),fixedDeposit.getDepositDate(),fixedDeposit.getInterestRate(),fixedDeposit.getMatureDate(),fixedDeposit.getMatureAmount(),fixedDeposit.getModeOfDivident()});
        return "INSERTED";
    }

    public List<FixedDeposit> fetchByDate(Date dep_date){
        return jdbcTemplate.query("select * from fixedDeposit where deposit_date=?",new Object[]{dep_date},new FixedDepositMappers());
    }

    class FixedDepositMappers implements RowMapper<FixedDeposit>{
        @Override
        public FixedDeposit mapRow(ResultSet rs,int rowNo) throws SQLException {
            FixedDeposit fixedDeposit=new FixedDeposit();
            fixedDeposit.setDepositId(rs.getInt("depositId"));
            fixedDeposit.setDepositTenure(rs.getInt("depositTenure"));
            fixedDeposit.setDepositAmount(rs.getFloat("depositAmount"));
            fixedDeposit.setDepositDate(rs.getDate("depositDate"));
            fixedDeposit.setInterestRate(rs.getFloat("interestRate"));
            fixedDeposit.setMatureDate(rs.getDate("matureDate"));
            fixedDeposit.setMatureAmount(rs.getFloat("matureAmount"));
            fixedDeposit.setModeOfDivident(rs.getString("modeOfDivident"));

            return fixedDeposit;
        }
    }

}
