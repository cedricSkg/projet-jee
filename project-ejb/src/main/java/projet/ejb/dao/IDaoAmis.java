package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoAmis;
import projet.ejb.data.Amis;
import projet.ejb.data.Compte;


public interface IDaoAmis {

	int			inserer( Amis Amis );

	void 		modifier( Amis Amis );

	void 		supprimer( int idAmis );

	Amis 		retrouver( int idAmis );

	Compte afficherPseudoCompte(int idCompte);

	List<Amis> listerToutDemandeAmis(int idCompte);

	List<Amis> listerToutAmis(int idCompte);

	Amis getAmitieExistant(int idDemandeur, int idReceveur);
}
