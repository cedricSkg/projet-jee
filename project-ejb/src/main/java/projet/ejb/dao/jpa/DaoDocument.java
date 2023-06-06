package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;


import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projet.commun.dto.DtoDocument;
import projet.ejb.dao.IDaoAmis;
import projet.ejb.dao.IDaoCategorie;
import projet.ejb.dao.IDaoDocument;
import projet.ejb.data.Document;
import projet.ejb.data.Organisation;
import projet.ejb.data.Compte;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoDocument implements IDaoDocument {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	@Inject
	private DaoOrganiser daoOrganiser;
	
	@Inject
	private IDaoCategorie daoCategorie;

	
	
	// Actions
	//TODO: VOIR AVEC PROF POURQUOI L'INSERSSION NE S'EFFECTUE PAS
	@Override
	@TransactionAttribute( MANDATORY )
	public int inserer(Document document, int idCategorie) {
	    em.merge(document);
	    em.flush();

	    var elt = new Organisation(daoCategorie.retrouver(idCategorie), retrouver((int)getCurrentIdValue()));
	    daoOrganiser.inserer(elt);
	    System.out.println(elt);

	    return document.getIdDocument();
	}
	
	public long getCurrentIdValue() {
		Query query = em.createNativeQuery("SELECT currval('document_id_document_seq')");
		Object result = query.getSingleResult();
		Long lastAutoIncrementValue = ((Number) result).longValue();
		return lastAutoIncrementValue;

	}

	@Override
	public void modifier(Document document) {
		em.merge( document );
	}

	@Override
	public void supprimer(int idDocument) {
		em.remove( retrouver(idDocument) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Document retrouver(int idDocument) {
		return em.find( Document.class, idDocument );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Document> listerToutDocument(int idCompte) {
		em.clear();
		var jpql = "SELECT l FROM Document l";
		var query = em.createQuery( jpql, Document.class );
		return query.getResultList();
		
	}
	
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Document> listerToutDocumentPourCategorie(int idCategorie) {
		em.clear();
		var jpqlQuery = "SELECT d FROM Document d JOIN d.organisation o JOIN o.categorie c WHERE c.idcategorie = :categoryId";

		var query = em.createQuery(jpqlQuery, Document.class);
		query.setParameter("categoryId", idCategorie);

		return query.getResultList();
		
	}
}
