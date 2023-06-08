package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Compte;
import projet.ejb.data.Document;
import projet.ejb.data.Emprunt;


public interface IDaoEmprunt {

	int			inserer( Emprunt emprunt );

	void 		modifier( Emprunt emprunt );

	void 		supprimer( int idEmprunt );

	Emprunt 		retrouver( int idEmprunt );

	Emprunt getEmpruntExistant(int idDemandeur, int idReceveur);

	Compte afficherPseudoCompte(int idCompte);

	List<Emprunt> listerToutDemandeEmprunt(int idCompte);

	List<Emprunt> listerToutEmprunt(Compte compte);

	List<Document> listerToutDocumentEmprunt(int idCompte);


	String supprimerToutEmpruntUnCompte(int idCompte);
}
