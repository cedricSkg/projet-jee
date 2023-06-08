package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;



import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import projet.ejb.dao.IDaoAmis;
import projet.ejb.data.Amis;
import projet.ejb.data.Compte;
import projet.ejb.data.Emprunt;


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
	@TransactionAttribute( MANDATORY)
	public void supprimer(int idAmis) {
		em.remove( em.getReference( Amis.class, idAmis ) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Amis retrouver(int idAmis) {
		return em.find( Amis.class, idAmis );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Amis> listerToutAmis(Compte compte) {
		em.clear();
		var jpql = "SELECT a FROM Amis a WHERE a.status = 'V' AND (a.receveur = " + compte.getId() + " OR a.demandeur = " + compte.getId() + ")";
		var query = em.createQuery( jpql, Amis.class );
		System.out.println(query.getResultList());
		return query.getResultList();
		
	}

	@Override
	public List<Amis> listerToutDemandeAmis(int idCompte) {
		em.clear();
		var jpql = "SELECT a FROM Amis a WHERE a.status = 'E' AND a.receveur =" + idCompte;
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
			var jpql = "SELECT a FROM Amis a WHERE a.demandeur = " + idDemandeur + " AND a.receveur = " + idReceveur;
			var query = em.createQuery( jpql, Amis.class );
			var ami = query.getSingleResult();
			return (ami != null) ? ami : null;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public String supprimerToutAmitierUnCompte(int idCompte) {
		var query = em.createQuery("DELETE FROM Amis a WHERE a.demandeur =" +idCompte+" OR a.receveur =" +idCompte);
        query.executeUpdate();
        return null;
	}

}
