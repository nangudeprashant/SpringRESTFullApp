package com.javaLive.main;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.javaLive.model.User;

public class RestTestClient {
	public static final String REST_SERVICE_URI = "http://localhost:8080/SpringMVCRESTFullApp/user";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllUsers() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/list",
				List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ", Name=" + map.get("name") + ", Age="
						+ map.get("age") + ", Salary=" + map.get("salary"));
				;
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	/* GET */
	private static void getUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/getUser/1", User.class);
		System.out.println(user);
	}

	/* POST */
	private static void createUser() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0, "Sarah", 51, 134);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/createUser", user, User.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/* PUT */
	private static void updateUser() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1, "Tomy", 33, 70000);
		restTemplate.put(REST_SERVICE_URI + "/updateUser/1", user);
		System.out.println(user);
	}

	/* DELETE */
	private static void deleteUser() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/deleteUser/3");
	}

	/* DELETE ALL*/
	private static void deleteAllUsers() {
		System.out.println("Testing all delete Users API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/deleteAllUsers");
	}

	public static void main(String args[]) {
		listAllUsers();
		getUser();
		createUser();
		listAllUsers();
		updateUser();
		listAllUsers();
		deleteUser();
		listAllUsers();
		//deleteAllUsers();
		listAllUsers();
	}
}
