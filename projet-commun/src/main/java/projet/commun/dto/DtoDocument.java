package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoDocument implements Serializable {

	// Champs

	private int idDocument;

	private String sujet;
	
	private String url;
	
	private DtoIntervenant auteur;
	
	private DtoIntervenant editeur;

	// Constructeurs

	public DtoDocument() {
		super();
	}
    
	
    
    public DtoDocument(int id_document, String sujet, String url, DtoIntervenant auteur, DtoIntervenant editeur) {
		super();
		this.idDocument = id_document;
		this.sujet = sujet;
		this.url = url;
		this.auteur = auteur;
		this.editeur = editeur;
	}
    


	// Getters & setters
	
	public int getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}



	public DtoIntervenant getAuteur() {
		return auteur;
	}



	public void setAuteur(DtoIntervenant auteur) {
		this.auteur = auteur;
	}



	public DtoIntervenant getEditeur() {
		return editeur;
	}



	public void setEditeur(DtoIntervenant editeur) {
		this.editeur = editeur;
	}



	@Override
	public int hashCode() {
		return Objects.hash(auteur, editeur, idDocument, sujet, url);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoDocument other = (DtoDocument) obj;
		return  Objects.equals(auteur, other.auteur)
				&& Objects.equals(editeur, other.editeur) && idDocument == other.idDocument
				&& Objects.equals(sujet, other.sujet)
				&& Objects.equals(url, other.url);
	}



	@Override
	public String toString() {
		return "DtoDocument [idDocument=" + idDocument + ", sujet=" + sujet + ", url=" + url + ", auteur=" + auteur
				+ ", editeur=" + editeur + "]";
	}


	
}
