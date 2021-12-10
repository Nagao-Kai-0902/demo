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

public class StaffDaoImpl {
	@Autowired
	 JdbcTemplate jdbc;

	private static String USER = "system_user";
	
	public void newEmployee(User user) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		
	    String sql = "INSERT INTO staffs "
	    + "(id, staff_code, last_name, first_name, last_name_romaji, first_name_romaji,"
	    + "staff_department, project_type, joined_year, new_glad_flg,) "
	    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    jdbc.update(
	        sql,
	        user.getId(),
	        user.getStaff_code(),
	        user.getLast_name(),
	        user.getFirst_name(),
	        user.getLast_name_romaji(),
	        user.getFirst_name_romaji(),
	        user.getStaff_department(),
	        user.getProject_type(),
	        user.getJoined_year(),
	        user.isNew_glad_flg(),
	        USER, // created_by
	        USER, // updated_by
	        nowTime, // created_at
	        nowTime // updated_at
	    );
	}

	public List<User> findAll() {
		
		String sql = "SELECT id,staff_code,last_name,first_name,last_name_romaji"
				+ " ,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg"
				+ "	,created_by,updated_by,created_at,updated_at FROM staffs";
		List<Map<String, Object>> users = jdbc.queryForList(sql);
		List<User> userList = new ArrayList<User>();
		 for(Map<String, Object> eachUser: users) {
	            User user = new User();
	            user.setId((long)eachUser.get("id"));
	            user.setStaff_code((String)eachUser.get("staff_code"));
	            user.setLast_name((String)eachUser.get("last_name"));
		        user.setFirst_name((String)eachUser.get("first_name"));
		        user.setLast_name_romaji((String)eachUser.get("last_name_romaji"));
		        user.setFirst_name_romaji((String)eachUser.get("first_name_romaji"));
		        user.setJoined_year((String)eachUser.get("joined_year"));
	            // UserオブジェクトをListに追加する。
				userList.add(user);
	        }

	        return userList;
	}

	public static String getUSER() {
		return USER;
	}

	public static void setUSER(String uSER) {
		USER = uSER;
	}

}
