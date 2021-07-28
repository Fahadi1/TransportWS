package fr.eql.al35.wsrest.transport.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Colis implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private Double weight;
	private Double price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transporteur_id")
	private Transporteur transporteur;

	@Override
	public String toString() {
		return "Colis [id=" + id + ", weight=" + weight + ", price=" + price + ", transporteur=" + transporteur + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transporteur == null) ? 0 : transporteur.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colis other = (Colis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (transporteur == null) {
			if (other.transporteur != null)
				return false;
		} else if (!transporteur.equals(other.transporteur))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}



}
