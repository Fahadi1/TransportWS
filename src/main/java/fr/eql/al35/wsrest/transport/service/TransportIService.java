package fr.eql.al35.wsrest.transport.service;

import java.util.List;

import fr.eql.al35.wsrest.transport.entity.Tarif;
import fr.eql.al35.wsrest.transport.entity.Transporteur;

public interface TransportIService {

	public List<Tarif> calculateTarifs(Double weight);
	public Transporteur findById(Integer id);
	public Tarif getTarifById(Integer id);

}
