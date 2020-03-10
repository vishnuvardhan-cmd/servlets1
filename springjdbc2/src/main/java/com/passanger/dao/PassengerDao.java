package com.passanger.dao;

import java.util.List;

import com.passanger.dto.Passenger;

public interface PassengerDao {
	int insert(Passenger passenger);
	int update(Passenger passenger);
	int delete(String name);
	Passenger read(int id);
	List<Passenger> readAll();
}
