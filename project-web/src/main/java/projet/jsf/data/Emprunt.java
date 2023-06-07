package projet.jsf.data;

import java.util.Objects;

public class Emprunt {
    
	
    // Champs
    
    private int         	idEmprunt;
    
	private Compte demandeur;
	
	private Compte receveur;
	
    private Document document;
	
	private String status;
	
	
	// Constructeurs

	public Emprunt() {
		super();
	}
    
	public Emprunt(int idEmprunt, Compte demandeur, Compte receveur, Document document, String status) {
		super();
		this.idEmprunt = idEmprunt;
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



	public Compte getDemandeur() {
		return demandeur;
	}



	public void setDemandeur(Compte demandeur) {
		this.demandeur = demandeur;
	}



	public Compte getReceveur() {
		return receveur;
	}



	public void setReceveur(Compte receveur) {
		this.receveur = receveur;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
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
		Emprunt other = (Emprunt) obj;
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
