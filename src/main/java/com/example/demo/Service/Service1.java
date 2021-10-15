package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DaoImpl.Database;
import com.example.demo.model.User;

@Service
public class Service1 {
	@Autowired
	Database db;
	public void new_employee(User user2) {
		
		db.new_employee(user2);
		}

}
