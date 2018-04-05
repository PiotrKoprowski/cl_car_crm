package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pl.coderslab.entity.Order;
import pl.coderslab.service.DbClient;

public class OrderDao {
	
	public static void main(String[] args) {
		try{
//		int id = orderAdd("2018-02-28", "2", "problem", "fix problem", "1", "1250", "1000", "12", "300", "1");
//		System.out.println(orderSelectById(id).toString());
		System.out.println(orderSelectById(3).toString());
		orderUpdate(3, "2018-01-15", "2018-02-22", "2", "got a problem", "repair this", "Przyjety", "3", "1525", "982", "15", "5", "1");
		orderAdd("2018-03-20", "2", "this is problem", "fix this problem", "Przyjety", "5", "120", "10", "12", "52", "1");
		List<HashMap<String, String>> orders = orderGetAll();
		for (Iterator<HashMap<String, String>> iterator = orders.iterator(); iterator.hasNext();) {
		    System.out.println(iterator.next());
		}
		
		} catch(Exception e){
			e.getMessage();
		}
	}

	static public int orderAdd(String startingDate, String worker_id, String problemDescription,
			String repairDescription, String status, String car_id, String fullCost, String partsCost, String workers_manHour,
			String amoutManHour, String client_id) throws Exception {
		List<String> params = new ArrayList<>();
		params.add(startingDate);
		params.add(worker_id);
		params.add(problemDescription);
		params.add(repairDescription);
		params.add(status);
		params.add(car_id);
		params.add(fullCost);
		params.add(partsCost);
		params.add(workers_manHour);
		params.add(amoutManHour);
		params.add(client_id);
		String query = "INSERT INTO orders(id, orderDate, startingDate, worker_id, problemDescription,"
				+ " repairDescription, status, car_id, fullCost, partsCost, workers_manHour, amoutManHour, client_id) "
				+ "VALUES(default, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		return DbClient.add(query, params);
	}

	static public void orderUpdate(int id, String orderDate, String startingDate, String worker_id,
			String problemDescription, String repairDescription, String status, String car_id, String fullCost, String partsCost,
			String workers_manHour, String amoutManHour, String client_id) throws Exception {
		List<String> params = new ArrayList<>();
		params.add(orderDate);
		params.add(startingDate);
		params.add(worker_id);
		params.add(problemDescription);
		params.add(repairDescription);
		params.add(status);
		params.add(car_id);
		params.add(fullCost);
		params.add(partsCost);
		params.add(workers_manHour);
		params.add(amoutManHour);
		params.add(client_id);
		String query = "UPDATE orders SET orderDate = ?, startingDate = ?, worker_id = ?, problemDescription = ?, "
				+ "repairDescription = ?, status = ?, car_id = ?, fullCost = ?, partsCost = ?, workers_manHour = ?, "
				+ "amoutManHour = ?, client_id = ? WHERE id = ?;";
		DbClient.update(id, query, params);
	}
	
	static public void orderDelete(int id) throws Exception{
		String query = "DELETE FROM orders WHERE id = ?;";
		DbClient.delete(id, query);
	}
	
	static public Order orderSelectById(int id) throws Exception{
		List<String> columnNames = new ArrayList<>();
		columnNames.add("orderDate");
		columnNames.add("startingDate");
		columnNames.add("worker_id");
		columnNames.add("problemDescription");
		columnNames.add("repairDescription");
		columnNames.add("status");
		columnNames.add("car_id");
		columnNames.add("fullCost");
		columnNames.add("partsCost");
		columnNames.add("workers_manHour");
		columnNames.add("amoutManHour");
		columnNames.add("client_id");
		String query = "SELECT orderDate, startingDate, worker_id, problemDescription, " +
				"repairDescription, status, car_id, fullCost, partsCost, workers_manHour, amoutManHour, client_id " +
				"FROM orders WHERE id = ?;";
		List<String> object = DbClient.selectById(id, query, columnNames);
		Order order = new Order();
		order.setOrderDate(object.get(0));
		order.setStartingDate(object.get(1));
		order.setWorker_id(object.get(2));
		order.setProblemDescription(object.get(3));
		order.setRepairDescription(object.get(4));
		order.setStatus(object.get(5));
		order.setCar_id(object.get(6));
		order.setFullCost(object.get(7));
		order.setPartsCost(object.get(8));
		order.setWorkers_manHour(object.get(9));
		order.setAmoutManHour(object.get(10));
		order.setClient_id(object.get(11));
		order.setId(id);
		return order;
	}

	static public List<HashMap<String, String>> orderGetAll() throws Exception{
		String query = "SELECT * FROM orders;";
		List<HashMap<String, String>> orders = DbClient.selectAll(query);
		return orders;
	}
	
}
