package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "categorie" )
public class Categorie {
    
	
    // Champs
    
	@Id
	@Column( name = "idcategorie" ) 
	@GeneratedValue( strategy = IDENTITY )
    private int         	idcategorie;
    
	@Column( name = "libelle" ) 
    private String      	libelle;
	
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Organisation> organisation;
	
	// Constructeurs

	public Categorie() {
		super();
	}
    
    public Categorie(int id, String libelle) {
		super();
		this.idcategorie = id;
		this.libelle = libelle;
	}
    
    
    // Getters & setters

    public int getIdCategorie() {
        return idcategorie;
    }

    public void setIdCategorie(int id) {
        this.idcategorie = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    // soString()


    
	// hashcode() & equals()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcategorie;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (idcategorie != other.idcategorie)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categorie [idcategorie=" + idcategorie + ", libelle=" + libelle + "]";
	}
    
}
