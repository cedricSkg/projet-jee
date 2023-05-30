package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Amis implements Serializable {

	// Champs

	private Integer idDemandeur;

	private Integer idReceveur;
	
	private int idAmis;
	
	private String status;

	// Constructeurs

	public Amis() {
	}

	public Amis(Integer idDemandeur, Integer idReceveur, int idAmis, String status) {
		super();
		this.idDemandeur = idDemandeur;
		this.idReceveur = idReceveur;
		this.idAmis = idAmis;
		this.status = status;
	}

	// Getters & setters

	public Integer getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(Integer idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public Integer getIdReceveur() {
		return idReceveur;
	}

	public void setIdReceveur(Integer idReceveur) {
		this.idReceveur = idReceveur;
	}

	public int getIdAmis() {
		return idAmis;
	}

	public void setIdAmis(int idAmis) {
		this.idAmis = idAmis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Amis [idDemandeur=" + idDemandeur + ", idReceveur=" + idReceveur + ", idAmis=" + idAmis + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAmis, idDemandeur, idReceveur, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amis other = (Amis) obj;
		return idAmis == other.idAmis && Objects.equals(idDemandeur, other.idDemandeur)
				&& Objects.equals(idReceveur, other.idReceveur) && Objects.equals(status, other.status);
	}
	
	

}
