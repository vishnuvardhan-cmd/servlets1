package com.passenger.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.passanger.dto.Passenger;
import com.passenger.daoimpl.PassengerDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =new ClassPathXmlApplicationContext("com/passenger/main/config.xml");
		PassengerDaoImpl bean = (PassengerDaoImpl)context.getBean("passenger");
		Passenger passenger = new Passenger();
		/*System.out.println(passenger.hashCode());
		passenger.setId(3);
		passenger.setFname("venkat reddy");
		passenger.setLname("bandlamudi");
		int insert = bean.delete(passenger.getLname());*/
		Passenger read = bean.read(1);
		System.out.println(read);
		List<Passenger> readAll = bean.readAll();
		System.out.println(readAll);
	}

}