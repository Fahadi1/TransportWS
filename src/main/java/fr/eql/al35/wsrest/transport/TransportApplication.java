package fr.eql.al35.wsrest.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
		
		System.out.println("http://localhost:8088");
		System.out.println("http://localhost:8088/transport-rest/allTarifs.html");
		
	}

}
