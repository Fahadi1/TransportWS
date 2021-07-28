package fr.eql.al35.wsrest.transport.dto;

import java.io.Serializable;

import fr.eql.al35.wsrest.transport.entity.Transporteur;
import lombok.Data;

@Data
public class ResTarif implements Serializable {

	private static final long serialVersionUID = 1L;

	private Transporteur transporteur;
	private Double price;
	private Double weight;

}
