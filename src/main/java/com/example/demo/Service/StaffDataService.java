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

	public List<User> findDepartment(String staffDepartment) {

		List<User> test = db.findDepartment(staffDepartment);

		return test;
	}

	public User selectOne(String staffCode) {

		return db.selectOne(staffCode);

	}

	public void updateOne(String staff_code_before, User user) {

		db.updateOne(staff_code_before, user);
	}

	public User deleteOne(String staffCode) {

		return db.deleteOne(staffCode);
	}

	public void destroyOne(String staff_code, User user) {

		db.destroyOne(staff_code, user);
	}

}
