package bau.petinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bau.petinder.domain.Customer;
import bau.petinder.domain.WorkContext;

@Repository
public class WorkContextRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<WorkContext> rowMapper = new RowMapper<WorkContext>() {
	    @Override
	    public WorkContext mapRow(ResultSet rs, int rowNum) throws SQLException {
	        WorkContext workContext = new WorkContext();
	        workContext.setActiveLanguageCode(rs.getString("activeLanguageCode"));
	        workContext.setActiveCustomerId(rs.getInt("activeCustomerId"));
	        return workContext;
	    }
	};

	public WorkContext GetWorkContext() {
		
		String sql = "select * from WorkContext where id = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, 1));
	}
	
	public void SetCurrentCustomer(Customer customer) {
		 String sql = "UPDATE WorkContext SET activeCustomerId = ? WHERE id = 1";
		    jdbcTemplate.update(sql, customer.getId());
	}
	
	public void SetCurrentLanguageCode(String languageCode) {
		 String sql = "UPDATE WorkContext SET activeLanguageCode = ? WHERE id = 1";
		    jdbcTemplate.update(sql, languageCode);
	}
	
	public void Logout() {
		 String sql = "UPDATE WorkContext SET activeCustomerId = 0 WHERE id = 1";
		    jdbcTemplate.update(sql);
	}
}
