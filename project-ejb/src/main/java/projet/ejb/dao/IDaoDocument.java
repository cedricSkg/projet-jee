package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Document;


public interface IDaoDocument {

	void 		modifier( Document Document );

	void 		supprimer( int idDocument );

	Document 		retrouver( int idDocument );

	List<Document> listerToutDocument(int idCompte);

	List<Document> listerToutDocumentPourCategorie(int idCategorie);

	int inserer(Document document, int idCtaegorie);
}
