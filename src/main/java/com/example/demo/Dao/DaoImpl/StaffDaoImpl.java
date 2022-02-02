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
				+ "(staff_code, last_name, first_name, last_name_romaji, first_name_romaji,"
				+ "staff_department, project_type, joined_year, new_glad_flg, "
				+ "created_by, updated_by, created_at,  updated_at)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.update(sql, user.getStaff_code(), user.getLast_name(), user.getFirst_name(),
				user.getLast_name_romaji(), user.getFirst_name_romaji(), user.getStaff_department(),
				user.getProject_type(), user.getJoined_year(), user.getNew_glad_flg(),
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
		for (Map<String, Object> eachUser : users) {
			User user = new User();
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			// UserオブジェクトをListに追加する。
			userList.add(user);
		}

		return userList;
	}

	public List<User> findDepartment() { // staff_departmentの値を取得してきたい

		String sql = "SELECT * FROM staffs WHERE staff_department = ?" // WHERE文、？にすることでさまざまな値に対応
				+ " id,staff_code,last_name,first_name,last_name_romaji"
				+ " ,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg"
				+ "	,created_by,updated_by,created_at,updated_at FROM staffs";
		List<Map<String, Object>> engineer = jdbc.queryForList(sql);// sqlテーブルのデータを全件取得
		List<User> engineerList = new ArrayList<User>();// 結果返却用の変数
		for (Map<String, Object> eachUser : engineer) { // 取得したデータを結果返却用のListに格納していく
			User user = new User();// Userインスタンスの生成
			// Userインスタンスに取得したデータをセットする
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			// UserオブジェクトをListに追加する。
			engineerList.add(user);
		}

		return engineerList;
	}

	public static String getUSER() {
		return USER;
	}

	public static void setUSER(String user) {
		USER = user;
	}

	public List<User> findDepartment(String engineer) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT * FROM staffs WHERE staff_department = ?"; // WHERE文、？にすることでさまざまな値に対応
		List<Map<String, Object>> staffList = jdbc.queryForList(sql, engineer); // sqlテーブルのデータを全件取得
		List<User> engineerList = new ArrayList<User>();// 結果返却用の変数
		for (Map<String, Object> eachUser : staffList) { // 取得したデータを結果返却用のengineerListに格納していく
			User user = new User();// Userインスタンスの生成
			// Userインスタンスに取得したデータをセットする
			user.setStat_count((String) eachUser.get("stat.count"));
			user.setId((long) eachUser.get("id"));
			user.setStaff_code((String) eachUser.get("staff_code"));
			user.setLast_name((String) eachUser.get("last_name"));
			user.setFirst_name((String) eachUser.get("first_name"));
			user.setLast_name_romaji((String) eachUser.get("last_name_romaji"));
			user.setFirst_name_romaji((String) eachUser.get("first_name_romaji"));
			user.setJoined_year((String) eachUser.get("joined_year"));
			user.setNew_glad_flg((Boolean) eachUser.get("new_glad_flg"));
			user.setProject_type((String) eachUser.get("project_type"));
			// UserオブジェクトをListに追加する。
			engineerList.add(user);
		}
		return engineerList; // staffListを呼び出し元に返す（今回はServiceclassに）
	}

}
