package pl.coderslab.entity;

public class Car {
	private int id;
	private String make;
	private String model;
	private String year;
	private String registration;
	private String service;
	private String client_id;
	
	public Car(){
	}

	public Car(int id, String make, String model, String year, String registration, String service,
			String client_id) {
		setMake(make);
		setModel(model);
		setYear(year);
		setRegistration(registration);
		setService(service);
		setClient_id(client_id);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public void add(Car vehicle) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", registration"
				+ registration + ", service=" + service + ", client_id=" + client_id + "]";
	}

}