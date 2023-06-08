package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;



import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.data.Organiser;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoOrganiser {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	//TODO: VOIR AVEC PROF POURQUOI L'INSERSSION NE S'EFFECTUE PAS
	@TransactionAttribute( MANDATORY )
	public int inserer(Organiser organisation) {
	    em.merge(organisation);
	    em.flush();
	    return organisation.getId();
	}

	public void modifier(Organiser organisation) {
		em.merge( organisation );
	}

	public void supprimer(int idOrganisation) {
		em.remove( retrouver(idOrganisation) );
	}

	@TransactionAttribute( NOT_SUPPORTED )
	public Organiser retrouver(int idOrganisation) {
		return em.find( Organiser.class, idOrganisation );
	}

}
