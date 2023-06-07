package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="intervenant")
public class Intervenant {
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column(name="id_intervenant")
	private int idIntervenant;
	
	private String nom;
	
	private String prenom;
	
	private String status;

	public Intervenant() {
		super();
	}

	public Intervenant(int idIntervenant, String nom, String prenom, String status) {
		super();
		this.idIntervenant = idIntervenant;
		this.nom = nom;
		this.prenom = prenom;
		this.status = status;
	}

	public int getIdIntervenant() {
		return idIntervenant;
	}

	public void setIdIntervenant(int idIntervenant) {
		this.idIntervenant = idIntervenant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idIntervenant, nom, prenom, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intervenant other = (Intervenant) obj;
		return idIntervenant == other.idIntervenant && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Intervenant [idIntervenant=" + idIntervenant + ", nom=" + nom + ", prenom=" + prenom + ", status="
				+ status + "]";
	}

}
