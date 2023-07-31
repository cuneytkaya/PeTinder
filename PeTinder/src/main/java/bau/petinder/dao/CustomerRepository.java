package bau.petinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bau.petinder.domain.Customer;

@Repository
public class CustomerRepository implements IRepository<Customer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("LastName"));
			customer.setEmail(rs.getString("Email"));
			customer.setPhone(rs.getString("Phone"));
			customer.setActive(rs.getBoolean("Active"));
			customer.setCreatedOnUtc(rs.getDate("CreatedOnUtc").toLocalDate());
			customer.setLastLoginDateUtc(rs.getDate("LastLoginDateUtc").toLocalDate());
			customer.setIsAdmin(rs.getBoolean("IsAdmin"));
			customer.setAdditionalInformation(rs.getString("AdditionalInformation"));
			customer.setPassword(rs.getString("Password"));

			return customer;
		}
	};

	
	@Override
	public Customer GetById(int id) {
		
		String sql = "select * from customer where id = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
	}
	
	public Customer GetByEmail(String email) {
		
		String sql = "select * from customer where email = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, email));
	}
	

	@Override
	public List<Customer> GetAll() {
		String sql = "select * from customer";
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void Create(Customer customer) {
	    String sql = "INSERT INTO customer (FirstName, LastName, Email, Phone, Active, CreatedOnUtc, LastLoginDateUtc, IsAdmin, AdditionalInformation, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.isActive(), customer.getCreatedOnUtc(), customer.getLastLoginDateUtc(), customer.isAdmin(), customer.getAdditionalInformation(), customer.getPassword());
	}

	@Override
	public void Update(Customer customer) {
	    String sql = "UPDATE customer SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Active = ?, CreatedOnUtc = ?, LastLoginDateUtc = ?, IsAdmin = ?, AdditionalInformation = ?, Password = ? WHERE id = ?";
	    jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.isActive(), customer.getCreatedOnUtc(), customer.getLastLoginDateUtc(), customer.isAdmin(), customer.getAdditionalInformation(), customer.getPassword(), customer.getId());
	}
	

	@Override
	public void Delete(int id) {
		String sql = "delete from customer where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public Customer Login(String email, String password) {
	    String sql = "SELECT * FROM customer WHERE Email = ? AND Password = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, email, password));
	    
	}
}
