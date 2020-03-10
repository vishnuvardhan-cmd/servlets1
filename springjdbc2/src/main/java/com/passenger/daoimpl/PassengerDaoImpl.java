package com.passenger.daoimpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.passanger.dao.PassengerDao;
import com.passanger.dto.Passenger;
import com.passenger.daoimpl.rowmapper.PassengerRowMapper;

public class PassengerDaoImpl implements PassengerDao {
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(Passenger passenger) {
		String sql="insert into passenger values(?,?,?)";
		int update = jdbcTemplate.update(sql,passenger.getId(),passenger.getFname(),passenger.getLname());	
		return update;
	}
	@Override
	public int update(Passenger passenger) {
		String sql="update passenger set id=? where fname=?";
		int update = jdbcTemplate.update(sql,passenger.getId(),passenger.getFname());
		return update;
	}
	@Override
	public int delete(String name) {
		String sql="delete from passenger where lname=?";
		int update=jdbcTemplate.update(sql,name);
		return update;
	}
	@Override
	public Passenger read(int id) {
		// TODO Auto-generated method stub
		String sql="select * from passenger where id=?";
		PassengerRowMapper rowMapper =new PassengerRowMapper();
		Passenger passenger = jdbcTemplate.queryForObject(sql, rowMapper,id);
		return passenger;
	}
	@Override
	public List<Passenger> readAll() {
		// TODO Auto-generated method stub
		String sql="select * from passenger";
		Passenger passenger = new Passenger();
		PassengerRowMapper passengerRowMapper = new PassengerRowMapper();
		List<Passenger> query = jdbcTemplate.query(sql, passengerRowMapper);
		return query;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
