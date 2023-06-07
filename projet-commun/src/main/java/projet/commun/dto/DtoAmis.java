package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoAmis implements Serializable{
    
	
    // Champs
    
    private int         	idAmis;
    
	private DtoCompte demandeur;
	
	private DtoCompte receveur;
	
	private String status;
	
	
	// Constructeurs

	public DtoAmis() {
		super();
	}
    
    
    
    public DtoAmis(int idAmis, DtoCompte demandeur, DtoCompte receveur, String status) {
		super();
		this.idAmis = idAmis;
		this.demandeur = demandeur;
		this.receveur = receveur;
		this.status = status;
	}
    
    public DtoAmis(DtoCompte demandeur, DtoCompte receveur, String status) {
		super();
		this.demandeur = demandeur;
		this.receveur = receveur;
		this.status = status;
	}



	// Getters & setters

	

	public int getIdAmis() {
		return idAmis;
	}



	public void setIdAmis(int idAmis) {
		this.idAmis = idAmis;
	}



	public DtoCompte getDemandeur() {
		return demandeur;
	}



	public void setDemandeur(DtoCompte demandeur) {
		this.demandeur = demandeur;
	}



	public DtoCompte getReceveur() {
		return receveur;
	}



	public void setReceveur(DtoCompte receveur) {
		this.receveur = receveur;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		return Objects.hash(demandeur, idAmis, receveur, status);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoAmis other = (DtoAmis) obj;
		return Objects.equals(demandeur, other.demandeur) && idAmis == other.idAmis
				&& Objects.equals(receveur, other.receveur) && Objects.equals(status, other.status);
	}
	
	
	@Override
	public String toString() {
		return "DtoAmis [idAmis=" + idAmis + ", demandeur=" + demandeur + ", receveur=" + receveur + ", status=" + status
				+ "]";
	}
	
}
