package pl.coderslab.entity;

public class Worker {

	private int id;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String note;
	private String man_hour;

	
	public Worker(){
	}
	
	public Worker(int id, String name, String surname, String address, String phone, String note, String man_hour) {
		setId(id);
		setName(name);
		setSurname(surname);
		setAddress(address);
		setPhone(phone);
		setNote(note);
		setMan_hour(man_hour);
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMan_hour() {
		return man_hour;
	}

	public void setMan_hour(String man_hour) {
		this.man_hour = man_hour;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ",address=" + address + ", phone="
				+ phone + ", note=" + note + ", man_hour=" + man_hour + "]";
	}

}
