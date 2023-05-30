package projet.commun.service;

import java.util.List;


import projet.commun.dto.DtoAmis;
import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;


public interface IServiceAmis {
	
	int				inserer( DtoAmis dtoAmis ) throws ExceptionValidation;

	void			modifier( DtoAmis dtoAmis ) throws ExceptionValidation; 

	void			supprimer( int idAmis ) throws ExceptionValidation;

	DtoAmis		retrouver( int idAmis ) ;
	
	DtoCompte afficherPseudoCompte(int idCompte);

	List<DtoAmis> listerToutDemandeAmis(int idCompte);

	List<DtoAmis> listerToutAmis(int idCompte);

	DtoAmis getAmitieExistant(int idDemandeur, int idReceveur);

}
