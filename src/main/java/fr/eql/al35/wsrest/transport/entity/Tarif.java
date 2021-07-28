package fr.eql.al35.wsrest.transport.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Tarif implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double price;
	private Double minWeight;
	private Double maxWeight;

	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "transporteur_id")
	private Transporteur transporteur;

	@Override
	public String toString() {
		return "Tarif [id=" + id + ", price=" + price + ", minWeight=" + minWeight + ", maxWeight=" + maxWeight
				+ ", transporteur=" + transporteur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxWeight == null) ? 0 : maxWeight.hashCode());
		result = prime * result + ((minWeight == null) ? 0 : minWeight.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transporteur == null) ? 0 : transporteur.hashCode());
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
		Tarif other = (Tarif) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxWeight == null) {
			if (other.maxWeight != null)
				return false;
		} else if (!maxWeight.equals(other.maxWeight))
			return false;
		if (minWeight == null) {
			if (other.minWeight != null)
				return false;
		} else if (!minWeight.equals(other.minWeight))
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
		return true;
	}


}
