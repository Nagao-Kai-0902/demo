package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private long id;

	/*
	 * バリデーションが複数ある場合にはグループ化が必要 ただエラーがどういう順で発動するのかを考えることが難しい ValidGroupはnull,空白チェック
	 * ValidGroup2はパターンチェック ValidGroup3はサイズチェック
	 */
	@NotEmpty(groups = ValidGroup.class, message = "社員コードを入力してください。")
	@Pattern(groups = ValidGroup2.class, regexp = "^[a-zA-Z0-9]+$", message = "社員コードは半角数値で入力してください。")
	@Size(groups = ValidGroup3.class, min = 4, max = 4, message = "社員コードは4文字で入力してください。")
	/* カスタム＠登録しようとしている社員コードがすでに登録されていたらエラー出力 */
	@UnUsedStaffCode(groups = ValidGroup4.class, message = "すでにその社員コードは登録されています")
	private String staff_code;

	@NotBlank(groups = ValidGroup.class, message = "姓を入力してください。")
	@Size(groups = ValidGroup3.class, max = 20, message = "姓は20文字で入力してください。")
	private String last_name;

	@NotBlank(groups = ValidGroup.class, message = "名を入力してください。")
	@Size(groups = ValidGroup3.class, max = 20, message = "名は20文字で入力してください。")
	private String first_name;

	@NotEmpty(groups = ValidGroup.class, message = "姓_ローマ字を入力してください。")
	@Pattern(groups = ValidGroup2.class, regexp = "^[a-zA-Z0-9]+$", message = "姓_ローマ字は半角英数字で入力して下さい。")
	@Size(groups = ValidGroup3.class, max = 40, message = "姓_ローマ字は40文字で入力してください。")
	private String last_name_romaji;

	@NotEmpty(groups = ValidGroup.class, message = "名_ローマ字を入力してください。")
	@Pattern(groups = ValidGroup2.class, regexp = "^[a-zA-Z0-9]+$", message = "名_ローマ字は半角英数字で入力してください。")
	@Size(groups = ValidGroup3.class, max = 40, message = "名_ローマ字は40文字で入力してください。")
	private String first_name_romaji;

	@NotEmpty(groups = ValidGroup.class, message = "所属を選択して下さい。")
	@Pattern(groups = ValidGroup2.class, regexp = "[0-9]{4}", message = "正しい値を入力してください。")
	private String staff_department;

	@Size(groups = ValidGroup3.class, max = 100, message = "案件は100文字以下で入力して下さい。")
	private String project_type;

	@NotEmpty(groups = ValidGroup.class, message = "入社年を入力してください。")
	@Pattern(groups = ValidGroup2.class, regexp = "^[0-9]{4}\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12][0-9]|3[01])$", message = "入社年は「yyyy/MM/dd」の形式で入力して下さい。")
	private String joined_year;

	@NotTrueFalse(groups = ValidGroup.class,message = "正しい値を入力してください。") 
	/*
	 * @AssertTrue(message = "正しい値を入力してください。")
	 * 
	 * @AssertFalse(message = "正しい値を入力してください。")
	 */
	private boolean new_glad_flg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaff_code() {
		return staff_code;
	}

	public void setStaff_code(String staff_code) {
		this.staff_code = staff_code;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name_romaji() {
		return last_name_romaji;
	}

	public void setLast_name_romaji(String last_name_romaji) {
		this.last_name_romaji = last_name_romaji;
	}

	public String getFirst_name_romaji() {
		return first_name_romaji;
	}

	public void setFirst_name_romaji(String first_name_romaji) {
		this.first_name_romaji = first_name_romaji;
	}

	public String getStaff_department() {
		return staff_department;
	}

	public void setStaff_department(String staff_department) {
		this.staff_department = staff_department;
	}

	public String getProject_type() {
		return project_type;
	}

	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}

	public String getJoined_year() {
		return joined_year;
	}

	public void setJoined_year(String joined_year) {
		this.joined_year = joined_year;
	}

	public boolean getNew_glad_flg() {
		return new_glad_flg;
	}

	public void setNew_glad_flg(boolean new_glad_flg) {
		this.new_glad_flg = new_glad_flg;
	}

}
