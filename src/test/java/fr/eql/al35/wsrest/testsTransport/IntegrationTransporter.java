package fr.eql.al35.wsrest.testsTransport;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import fr.eql.al35.wsrest.service.RestTemplateHeaderModifierInterceptor;
import fr.eql.al35.wsrest.transport.TransportApplication;
import fr.eql.al35.wsrest.transport.entity.Colis;
import fr.eql.al35.wsrest.transport.entity.Tarif;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TransportApplication.class})
class IntegrationTransporter {

	private static RestTemplate restTemplate;
	private String  baseUrlWSTarfis = "http://localhost:8088/transport-rest/allTarifs/";	
	//private URI url = URI.create(baseUrlWSTarfis);

	@BeforeAll
	public static void Init() {
		restTemplate = initRestTemplate();
	} 

	public static RestTemplate initRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		}
		interceptors.add(new RestTemplateHeaderModifierInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}


	@DisplayName("get transporter")
	@Test
	void Tarif() {
		Colis colis = new Colis();
		colis.setWeight(0.4);
		String i = colis.getWeight().toString();
		String newurl = baseUrlWSTarfis + i;		
		List<Tarif>list = new ArrayList<Tarif>();		
		BeanUtils.copyProperties(restTemplate.getForObject(newurl, Tarif.class), list);		
		//list = JSON.Deserialize<Tarif>(restTemplate.getForObject(newurl, Tarif.class));
		System.out.println(list);
	}

}

