package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "amis" )
public class Amis {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
    private int         	idAmis;
    
	private int idDemandeur;
	
	private int idReceveur;
	
	private String status;
	
	
	// Constructeurs

	public Amis() {
		super();
	}
    
    public Amis(int idAmis, int idDemandeur, int idReceveur, String status) {
		super();
		this.idAmis = idAmis;
		this.idDemandeur = idDemandeur;
		this.idReceveur = idReceveur;
		this.status = status;
	}
    
    // Getters & setters
	
	public int getIdAmis() {
		return idAmis;
	}

	public void setIdAmis(int idAmis) {
		this.idAmis = idAmis;
	}

	public int getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(int idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public int getIdReceveur() {
		return idReceveur;
	}

	public void setIdReceveur(int idReceveur) {
		this.idReceveur = idReceveur;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Amis [idAmis=" + idAmis + ", idDemandeur=" + idDemandeur + ", idReceveur=" + idReceveur + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAmis, idDemandeur, idReceveur, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amis other = (Amis) obj;
		return idAmis == other.idAmis && idDemandeur == other.idDemandeur && idReceveur == other.idReceveur
				&& Objects.equals(status, other.status);
	}
    
	
	
}
