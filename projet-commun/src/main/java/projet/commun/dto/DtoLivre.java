package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoLivre implements Serializable {

	// Champs

	private int idLivre;

	private String sujet;
	
	private String url;

	// Constructeurs

	public DtoLivre() {
	}


	public DtoLivre(int idLivre, String sujet, String url) {
		super();
		this.idLivre = idLivre;
		this.sujet = sujet;
		this.url = url;
	}


	// Getters & setters
	
	public int getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
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
		return "DtoLivre [idLivre=" + idLivre + ", sujet=" + sujet + ", url=" + url + "]";
	}
}
