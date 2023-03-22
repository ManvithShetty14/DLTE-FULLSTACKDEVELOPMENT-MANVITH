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

    public List<FixedDeposit> insertion(FixedDeposit fixedDeposit)
    {
        String information=fixedDeposit.getDepositId()+"is created.";
        jdbcTemplate.update("insert into fixedDeposit values(deposit_seq.NEXTVAL,?,?,?,?,?,?,?)",new Object[]{fixedDeposit.getDepositTenure(),fixedDeposit.getDepositAmount(),fixedDeposit.getDepositDate(),fixedDeposit.getInterestRate(),fixedDeposit.getMatureDate(),fixedDeposit.getMatureAmount(),fixedDeposit.getModeOfDivident()});
        return information;
    }

//    public List<FixedDeposit> fetchByDate(Date dep_date){
//        return jdbcTemplate.query("select * from fixedDeposit where deposit_date=?",new Object[]{dep_date},new FixedDepositMappers());
//    }

    class FixedDepositMappers implements RowMapper<FixedDeposit>{
        @Override
        public FixedDeposit mapRow(ResultSet rs,int rowNo) throws SQLException {
            FixedDeposit fixedDeposit=new FixedDeposit();
            fixedDeposit.setDepositId(rs.getInt("deposit_id"));
            fixedDeposit.setDepositTenure(rs.getInt("deposit_tenure"));
            fixedDeposit.setDepositAmount(rs.getFloat("deposit_amount"));
            fixedDeposit.setDepositDate(rs.getDate("deposit_date"));
            fixedDeposit.setInterestRate(rs.getFloat("interest_rate"));
            fixedDeposit.setMatureDate(rs.getDate("mature_date"));
            fixedDeposit.setMatureAmount(rs.getFloat("mature_amount"));
            fixedDeposit.setModeOfDivident(rs.getString("mode_of_divident"));

            return fixedDeposit;
        }
    }

}
