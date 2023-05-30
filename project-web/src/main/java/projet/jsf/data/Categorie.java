package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Categorie implements Serializable {

	
	// Champs

    private Integer        	idCategorie;
    
	@NotBlank( message = "Le libellé doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le libellé : 25 car. maxi" )
    private String      	libelle;
	
    
    // Constructeurs
    
    public Categorie() {
	}

    public Categorie(Integer id, String libelle) {
		super();
		this.idCategorie = id;
		this.libelle = libelle;
	}
    
    
    // Getters & setters

	public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer id) {
        this.idCategorie = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    // toString()
    
	@Override
	public String toString() {
		return libelle;
	}

	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idCategorie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Categorie) obj;
		return Objects.equals(idCategorie, other.idCategorie);
	}

}
