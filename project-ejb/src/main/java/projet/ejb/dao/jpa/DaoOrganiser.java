package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;


import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projet.ejb.data.Organisation;
import projet.ejb.data.Compte;


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
	public int inserer(Organisation organisation) {
	    em.merge(organisation);
	    em.flush();
	    return organisation.getId();
	}

	public void modifier(Organisation organisation) {
		em.merge( organisation );
	}

	public void supprimer(int idOrganisation) {
		em.remove( retrouver(idOrganisation) );
	}

	@TransactionAttribute( NOT_SUPPORTED )
	public Organisation retrouver(int idOrganisation) {
		return em.find( Organisation.class, idOrganisation );
	}

}
