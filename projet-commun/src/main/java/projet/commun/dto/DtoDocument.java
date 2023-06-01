package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoDocument implements Serializable {

	// Champs

	private int idDocument;

	private String sujet;
	
	private String url;

	// Constructeurs

	public DtoDocument() {
	}


	public DtoDocument(int idDocument, String sujet, String url) {
		super();
		this.idDocument = idDocument;
		this.sujet = sujet;
		this.url = url;
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


	@Override
	public String toString() {
		return "DtoDocument [idDocument=" + idDocument + ", sujet=" + sujet + ", url=" + url + "]";
	}
}
