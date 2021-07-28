package fr.eql.al35.wsrest.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eql.al35.wsrest.transport.entity.Tarif;
import fr.eql.al35.wsrest.transport.entity.Transporteur;
import fr.eql.al35.wsrest.transport.service.TransportService;

@RestController
@RequestMapping(value="/transport-rest", headers="Accept=application/json")
public class TransportController {

	@Autowired
	private TransportService transportService;

	@GetMapping("/transporteur/{idTransporteur}") //localhost:8088/transport-rest/transporteur/2
	public Transporteur getTransporteurById(@PathVariable("idTransporteur") Integer idTransporteur) {
		return transportService.findById(idTransporteur);
	}

	@GetMapping("/allTarifs/{weight}") //localhost:8088/transport-rest/allTarifs/9.6
	public List<Tarif> displayAllTarifs(@PathVariable("weight") Double weight) {
		return transportService.calculateTarifs(weight);
	}
	
	@GetMapping("/tarif/{idTarif}") // http://localhost:8088/transport-rest/tarif/9
	public Tarif getTarifById(@PathVariable("idTarif") Integer id) {
		return transportService.getTarifById(id);
	}

}
