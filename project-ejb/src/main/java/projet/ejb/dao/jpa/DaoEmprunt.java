package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;



import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import projet.ejb.dao.IDaoEmprunt;
import projet.ejb.data.Emprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.Document;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEmprunt implements IDaoEmprunt {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED )
	public int inserer(Emprunt emprunt) {
		em.merge(emprunt);
		em.flush();
		return emprunt.getIdEmprunt();
	}

	@Override
	public void modifier(Emprunt emprunt) {
		em.merge( emprunt );
	}

	@Override
	public void supprimer(int idEmprunt) {
		em.remove( em.getReference( Emprunt.class, idEmprunt ) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Emprunt retrouver(int idEmprunt) {
		return em.find( Emprunt.class, idEmprunt );
	}
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Emprunt> listerToutEmprunt(Compte compte) {
		em.clear();
		var jpql = "SELECT e FROM Emprunt e WHERE e.status = 'V' AND (e.receveur = " + compte.getId() + " OR e.demandeur = " + compte.getId() + ")";
		var query = em.createQuery( jpql, Emprunt.class );
		return query.getResultList();
		
	}
	
	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED )
	public List<Document> listerToutDocumentEmprunt(int idCompte) {
		em.clear();
		var jpql = "SELECT d FROM Emprunt e JOIN e.document d WHERE e.status = 'V' AND e.demandeur = " + idCompte;
		var query = em.createQuery( jpql, Document.class );
		return query.getResultList();
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Emprunt> listerToutDemandeEmprunt(int idCompte) {
		em.clear();
		var jpql = "SELECT e FROM Emprunt e WHERE e.status = 'E' AND e.receveur =" + idCompte;
		var query = em.createQuery( jpql, Emprunt.class );
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
	@TransactionAttribute( TransactionAttributeType.REQUIRED)
	public Emprunt getEmpruntExistant(int idDemandeur, int idReceveur) {
		try {
			em.clear();
			var jpql = "SELECT e FROM Emprunt e WHERE e.demandeur = " + idDemandeur + " AND e.receveur = " + idReceveur;
			var query = em.createQuery( jpql, Emprunt.class );
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Aucune donnée trouvée");
			return null;
		}
	}

}
