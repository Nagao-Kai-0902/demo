package com.example.demo.Dao.DaoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository

public class StaffDaoImpl {
	@Autowired
	JdbcTemplate jdbc;
	Logger logger = LoggerFactory.getLogger(StaffDaoImpl.class);

	private static String USER = "system_user";

	public void newEmployee(User user) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		String sql = "INSERT INTO staffs " + "(staff_code, last_name, first_name, last_name_romaji, first_name_romaji,"
				+ "staff_department, project_type, joined_year, new_glad_flg, "
				+ "created_by, updated_by, created_at,  updated_at)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.update(sql, user.getStaff_code(), user.getLast_name(), user.getFirst_name(), user.getLast_name_romaji(),
				user.getFirst_name_romaji(), user.getStaff_department(), user.getProject_type(), user.getJoined_year(),
				user.getNew_glad_flg(), USER, USER, nowTime, nowTime);
	}

	public User findNewGladFlg(String newGladFlg) {
		Map<String, Object> staff = jdbc.queryForMap("SELECT * FROM staffs WHERE new_glad_flg = ?", newGladFlg);
		User user = new User();
		user.setId((long) staff.get("id"));
		user.setStaff_code((String) staff.get("staff_code"));
		user.setLast_name((String) staff.get("last_name"));
		user.setFirst_name((String) staff.get("first_name"));
		user.setLast_name_romaji((String) staff.get("last_name_romaji"));
		user.setFirst_name_romaji((String) staff.get("first_name_romaji"));
		user.setJoined_year((String) staff.get("joined_year"));
		user.setNew_glad_flg((Boolean) staff.get("new_glad_flg"));
		user.setStaff_department((String) staff.get("staff_department"));
		user.setProject_type((String) staff.get("project_type"));
		return user;
	}

	public List<User> findAll() {
		String sql = "SELECT id,staff_code,last_name,first_name,last_name_romaji"
				+ " ,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg"
				+ "	,created_by,updated_by,created_at,updated_at FROM staffs";
		List<Map<String, Object>> users = jdbc.queryForList(sql);
		List<User> userList = new ArrayList<User>();
		for (Map<String, Object> eachUser : users) {
			User user = new User();
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			userList.add(user);
		}
		return userList;
	}

	public List<User> findDepartment() {
		String sql = "SELECT * FROM staffs WHERE staff_department = ?"
				+ " id,staff_code,last_name,first_name,last_name_romaji"
				+ " ,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg"
				+ "	,created_by,updated_by,created_at,updated_at FROM staffs";
		List<Map<String, Object>> engineer = jdbc.queryForList(sql);
		List<User> engineerList = new ArrayList<User>();
		for (Map<String, Object> eachUser : engineer) {
			User user = new User();
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			engineerList.add(user);
		}
		return engineerList;
	}

	public List<User> findDepartment(String engineer) {
		String sql = "SELECT * FROM staffs WHERE staff_department = ?";
		List<Map<String, Object>> staffList = jdbc.queryForList(sql, engineer);
		List<User> engineerList = new ArrayList<User>();
		for (Map<String, Object> eachUser : staffList) {
			User user = new User();
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			user.setNew_glad_flg((Boolean) eachUser.get("new_glad_flg"));
			user.setProject_type((String) eachUser.get("project_type"));
			engineerList.add(user);
		}
		return engineerList;
	}

	public User selectOne(String staffCode) {
		Map<String, Object> staff = jdbc.queryForMap("SELECT * FROM staffs WHERE staff_code = ?", staffCode);
		User user = new User();
		user.setId((long) staff.get("id"));
		user.setStaff_code((String) staff.get("staff_code"));
		user.setLast_name((String) staff.get("last_name"));
		user.setFirst_name((String) staff.get("first_name"));
		user.setLast_name_romaji((String) staff.get("last_name_romaji"));
		user.setFirst_name_romaji((String) staff.get("first_name_romaji"));
		user.setJoined_year((String) staff.get("joined_year"));
		user.setNew_glad_flg((Boolean) staff.get("new_glad_flg"));
		user.setStaff_department((String) staff.get("staff_department"));
		user.setProject_type((String) staff.get("project_type"));
		return user;
	}

	public void updateOne(String staff_code_before, User user) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		String sql = "UPDATE staffs SET " + "staff_code = ? ," + "last_name = ? ," + "first_name = ? ,"
				+ "last_name_romaji = ? ," + "first_name_romaji = ? ," + "staff_department = ? ," + "project_type = ? ,"
				+ "joined_year = ? ," + "new_glad_flg = ? ," + "created_by = ? ," + "updated_by = ? ,"
				+ "created_at = ? ," + "updated_at = ? " + "WHERE staff_code = ? ";
		jdbc.update(sql, user.getStaff_code(), user.getLast_name(), user.getFirst_name(), user.getLast_name_romaji(),
				user.getFirst_name_romaji(), user.getStaff_department(), user.getProject_type(), user.getJoined_year(),
				user.getNew_glad_flg(), USER, USER, nowTime, nowTime, staff_code_before);
	}

	public User deleteOne(String staffCode) {
		Map<String, Object> staff = jdbc.queryForMap("SELECT * FROM staffs WHERE staff_code = ?", staffCode);
		User user = new User();
		user.setId((long) staff.get("id"));
		user.setStaff_code((String) staff.get("staff_code"));
		user.setLast_name((String) staff.get("last_name"));
		user.setFirst_name((String) staff.get("first_name"));
		user.setLast_name_romaji((String) staff.get("last_name_romaji"));
		user.setFirst_name_romaji((String) staff.get("first_name_romaji"));
		user.setJoined_year((String) staff.get("joined_year"));
		user.setNew_glad_flg((Boolean) staff.get("new_glad_flg"));
		user.setStaff_department((String) staff.get("staff_department"));
		user.setProject_type((String) staff.get("project_type"));
		return user;
	}

	public void destroyOne(String staff_code, User user) {
		String sql = "DELETE from staffs WHERE staff_code = ? ";
		jdbc.update(sql, staff_code);
	}

}
