package projet.ejb.data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class OrganisationId implements Serializable {
    private Long id_document;
    private Long id_categorie;
    
	public Long getIdDocument() {
		return id_document;
	}
	public void setIdDocument(Long id_document) {
		this.id_document = id_document;
	}
	public Long getIdCategorie() {
		return id_categorie;
	}
	public void setIdCategorie(Long id_categorie) {
		this.id_categorie = id_categorie;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_categorie, id_document);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganisationId other = (OrganisationId) obj;
		return Objects.equals(id_categorie, other.id_categorie) && Objects.equals(id_document, other.id_document);
	}
    
    
}
