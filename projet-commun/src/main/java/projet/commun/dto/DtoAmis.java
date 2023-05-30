package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoAmis implements Serializable {

	// Champs

	private int idDemandeur;

	private int idReceveur;
	
	private int idAmis;
	
	private String status;

	// Constructeurs

	public DtoAmis() {
	}

	public DtoAmis(int idDemandeur, int idReceveur, String status) {
		super();
		this.idDemandeur = idDemandeur;
		this.idReceveur = idReceveur;
		this.status = status;
	}
	
	public DtoAmis(int idAmis, int idDemandeur, int idReceveur, String status) {
		super();
		this.idAmis = idAmis;
		this.idDemandeur = idDemandeur;
		this.idReceveur = idReceveur;
		this.status = status;
	}
	// Getters & setters
	public int getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(int idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public int getIdReceveur() {
		return idReceveur;
	}

	public void setIdReceveur(int idReceveur) {
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
		return "DtoAmis [idDemandeur=" + idDemandeur + ", idReceveur=" + idReceveur + ", idAmis=" + idAmis + ", status="
				+ status + "]";
	}
	
	
}
