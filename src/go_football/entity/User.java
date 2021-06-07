package go_football.entity;

public class User {
	private static int idCounter = 0;
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String location;
	
	public User(String name, String password, String email, String phone, String location) {
		this.id = idCounter;
		idCounter += 1;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", location=" + location + "]";
	}

}
