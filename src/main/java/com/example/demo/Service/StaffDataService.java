package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DaoImpl.StaffDaoImpl;
import com.example.demo.model.User;

@Service
public class StaffDataService {
	@Autowired
	StaffDaoImpl db;
	 public List<User> searchAll() {
		    return db.findAll();
		  }
	public void newEmployee(User user) {

		db.newEmployee(user);
		
	}
	
	public String findDepartment(String engineer) {
		 db.findDepartment(engineer) ;
		return engineer;
		
	}

}
