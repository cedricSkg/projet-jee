package projet.commun.dto;

import java.io.Serializable; 


@SuppressWarnings("serial")
public class DtoCategorie implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		libelle;
	
	
	
	// Constructeurs
	
	public DtoCategorie() {
	}

	public DtoCategorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
