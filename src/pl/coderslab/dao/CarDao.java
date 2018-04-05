package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pl.coderslab.entity.Car;
import pl.coderslab.service.DbClient;

public class CarDao {
	
	public static void main(String[] args) {
		try {
			carAdd("Ford", "Focus", "1992", "KR-943W", "2018-11-25", "1");
			
			List<HashMap<String, String>> cars = carGetAll();
			for (Iterator<HashMap<String, String>> iterator = cars.iterator(); iterator.hasNext();) {
			    System.out.println(iterator.next());
			}
		} catch (Exception e) {
			System.out.println("Nie przypisano parametrow");
			e.printStackTrace();
		}

	}

	static public int carAdd(String make, String model, String year, String registration, String service,
			String client_id) throws Exception {

		List<String> params = new ArrayList<>();

		params.add(make);
		params.add(model);
		params.add(year);
		params.add(registration);
		params.add(service);
		params.add(client_id);

		String query = "INSERT INTO cars (id, make, model, year, registration," + "service, client_id) "
				+ "VALUES(default, ?, ?, ?, ?, ?, ?);";
		return DbClient.add(query, params);
	}

	static public void carUpdate(int id, String make, String model, String year, String registration,
			String service, String client_id) throws Exception {

		List<String> params = new ArrayList<>();

		params.add(make);
		params.add(model);
		params.add(year);
		params.add(registration);
		params.add(service);
		params.add(client_id);

		String query = "UPDATE cars SET make = ?, model = ?, year = ?, registration = ?, "
				+ "service = ?, client_id = ? WHERE id = ?;";
		DbClient.update(id, query, params);
	}

	static public void carDelete(int id) throws Exception {
		String query = "DELETE FROM cars WHERE id = ?;";
		DbClient.delete(id, query);
	}

	static public Car carSelectById(int id) throws Exception {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("make");
		columnNames.add("model");
		columnNames.add("year");
		columnNames.add("registration");
		columnNames.add("service");
		columnNames.add("client_id");

		String query = "SELECT make, model, year, registration, " + "service, client_id " + "FROM cars WHERE id = ?;";

		List<String> object = DbClient.selectById(id, query, columnNames);
		Car vehicle = new Car();
		vehicle.setMake(object.get(0));
		vehicle.setModel(object.get(1));
		vehicle.setYear(object.get(2));
		vehicle.setRegistration(object.get(3));
		vehicle.setService(object.get(4));
		vehicle.setClient_id(object.get(5));
		vehicle.setId(id);
		return vehicle;
	}

	static public List<HashMap<String, String>> carGetAll() throws Exception {
		String query = "SELECT * FROM cars;";
		List<HashMap<String, String>> vehiclees = DbClient.selectAll(query);
		return vehiclees;
	}
	
	static public List<HashMap<String, String>> carGetByStatus(int carId, String status) throws Exception {
		String query = "SELECT * FROM orders WHERE car_id = " + carId + " AND status='" + status + "';";
		List<HashMap<String, String>> employees = DbClient.selectAll(query);
		return employees;
	}

}
