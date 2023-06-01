package projet.jsf.data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Categorie implements Serializable {

	
	// Champs

    private Integer        	idcategorie;
    
	@NotBlank( message = "Le libellé doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le libellé : 25 car. maxi" )
    private String      	libelle;
	
	private List<Document> listeLivre;
    
    // Constructeurs
    
    public Categorie() {
	}

    public Categorie(Integer id, String libelle) {
		super();
		this.idcategorie = id;
		this.libelle = libelle;
	}
    
    
    // Getters & setters

	public Integer getIdCategorie() {
        return idcategorie;
    }

    public void setIdCategorie(Integer id) {
        this.idcategorie = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
	public List<Document> getListeLivre() {
		return listeLivre;
	}

	public void setListeLivre(List<Document> listeLivre) {
		this.listeLivre = listeLivre;
	}
	
    // toString()
    


	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idcategorie);
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
		return Objects.equals(idcategorie, other.idcategorie);
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idcategorie + ", libelle=" + libelle + "]";
	}

}
