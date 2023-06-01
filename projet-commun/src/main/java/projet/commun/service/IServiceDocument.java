package projet.commun.service;

import java.util.List;


import projet.commun.dto.DtoDocument;
import projet.commun.exception.ExceptionValidation;


public interface IServiceDocument {
	
	int				inserer( DtoDocument dtoDocument ) throws ExceptionValidation;

	void			modifier( DtoDocument dtoDocument ) throws ExceptionValidation; 

	void			supprimer( int idDocument ) throws ExceptionValidation;

	DtoDocument		retrouver( int idDocument ) ;

	List<DtoDocument> listerToutDocument(int idCompte);

	List<DtoDocument> listerToutDocumentPourCategorie(int idCategorie);


}
