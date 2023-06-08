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
@Table( name = "amis" )
public class Amis {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
    private int         	idAmis;
    
	@ManyToOne
	@JoinColumn(name="iddemandeur")
	private Compte demandeur;
	
	@ManyToOne
	@JoinColumn(name="idreceveur")
	private Compte receveur;
	
	private String status;
	
	
	// Constructeurs

	public Amis() {
		super();
	}
    
    
    
    public Amis(int idAmis, Compte demandeur, Compte receveur, String status) {
		super();
		this.idAmis = idAmis;
		this.demandeur = demandeur;
		this.receveur = receveur;
		this.status = status;
	}



	// Getters & setters

	

	public int getIdAmis() {
		return idAmis;
	}



	public void setIdAmis(int idAmis) {
		this.idAmis = idAmis;
	}



	public Compte getDemandeur() {
		return demandeur;
	}



	public void setDemandeur(Compte demandeur) {
		this.demandeur = demandeur;
	}



	public Compte getReceveur() {
		return receveur;
	}



	public void setReceveur(Compte receveur) {
		this.receveur = receveur;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		return Objects.hash(demandeur, idAmis, receveur, status);
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
		return Objects.equals(demandeur, other.demandeur) && idAmis == other.idAmis
				&& Objects.equals(receveur, other.receveur) && Objects.equals(status, other.status);
	}
	
	
	@Override
	public String toString() {
		return "Amis [idAmis=" + idAmis + ", demandeur=" + demandeur + ", receveur=" + receveur + ", status=" + status
				+ "]";
	}
	
}
