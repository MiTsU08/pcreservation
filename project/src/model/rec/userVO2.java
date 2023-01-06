package model.rec;


public class userVO2 {
	String password;
	String tel;
	String email;
	
	public userVO2() {}
	
	public userVO2(String password,String tel,String email) {
		this.password=password;
		this.tel=tel;
		this.email=email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
