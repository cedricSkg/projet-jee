package projet.ejb.data;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "associer" )
public class Associer {
    
	
    // Champs
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column(name="idassocier")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idcompte")
    private Compte compte;
    
    @ManyToOne
    @JoinColumn(name = "id_document")
    private Document document;
	
	
	// Constructeurs

	public Associer() {
		super();
	}

	public Associer(int id, Compte compte, Document document) {
		super();
		this.id = id;
		this.compte = compte;
		this.document = document;
	}
	
	

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compte, document, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associer other = (Associer) obj;
		return Objects.equals(compte, other.compte) && Objects.equals(document, other.document) && id == other.id;
	}

	@Override
	public String toString() {
		return "Associer [id=" + id + ", compte=" + compte + ", document=" + document + "]";
	}

	
    
   
	
}
