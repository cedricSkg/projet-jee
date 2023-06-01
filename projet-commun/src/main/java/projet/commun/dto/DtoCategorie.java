package projet.commun.dto;

import java.io.Serializable; 


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
	
	public void setId(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "DtoCategorie [id=" + idcategorie + ", libelle=" + libelle + "]";
	}
	
	
}
