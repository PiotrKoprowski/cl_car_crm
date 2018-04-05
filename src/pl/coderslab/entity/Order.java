package pl.coderslab.entity;

public class Order {
	private int id;
	private String orderDate;
	private String startingDate;
	private String worker_id;
	private String problemDescription;
	private String repairDescription;
	private String status;
	private String car_id;
	private String fullCost;
	private String partsCost;
	private String workers_manHour;
	private String amoutManHour;
	private String client_id;

	public Order() {
	}

	public Order(String orderDate, String startingDate, String worker_id, String problemDescription,
			String repairDescription, String status, String car_id, String fullCost, String partsCost, String workers_manHour,
			String amoutManHour, String client_id) {
		setOrderDate(orderDate);
		setStartingDate(startingDate);
		setWorker_id(worker_id);
		setProblemDescription(problemDescription);
		setRepairDescription(repairDescription);
		setStatus(status);
		setCar_id(car_id);
		setFullCost(fullCost);
		setPartsCost(partsCost);
		setWorkers_manHour(workers_manHour);
		setAmoutManHour(amoutManHour);
		setClient_id(client_id);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getRepairDescription() {
		return repairDescription;
	}

	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getFullCost() {
		return fullCost;
	}

	public void setFullCost(String fullCost) {
		this.fullCost = fullCost;
	}

	public String getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(String partsCost) {
		this.partsCost = partsCost;
	}

	public String getWorkers_manHour() {
		return workers_manHour;
	}

	public void setWorkers_manHour(String workers_manHour) {
		this.workers_manHour = workers_manHour;
	}

	public String getAmoutManHour() {
		return amoutManHour;
	}

	public void setAmoutManHour(String amoutManHour) {
		this.amoutManHour = amoutManHour;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", startingDate=" + startingDate + ", worker_id="
				+ worker_id + ", problemDescription=" + problemDescription + ", repairDescription=" + repairDescription
				+ " ,status=" + status + ", car_id=" + car_id + ", fullCost=" + fullCost + ", partsCost=" + partsCost + ", workers_manHour="
				+ workers_manHour + ", amoutManHour=" + amoutManHour + ", client_id=" + client_id + "]";
	}

}
