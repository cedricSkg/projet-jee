package projet.commun.service;

import java.util.List;



import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDocument;
import projet.commun.exception.ExceptionValidation;



public interface IServiceEmprunt {
	
	int				inserer( DtoEmprunt dtoEmprunt ) throws ExceptionValidation;

	void			modifier( DtoEmprunt dtoEmprunt ) throws ExceptionValidation; 

	void			supprimer( int idEmprunt ) throws ExceptionValidation;

	DtoEmprunt		retrouver( int idEmprunt ) ;

	List<DtoEmprunt> listerToutEmprunt(DtoCompte compte);

	List<DtoEmprunt> listerToutDemandeEmprunt(int idCompte);

	DtoEmprunt getEmpruntExistant(int idDemandeur, int idReceveur);

	List<DtoDocument> listerToutDocumentEmprunt(int idCompte);


}
