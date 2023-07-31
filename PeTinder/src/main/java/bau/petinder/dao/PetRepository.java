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
import bau.petinder.domain.Pet;

@Repository
public class PetRepository implements IRepository<Pet> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Pet> rowMapper = new RowMapper<Pet>() {
	    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Pet pet = new Pet();
	        pet.setId(rs.getInt("id"));
	        pet.setName(rs.getString("name"));
	        pet.setPetTypeId(rs.getInt("petTypeId"));
	        pet.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
	        pet.setVaccinated(rs.getBoolean("vaccinated"));
	        pet.setAdditionalInformation(rs.getString("additionalInformation"));
	        pet.setCustomerId(rs.getInt("customerId"));

	        return pet;
	    }
	};
	
	@Override
	public Pet GetById(int id) {
		
		String sql = "SELECT * FROM pet WHERE id = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));

	}

	@Override
	public List<Pet> GetAll() {
		
		String sql = "select * from pet";
		
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Pet> GetAll(int customerId) {
		
		String sql = "select * from pet WHERE customerId = ?";
		
		return jdbcTemplate.query(sql, rowMapper, customerId);
	}

	@Override
	public void Create(Pet pet) {
	    String sql = "INSERT INTO pet (name, petTypeId, dateOfBirth, vaccinated, additionalInformation, customerId) VALUES (?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(sql, pet.getName(), pet.getPetTypeId(), pet.getDateOfBirth(), pet.isVaccinated(), pet.getAdditionalInformation(), pet.getCustomerId());
	}

	@Override
	public void Update(Pet pet) {
	    String sql = "UPDATE pet SET name = ?, petTypeId = ?, dateOfBirth = ?, vaccinated = ?, additionalInformation = ?, customerId = ? WHERE id = ?";
	    jdbcTemplate.update(sql, pet.getName(), pet.getPetTypeId(), pet.getDateOfBirth(), pet.isVaccinated(), pet.getAdditionalInformation(), pet.getCustomerId(), pet.getId());
	}

	@Override
	public void Delete(int id) {
		String sql = "DELETE FROM pet WHERE id = ?";
	    jdbcTemplate.update(sql, id);
	    
	}

}
