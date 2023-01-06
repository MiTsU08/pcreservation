package model.rec;

public class LoginVO {
	String id;
	String password;
	int usercode;

	public LoginVO() {
	}

	public LoginVO(String id, String password) {
		this.id = id;
		this.password = password;

	}
//	public LoginVO(String id, String password, int usercode) {
//		this.id = id;
//		this.password = password;
//		this.usercode = usercode;
//		
//	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
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

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + ", usercode=" + usercode + "]";
	}

}
