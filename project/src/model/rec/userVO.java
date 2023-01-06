package model.rec;


public class userVO {
	String id;
	String password;
	String socialNum;
	String tel;
	String email;
	
	public userVO() {
		
	}
	
	public userVO(String id,String password,String socialNum,String tel,String email) {
		this.id=id;
		this.password=password;
		this.socialNum=socialNum;
		this.tel=tel;
		this.email=email;
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

	public String getSocialNum() {
		return socialNum;
	}

	public void setSocialNum(String socialNum) {
		this.socialNum = socialNum;
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
