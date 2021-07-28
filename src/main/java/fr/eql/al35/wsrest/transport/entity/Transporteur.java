package fr.eql.al35.wsrest.transport.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Transporteur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer deliveryRange; //délai de livraison

	@JsonIgnore
	@OneToMany(mappedBy = "transporteur",  cascade=CascadeType.ALL)
	private List<Tarif> tarifs;

	@Override
	public String toString() {
		return "Transporteur [id=" + id + ", name=" + name + ", deliveryRange=" + deliveryRange + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryRange == null) ? 0 : deliveryRange.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Transporteur other = (Transporteur) obj;
		if (deliveryRange == null) {
			if (other.deliveryRange != null)
				return false;
		} else if (!deliveryRange.equals(other.deliveryRange))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
