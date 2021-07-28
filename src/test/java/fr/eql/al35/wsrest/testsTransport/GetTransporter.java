package fr.eql.al35.wsrest.testsTransport;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.eql.al35.wsrest.transport.TransportApplication;
import fr.eql.al35.wsrest.transport.entity.Tarif;

import fr.eql.al35.wsrest.transport.service.TransportService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TransportApplication.class})
class GetTransporter {

	@Autowired
	private TransportService transportService; 


	@Test
	@DisplayName("Transporter name La Poste should exists")	
	void TU_CalculFees_LaPoste() {
		List<Tarif> list = transportService.calculateTarifs(0.4); 
		for (int i = 0; i < list.size(); i++) {			
			assertEquals("La Poste", list.get(0).getTransporteur().getName(), "incorrect transporter Name");
		}
	}

	@Test
	@DisplayName("Transporter name Mondial Relay should exists")
	void TU_CalculFees_MondialRelay() {
		List<Tarif> list = transportService.calculateTarifs(0.4); 
		for (int i = 0; i < list.size(); i++) {			
			assertEquals("Mondial Relay", list.get(1).getTransporteur().getName(), "incorrect transporter Name");
		}
	}

	@Test
	@DisplayName("Transporter name UPS should exists ")
	void TU_CalculFees_UPS() {
		List<Tarif> list = transportService.calculateTarifs(0.4); 
		for (int i = 0; i < list.size(); i++) {		
			assertEquals("UPS", list.get(2).getTransporteur().getName(), "incorrect transporter Name");
		}
	}

	@Test
	@DisplayName("Transporter name should only be one of the list")
	void TU_CalculFees_Incorrect_transporter() {
		List<Tarif> list = transportService.calculateTarifs(0.4); 
		for (int i = 0; i < list.size(); i++) {		
			assertNotEquals("UP", list.get(2).getTransporteur().getName());			
		}
	}

	@Test
	@DisplayName("Transporter ID")
	void TU_CalculFees_ID() {
		List<Tarif> list = transportService.calculateTarifs(0.4); 
		for (int i = 0; i < list.size(); i++) {		
			assertEquals(3, list.get(2).getTransporteur().getId());
		}
	}

	@Test
	@DisplayName("Transporter List")
	void TU_CalculFees_Array() {
		int i;
		String reponseTransporteur = "";
		List<Tarif> list = transportService.calculateTarifs(0.4);		
		for (i = 0; i < list.size(); i++) {	
			reponseTransporteur += list.get(i).getTransporteur().getName();						
			
		}
		System.out.println(reponseTransporteur);
		assertThat("La PosteMondial RelayUPS").isIn(reponseTransporteur);		
	}

}

