package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCategorie;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCategorie;
import projet.jsf.data.Categorie;
import projet.jsf.data.mapper.IMapperCategorie;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelCategorie implements Serializable {

	
	// Champs
	
	private List<Categorie>	liste;
	
	private Categorie			courant;
	
	@EJB
	private IServiceCategorie serviceCategorie;
	
	@Inject
	private IMapperCategorie			mapper;

	
	// Getters 
	
	public List<Categorie> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoCategorie dto : serviceCategorie.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Categorie getCourant() {
			if ( courant == null ) {
				courant = new Categorie();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		
		if ( courant != null ) {
			DtoCategorie dto = serviceCategorie.retrouver( courant.getIdCategorie() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le compte demandé n'existe pas" );
			} else {
				courant = mapper.map( dto );
			}
		}
		System.out.println(courant);
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getIdCategorie() == null) {
				serviceCategorie.inserer( mapper.map(courant) );
			} else {
				serviceCategorie.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "catégories";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Categorie item ) {
		try {
			serviceCategorie.supprimer( item.getIdCategorie() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	

	
}
