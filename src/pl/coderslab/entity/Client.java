package pl.coderslab.entity;

public class Client {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String birthDate;


	public Client(){
	}
	
	public Client(String name, String surname, String email, String phone, String birthDate) {
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPhone(phone);
		setBirthDate(birthDate);
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public int getId() {
		return id;
	}
	

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname 
				+ ", email=" + email + ", phone=" + phone + ", birth date=" + birthDate + "]";
	}

}
