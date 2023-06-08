package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="idauteur")
	private Intervenant auteur;
	
	@OneToOne
	@JoinColumn(name="idediteur")
	private Intervenant editeur;
	
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<Organiser> organisation;
    
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<Associer> associer;
    
    @OneToMany(mappedBy = "document")
    private List<Emprunt> emprunt;

    // Constructeurs

	public Document() {
		super();
	}
    
	
    
    public Document(int id_document, String sujet, String url, Intervenant auteur, Intervenant editeur,
			List<Organiser> organisation, List<Associer> associer) {
		super();
		this.id_document = id_document;
		this.sujet = sujet;
		this.url = url;
		this.auteur = auteur;
		this.editeur = editeur;
		this.organisation = organisation;
		this.associer = associer;
	}
    
    public Document(int id_document, String sujet, String url, Intervenant auteur, Intervenant editeur,
			List<Organiser> organisation) {
		super();
		this.id_document = id_document;
		this.sujet = sujet;
		this.url = url;
		this.auteur = auteur;
		this.editeur = editeur;
		this.organisation = organisation;
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
	public String toString() {
		return "Document [id_document=" + id_document + ", sujet=" + sujet + ", url=" + url + ", auteur=" + auteur
				+ ", editeur=" + editeur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(associer, auteur, editeur, id_document, organisation, sujet, url);
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
		return Objects.equals(associer, other.associer) && Objects.equals(auteur, other.auteur)
				&& Objects.equals(editeur, other.editeur) && id_document == other.id_document
				&& Objects.equals(organisation, other.organisation) && Objects.equals(sujet, other.sujet)
				&& Objects.equals(url, other.url);
	}	
}
