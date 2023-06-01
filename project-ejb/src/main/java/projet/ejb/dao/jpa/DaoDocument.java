package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;


import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoDocument;
import projet.ejb.dao.IDaoDocument;
import projet.ejb.data.Document;
import projet.ejb.data.Compte;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoDocument implements IDaoDocument {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	//TODO: VOIR AVEC PROF POURQUOI L'INSERSSION NE S'EFFECTUE PAS
	@Override
	@TransactionAttribute( MANDATORY )
	public int inserer(Document document) {
		em.merge(document);
		em.flush();
		return document.getIdDocument();
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
		var jpql = "SELECT d FROM Document d, Organisation o, Categorie c WHERE d.id_document = o.id.id_document AND c.idcategorie = o.id.id_categorie AND c.idcategorie = "+idCategorie;
		var query = em.createQuery( jpql, Document.class );
		return query.getResultList();
		
	}
}
