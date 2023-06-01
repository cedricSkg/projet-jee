package projet.jsf.model.standard;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoAmis;
import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAmis;
import projet.jsf.data.Amis;
import projet.jsf.data.Compte;
import projet.jsf.data.mapper.IMapperAmis;
import projet.jsf.data.mapper.IMapperCompte;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelAmis implements Serializable {

	// Champs

	private List<Amis> listeAmis;
	private List<Amis> listeDemandeAmis;

	@Inject
	private ModelConnexion modelConnexion;

	@EJB
	private IServiceAmis serviceAmis;

	@Inject
	private IMapperAmis mapper;

	// Getters

	public List<Amis> getListeAmis() {
		if (listeAmis == null) {
			listeAmis = new ArrayList<>();
			for (DtoAmis dto : serviceAmis.listerToutAmis(modelConnexion.getCompteActif().getId())) {
				listeAmis.add(mapper.map(dto));
			}
		}
		return listeAmis;
	}

	public List<Amis> getListeDemandeAmis() {
		if (listeDemandeAmis == null) {
			listeDemandeAmis = new ArrayList<>();
			for (DtoAmis dto : serviceAmis.listerToutDemandeAmis(modelConnexion.getCompteActif().getId())) {
				listeDemandeAmis.add(mapper.map(dto));
			}
		}
		return listeDemandeAmis;
	}

	public String demanderAmitie(Compte item) {
		try {
			DtoAmis dto;
			Amis courant = mapper.map( this.getAmitieExistant(modelConnexion.getCompteActif().getId(), item.getId()) ) ;
			if (courant instanceof Amis) {
				dto = new DtoAmis(courant.getIdAmis(), modelConnexion.getCompteActif().getId(), item.getId(), "E");
			} else {
				dto = new DtoAmis(modelConnexion.getCompteActif().getId(), item.getId(), "E");
			}
			serviceAmis.inserer(dto);
			System.out.println(dto);
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return null;
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String accepterAmitie(int idAmis, DtoCompte item) {
		try {
			DtoAmis dto = new DtoAmis(idAmis, item.getId(), modelConnexion.getCompteActif().getId(), "V");
			serviceAmis.inserer(dto);
			UtilJsf.messageInfo("Demande d'amis de " + item.getPseudo() + " acceptée!");
			return null;
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String refuserAmitie(int idAmis, DtoCompte item) {
		if (serviceAmis.retrouver(idAmis).getStatus().compareTo("E") == 0) {
			try {
				DtoAmis dto = new DtoAmis(idAmis, item.getId(), modelConnexion.getCompteActif().getId(), "R");
				serviceAmis.inserer(dto);
				UtilJsf.messageInfo("Demande d'amis de " + item.getPseudo() + " refusée!");

			} catch (ExceptionValidation e) {
				UtilJsf.messageError(e);
				return null;
			}
		}
		return null;
	}

	public DtoCompte afficherPseudoCompte(int idCompte) {
		DtoCompte pseudo = serviceAmis.afficherPseudoCompte(idCompte);
		return pseudo;
	}

	public String supprimerAmitie(int idAmis, DtoCompte item) {
		if (serviceAmis.retrouver(idAmis).getStatus().compareTo("E") != 0) {
			try {
				serviceAmis.supprimer(idAmis);
				UtilJsf.messageInfo("Amitié avec " + item.getPseudo() + " supprimée!");

			} catch (ExceptionValidation e) {
				UtilJsf.messageError(e);
				return null;
			}
		}
		return null;
	}

	public DtoAmis getAmitieExistant(int idDemandeur, int idReceveur) {
		return serviceAmis.getAmitieExistant(idDemandeur, idReceveur);
	}

//TODO: SUPPRIMER AMITIE

}
