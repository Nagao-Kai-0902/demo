package com.example.demo.Dao.DaoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository

public class Database {
	@Autowired
	 JdbcTemplate jdbc;

	public void new_employee(User user3) {
		String sql = "INSERT INTO staffs (id" + ",staff_code" + ",last_name" + ",first_name" + ",last_name_romaji"
				+ ",first_name_romaji" + ",staff_department" + ",project_type" + ",joined_year" + ",new_glad_flg"
				+ ",created_by" + ",updated_by" + ",created_at" + ",updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.update(sql, user3.getId(), user3.getStaff_code(), user3.getLast_name(), user3.getFirst_name(),
				user3.getLast_name_romaji(), user3.getFirst_name_romaji(), user3.getStaff_department(),
				user3.getProject_type(), user3.getJoined_year(), user3.isNew_glad_flg(), "aaaa", "bbbb",
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())

		);

	}

	public List<User> findAll() {
		// TODO 自動生成されたメソッド・スタ
		String sql = "SELECT id,staff_code,last_name,first_name,last_name_romaji"
				+ "				 ,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg"
				+ "				,created_by,updated_by,created_at,updated_at FROM staffs";
		List<Map<String, Object>> users = jdbc.queryForList(sql);
		List<User> userList = new ArrayList<User>();
		 for(Map<String, Object> eachUser: users) {
	            User user = new User();
	            user.setId((long)eachUser.get("id"));
	            user.setStaff_code((String)eachUser.get("staff_code"));
	            // UserオブジェクトをListに追加する。
				userList.add(user);
	        }

	        return userList;
	}


	

}
