package projet.ejb.data;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "organiser" )
public class Organisation {
    
	
    // Champs
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;
    
    @ManyToOne
    @JoinColumn(name = "id_document")
    private Document document;
	
	
	// Constructeurs

	public Organisation() {
		super();
	}

	public Organisation(Categorie categorie, Document document) {
		super();
		this.categorie = categorie;
		this.document = document;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Document getId_document() {
		return document;
	}


	public void setId_document(Document document) {
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
		return Objects.hash(categorie, document);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organisation other = (Organisation) obj;
		return Objects.equals(categorie, other.categorie) && document == other.document;
	}

	@Override
	public String toString() {
		return "Organisation [categorie=" + categorie + ", id_document=" + document + "]";
	}
    
   
	
}
