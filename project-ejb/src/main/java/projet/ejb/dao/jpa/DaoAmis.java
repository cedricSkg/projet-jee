package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;


import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoAmis;
import projet.ejb.dao.IDaoAmis;
import projet.ejb.data.Amis;
import projet.ejb.data.Compte;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAmis implements IDaoAmis {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	//TODO: VOIR AVEC PROF POURQUOI L'INSERSSION NE S'EFFECTUE PAS
	@Override
	@TransactionAttribute( MANDATORY )
	public int inserer(Amis amis) {
		em.merge(amis);
		em.flush();
		return amis.getIdAmis();
	}

	@Override
	public void modifier(Amis amis) {
		em.merge( amis );
	}

	@Override
	public void supprimer(int idAmis) {
		em.remove( retrouver(idAmis) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Amis retrouver(int idAmis) {
		return em.find( Amis.class, idAmis );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Amis> listerToutAmis(int idCompte) {
		em.clear();
		var jpql = "SELECT a FROM Amis a, Compte c WHERE a.idDemandeur = c.id AND a.status = 'V' AND a.idReceveur =" + idCompte;
		var query = em.createQuery( jpql, Amis.class );
		return query.getResultList();
		
	}

	@Override
	public List<Amis> listerToutDemandeAmis(int idCompte) {
		em.clear();
		var jpql = "SELECT a FROM Amis a, Compte c WHERE a.idDemandeur = c.id AND a.status = 'E' AND a.idReceveur =" + idCompte;
		var query = em.createQuery( jpql, Amis.class );
		return query.getResultList();
	}
	
	@Override
	public Compte afficherPseudoCompte(int idCompte) {
		em.clear();
		var jpql = "SELECT c FROM Compte c WHERE c.id = " + idCompte;
		var query = em.createQuery( jpql, Compte.class );
		return query.getSingleResult();
	}
	
	@Override
	public Amis getAmitieExistant(int idDemandeur, int idReceveur) {
		try {
			em.clear();
			var jpql = "SELECT a FROM Amis a WHERE a.idDemandeur = :idDemandeur AND a.idReceveur = :idReceveur";
			var query = em.createQuery( jpql, Amis.class );
			query.setParameter( "idDemandeur", idDemandeur ) ;
			query.setParameter( "idReceveur", idReceveur ) ;
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
