package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pl.coderslab.entity.Client;
import pl.coderslab.service.DbClient;

public class ClientDao {
	
	public static void main(String[] args) {
		
		try{
//			int id = clientAdd("Mary", "Marianna", "niewiem@poczta.com", "250356442");
//			clientDelete(3);
//			clientUpdate(4, "Bob", "Boby", "nowy@mail.com", "644321432");
			
			System.out.println(clientSelectById(5).toString());
		 	
			List<HashMap<String, String>> clients = clientGetAll();
			for (Iterator<HashMap<String, String>> iterator = clients.iterator(); iterator.hasNext();) {
			    System.out.println(iterator.next());
			}

//			for(int i = 0; i < )
//			for (HashMap<String, String> hashMap : clients) {
//				System.out.println(hashMap.get(	));
//			}
		
		} catch (Exception e){
			e.getMessage();
		}
		
	}
	
	
	static public int clientAdd(String name, String surname, String email, String phone, String birthDate) throws Exception{
		List<String> params = new ArrayList<>();
		params.add(name);
		params.add(surname);
		params.add(email);
		params.add(phone);
		params.add(birthDate);
		String query = "INSERT INTO clients(id, name, surname, email, phone, birthDate) VALUES(default, ?, ?, ?, ?, ?);";
		return DbClient.add(query, params);
	}
	
	static public void clientUpdate(int id, String name, String surname, String email, String phone, String birthDate) throws Exception{
		List<String> params = new ArrayList<>();
		params.add(name);
		params.add(surname);
		params.add(email);
		params.add(phone);
		params.add(birthDate);
		String query = "UPDATE clients SET name = ?, surname = ?, email = ?, phone = ?, birthDate = ? WHERE id = ?;";
		DbClient.update(id, query, params);
	}
	
	static public void clientDelete(int id) throws Exception{
		String query = "DELETE FROM clients WHERE id = ?;";
		DbClient.delete(id, query);
	}
	
	static public Client clientSelectById(int id) throws Exception{
		List<String> nazwyKolumn = new ArrayList<>();
		nazwyKolumn.add("name");
		nazwyKolumn.add("surname");
		nazwyKolumn.add("email");
		nazwyKolumn.add("phone");
		nazwyKolumn.add("birthDate");
		String query = "SELECT name, surname, email, phone, birthDate FROM clients WHERE id = ?;";
		List<String> obiekt = DbClient.selectById(id, query, nazwyKolumn);
		Client client = new Client();
		client.setName(obiekt.get(0));
		client.setSurname(obiekt.get(1));
		client.setEmail(obiekt.get(2));
		client.setPhone(obiekt.get(3));
		client.setBirthDate(obiekt.get(4));
		client.setId(id);
		return client;
	}
	
	static public List<HashMap<String, String>> clientGetAll() throws Exception{
		String query = "SELECT * FROM clients;";
		List<HashMap<String, String>> clients = DbClient.selectAll(query);
		return clients;
	}
	
	static public List<HashMap<String, String>> clientGetByStatus(int clientId, String status) throws Exception {
		String query = "SELECT * FROM orders WHERE client_id = " + clientId + " AND status='" + status + "';";
		List<HashMap<String, String>> employees = DbClient.selectAll(query);
		return employees;
	}
}
