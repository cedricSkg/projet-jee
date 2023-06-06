package projet.commun.dto;

import java.io.Serializable;
import java.util.Objects; 


@SuppressWarnings("serial")
public class DtoCategorie implements Serializable  {

	
	// Champs
	
	private int			idcategorie;
	
	private String		libelle;
	
	
	
	// Constructeurs
	
	public DtoCategorie() {
	}

	public DtoCategorie(int idcategorie, String libelle) {
		this.idcategorie = idcategorie;
		this.libelle = libelle;
	}
	
	
	// Getters & setters

	public int getIdCategorie() {
		return idcategorie;
	}
	
	public void setIdCategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

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
		DtoCategorie other = (DtoCategorie) obj;
		return Objects.equals(idcategorie, other.idcategorie);
	}

	@Override
	public String toString() {
		return "DtoCategorie [id=" + idcategorie + ", libelle=" + libelle + "]";
	}
	
	
}
