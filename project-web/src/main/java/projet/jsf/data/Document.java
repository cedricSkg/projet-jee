package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;
import projet.ejb.data.Intervenant;


@SuppressWarnings("serial")
public class Document implements Serializable {

	// Champs

	private Integer idDocument;

	private String sujet;

	private String url;
	
	private Intervenant auteur;
	
	private Intervenant editeur;
	
	// Constructeurs

	public Document() {
		super();
	}
    
	
    
    public Document(int id_document, String sujet, String url, Intervenant auteur, Intervenant editeur) {
		super();
		this.idDocument = id_document;
		this.sujet = sujet;
		this.url = url;
		this.auteur = auteur;
		this.editeur = editeur;
	}
   
	// Getters & setters

	public Integer getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Integer idDocument) {
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

	public Intervenant getAuteur() {
		return auteur;
	}

	public void setAuteur(Intervenant auteur) {
		this.auteur = auteur;
	}

	public Intervenant getEditeur() {
		return editeur;
	}

	public void setEditeur(Intervenant editeur) {
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
		Document other = (Document) obj;
		return Objects.equals(auteur, other.auteur)
				&& Objects.equals(editeur, other.editeur) && Objects.equals(idDocument, other.idDocument)
				 && Objects.equals(sujet, other.sujet)
				&& Objects.equals(url, other.url);
	}



	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", sujet=" + sujet + ", url=" + url + ", auteur=" + auteur
				+ ", editeur=" + editeur + "]";
	}

// tostring


}
