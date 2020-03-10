package com.passenger.daoimpl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.passanger.dto.Passenger;

public class PassengerRowMapper implements RowMapper<Passenger> {

	@Override
	public Passenger mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Passenger passenger = new Passenger();
		passenger.setId(arg0.getInt(1));
		passenger.setFname(arg0.getString(2));
		passenger.setLname(arg0.getString(3));
		return passenger;
	}

}
