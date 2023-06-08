package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class DtoAssocier implements Serializable{
    
	
    // Champs
    private int id;
    
    private DtoCompte compte;
    
    private DtoDocument document;
	
	
	// Constructeurs

	public DtoAssocier() {
		super();
	}

	public DtoAssocier(int id, DtoCompte compte, DtoDocument document) {
		super();
		this.id = id;
		this.compte = compte;
		this.document = document;
	}
	
	

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

	public DtoDocument getDocument() {
		return document;
	}


	public void setDocument(DtoDocument document) {
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
		DtoAssocier other = (DtoAssocier) obj;
		return Objects.equals(compte, other.compte) && Objects.equals(document, other.document) && id == other.id;
	}

	@Override
	public String toString() {
		return "Associer [id=" + id + ", compte=" + compte + ", document=" + document + "]";
	}
	
}

