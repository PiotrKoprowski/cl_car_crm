package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pl.coderslab.entity.Worker;
import pl.coderslab.service.DbClient;

public class WorkerDao {

	public static void main(String[] args) {
		try {
//			workerAdd("Wojtek", "Kozlowski", "Warszawa", "72189102", "notka", "44");
			System.out.println(workerSelectById(2).toString());
			
//			List<HashMap<String, String>> workers = workerGetAll();
//			for (Iterator<HashMap<String, String>> iterator = workers.iterator(); iterator.hasNext();) {
//			    System.out.println(iterator.next());
//			}
		} catch (Exception e) {
			System.out.println("Nie przypisano parametrow");
			e.printStackTrace();
		}

	}

	static public int workerAdd(String name, String surname, String address, String phone, String note,
			String man_hour) throws Exception {

		List<String> params = new ArrayList<>();

		params.add(name);
		params.add(surname);
		params.add(address);
		params.add(phone);
		params.add(note);
		params.add(man_hour);

		String query = "INSERT INTO workers(id, name, surname, address, phone," + "note,man_hour) "
				+ "VALUES(default, ?, ?, ?, ?, ?, ?);";

		return DbClient.add(query, params);
	}

	static public void workerUpdate(int id, String name, String surname, String address, String phone, String note,
			String man_hour) throws Exception {

		List<String> params = new ArrayList<>();

		params.add(name);
		params.add(surname);
		params.add(address);
		params.add(phone);
		params.add(note);
		params.add(man_hour);

		String query = "UPDATE workers SET name = ?, surname = ?, address = ?, phone = ?, "
				+ "note = ?, man_hour = ? WHERE id = ?;";
		DbClient.update(id, query, params);
	}

	static public void workerDelete(int id) throws Exception {
		String query = "DELETE FROM workers WHERE id = ?;";
		DbClient.delete(id, query);
	}

	static public Worker workerSelectById(int id) throws Exception {

		List<String> columnNames = new ArrayList<>();
		columnNames.add("name");
		columnNames.add("surname");
		columnNames.add("address");
		columnNames.add("phone");
		columnNames.add("note");
		columnNames.add("man_hour");

		String query = "SELECT name, surname, address, phone, " + "note, man_hour " + "FROM workers WHERE id = ?;";

		List<String> object = DbClient.selectById(id, query, columnNames);
		Worker employee = new Worker();
		employee.setName(object.get(0));
		employee.setSurname(object.get(1));
		employee.setAddress(object.get(2));
		employee.setPhone(object.get(3));
		employee.setNote(object.get(4));
		employee.setMan_hour(object.get(5));
		employee.setId(id);
		return employee;
	}

	static public List<HashMap<String, String>> workerGetAll() throws Exception {
		String query = "SELECT * FROM workers;";
		List<HashMap<String, String>> employees = DbClient.selectAll(query);
		return employees;
	}
	
	static public List<HashMap<String, String>> workerGetByStatus(int foreignId, String status) throws Exception {
		String query = "SELECT * FROM orders WHERE worker_id = " + foreignId + " AND status='" + status + "';";
		List<HashMap<String, String>> employees = DbClient.selectAll(query);
		return employees;
	}

}
