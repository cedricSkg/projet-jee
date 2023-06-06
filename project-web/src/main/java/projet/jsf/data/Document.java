package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Document implements Serializable {

	// Champs

	private Integer idDocument;

	private String sujet;

	private String url;

	// Constructeurs

	public Document() {
	}

	public Document(Integer idDocument, String sujet, String url) {
		super();
		this.idDocument = idDocument;
		this.sujet = sujet;
		this.url = url;
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

	// hascode & equals
	@Override
	public int hashCode() {
		return Objects.hash(idDocument, sujet, url);
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
		return Objects.equals(idDocument, other.idDocument) && Objects.equals(sujet, other.sujet)
				&& Objects.equals(url, other.url);
	}

// tostring
	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", sujet=" + sujet + ", url=" + url + "]";
	}

}
