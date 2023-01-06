package model.rec;

public class SignUp1VO {
	private String id;
	private String password;
	private String pw_check;
	private String name;
	private String social_num;
	int USER_CODE;
	private String tel;
	private String email;
	
	public SignUp1VO() {
		
	};
	
	public SignUp1VO(String id, String password, String name, String social_num, String tel, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.social_num = social_num;
		this.tel = tel;
		this.email = email;
	}

	
	public int getUSER_CODE() {
		return USER_CODE;
	}

	public void setUSER_CODE(int USER_CODE) {
		this.USER_CODE = USER_CODE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPw_check() {
		return pw_check;
	}

	public void setPw_check(String pw_check) {
		this.pw_check = pw_check;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocial_num() {
		return social_num;
	}

	public void setSocial_num(String social_num) {
		this.social_num = social_num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SignUp1VO [id=" + id + ", password=" + password + ", pw_check=" + pw_check + ", name=" + name
				+ ", social_num=" + social_num + ", tel=" + tel + ", email=" + email + "]";
	}

	
}
