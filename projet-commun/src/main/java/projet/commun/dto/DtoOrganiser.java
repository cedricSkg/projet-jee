package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoOrganiser implements Serializable{
    
	
    // Champs
    private int id;
    
    private DtoCategorie categorie;
    
    private DtoDocument document;
	
	
	// Constructeurs

	public DtoOrganiser() {
		super();
	}

	public DtoOrganiser(DtoCategorie categorie, DtoDocument document) {
		super();
		this.categorie = categorie;
		this.document = document;
	}


	public DtoCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(DtoCategorie categorie) {
		this.categorie = categorie;
	}

	public DtoDocument getId_document() {
		return document;
	}


	public void setId_document(DtoDocument document) {
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
		DtoOrganiser other = (DtoOrganiser) obj;
		return Objects.equals(categorie, other.categorie) && document == other.document;
	}

	@Override
	public String toString() {
		return "Organisation [categorie=" + categorie + ", id_document=" + document + "]";
	}
    
   
	
}
