package projet.commun.dto;



import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoEmprunt implements Serializable{
    
	
    // Champs
    
    private int         	idEmprunt;
    
	private DtoCompte demandeur;
	
	private DtoCompte receveur;
	
    private DtoDocument document;
	
	private String status;
	
	
	// Constructeurs

	public DtoEmprunt() {
		super();
	}
    
	public DtoEmprunt(int idEmprunt, DtoCompte demandeur, DtoCompte receveur, DtoDocument document, String status) {
		super();
		this.idEmprunt = idEmprunt;
		this.demandeur = demandeur;
		this.receveur = receveur;
		this.document = document;
		this.status = status;
	}
	
	public DtoEmprunt(DtoCompte demandeur, DtoCompte receveur, DtoDocument document, String status) {
		super();
		this.demandeur = demandeur;
		this.receveur = receveur;
		this.document = document;
		this.status = status;
	}
	// Getters & setters

	

	public int getIdEmprunt() {
		return idEmprunt;
	}



	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
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

	public DtoDocument getDocument() {
		return document;
	}

	public void setDocument(DtoDocument document) {
		this.document = document;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(demandeur, document, idEmprunt, receveur, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoEmprunt other = (DtoEmprunt) obj;
		return Objects.equals(demandeur, other.demandeur) && Objects.equals(document, other.document)
				&& idEmprunt == other.idEmprunt && Objects.equals(receveur, other.receveur)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Emprunt [idEmprunt=" + idEmprunt + ", demandeur=" + demandeur + ", receveur=" + receveur + ", document="
				+ document + ", status=" + status + "]";
	}
	
}
