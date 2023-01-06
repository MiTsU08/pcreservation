package model.rec;


public class userVO4 {
	String password;
	String name;
	String tel;
	String email;
	
	userVO4(){}
	
	userVO4(String password,String name,String tel,String email){
		this.password=password;
		this.name=name;
		this.tel=tel;
		this.email=email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
