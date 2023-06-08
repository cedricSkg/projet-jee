package projet.ejb.data;

import static javax.persistence.FetchType.EAGER;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "compte")
public class Compte {

	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcompte")
	private int id;

	@Column(name = "pseudo")
	private String pseudo;

	@Column(name = "motdepasse")
	private String motDePasse;

	@Column(name = "email")
	private String email;

	@ElementCollection(fetch = EAGER)
	@CollectionTable(name = "role", joinColumns = @JoinColumn(name = "idcompte"))
	@Column(name = "role")
	private List<String> roles = new ArrayList<>();
	

	
	


	// Constructeurs

	public Compte() {
	}

	public Compte(int id, String pseudo, String motDePasse, String email) {
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
	}

	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", email=" + email
				+ ", roles=" + roles + "]";
	}

	// equals() et hashcode()

}
