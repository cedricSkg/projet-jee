package projet.ejb.data;



import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "organisation" )
public class Organisation {
    
	
    // Champs
    @EmbeddedId
    private OrganisationId             id;
	
	
	// Constructeurs

	public Organisation() {
		super();
	}





	public Organisation(OrganisationId id) {
		super();
		this.id = id;
	}





	public OrganisationId getId() {
		return id;
	}


	public void setId(OrganisationId id) {
		this.id = id;
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
		Organisation other = (Organisation) obj;
		return Objects.equals(id, other.id);
	}





	@Override
	public String toString() {
		return "Organisation [id=" + id + "]";
	}
    
   
	
}
