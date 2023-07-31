package bau.petinder.dao;

import org.springframework.stereotype.Repository;
import bau.petinder.domain.MatchHistory;
import bau.petinder.domain.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class MatchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<MatchHistory> rowMapper = new RowMapper<MatchHistory>() {
	    public MatchHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	MatchHistory match = new MatchHistory();
	    	match.setId(rs.getInt("id"));
	        match.setSourcePetId(rs.getInt("sourcePetId"));
	        match.setSourceCustomerId(rs.getInt("sourceCustomerId"));
	        match.setTargetPetId(rs.getInt("targetPetId"));
	        match.setMatchSelected(rs.getBoolean("isMatchSelected"));

	        return match;
	    }
	};
	
	public MatchHistory GetById(int id) {
		
		String sql = "select * from MatchHistory where id = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
		
	}
	
public MatchHistory GetBySourceAndTargetIds(int sourceId, int targetId) {
		
		String sql = "select * from MatchHistory where sourcePetId = ? and targetPetId = ?";
		
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, sourceId, targetId));
		
	}
	
	public List<MatchHistory> GetAllMatchs(int customerId){
		String sql = "select * from MatchHistory where sourceCustomerId = ?";
			
		return jdbcTemplate.query(sql, rowMapper, customerId);
	}
	
	public List<MatchHistory> GetAllMatchs(){
		String sql = "select * from MatchHistory";
			
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<MatchHistory> GetCancelledMatchs(int customerId){
		
		String sql = "select * from MatchHistory where sourceCustomerId = ?";
		
		return jdbcTemplate.query(sql, rowMapper, customerId);
	}
	
	public boolean isMatchExists(int targetPetId, int sourcePetId) {
	    String sql = "SELECT COUNT(*) FROM MatchHistory WHERE targetPetId = ? AND sourcePetId = ?";
	    int count = jdbcTemplate.queryForObject(sql, Integer.class, targetPetId, sourcePetId);
	    return count > 0;
	}
	
	public void insertMatchHistory(MatchHistory entity) {
	    String sql = "INSERT INTO MatchHistory (sourceCustomerId, sourcePetId, targetPetId, isMatchSelected) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(sql, entity.getSourceCustomerId(), entity.getSourcePetId(), entity.getTargetPetId(), entity.isMatchSelected());
	}
	
	public void deleteMatchHistory(MatchHistory entity) {
	    String sql = "DELETE FROM MatchHistory WHERE sourcePetId = ? AND targetPetId = ?";
	    jdbcTemplate.update(sql, entity.getSourcePetId(), entity.getTargetPetId());
	}
}
