package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "document" )
public class Document {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
    private int         	id_document;
    
	private String sujet;
	
	private String url;
	
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<Organisation> organisation;
	// Constructeurs

	public Document() {
		super();
	}
    
	public Document(int id_document, String sujet, String url) {
		super();
		this.id_document = id_document;
		this.sujet = sujet;
		this.url = url;
	}
    
    // Getters & setters

	public int getIdDocument() {
		return id_document;
	}



	public void setIdDocument(int id_document) {
		this.id_document = id_document;
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
		return "Document [id_document=" + id_document + ", sujet=" + sujet + ", url=" + url + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_document, sujet, url);
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
		return id_document == other.id_document && Objects.equals(sujet, other.sujet) && Objects.equals(url, other.url);
	}
    
	
	
}
