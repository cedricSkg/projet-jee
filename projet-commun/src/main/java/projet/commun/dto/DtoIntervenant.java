package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoIntervenant implements Serializable{
	
	private int idIntervenant;
	
	private String nom;
	
	private String status;

	public DtoIntervenant() {
		super();
	}

	public DtoIntervenant(int idIntervenant, String nom, String status) {
		super();
		this.idIntervenant = idIntervenant;
		this.nom = nom;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idIntervenant, nom, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoIntervenant other = (DtoIntervenant) obj;
		return idIntervenant == other.idIntervenant && Objects.equals(nom, other.nom)
				 && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Intervenant [idIntervenant=" + idIntervenant + ", nom=" + nom + ", status="
				+ status + "]";
	}

}

