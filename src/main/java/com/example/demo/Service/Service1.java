package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DaoImpl.Database;
import com.example.demo.model.User;

@Service
public class Service1 {
	@Autowired
	Database db;
	 public List<User> searchAll() {
		    return db.findAll();
		  }
	public void new_employee(User user) {
		// TODO 自動生成されたメソッド・スタブ
		db.new_employee(user);
		
	}

}
