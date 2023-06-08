package projet.jsf.model.standard;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDocument;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEmprunt;
import projet.jsf.data.Emprunt;
import projet.jsf.data.Compte;
import projet.jsf.data.Document;
import projet.jsf.data.mapper.IMapperEmprunt;
import projet.jsf.data.mapper.IMapperCompte;
import projet.jsf.data.mapper.IMapperDocument;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelEmprunt implements Serializable {

	// Champs

	private List<Emprunt> listeEmprunt;
	private List<Emprunt> listeDemandeEmprunt;

	@Inject
	private ModelConnexion modelConnexion;

	@EJB
	private IServiceEmprunt serviceEmprunt;

	@Inject
	private IMapperEmprunt mapper;
	
	@Inject
	private IMapperCompte mapperC;
	
	@Inject
	private IMapperDocument mapperD;

	// Getters

	public List<Emprunt> getListeEmprunt() {
		if (listeEmprunt == null) {
			listeEmprunt = new ArrayList<>();
			for (DtoEmprunt dto : serviceEmprunt.listerToutEmprunt(mapperC.map(modelConnexion.getCompteActif()))) {
				listeEmprunt.add(mapper.map(dto));
			}
		}
		return listeEmprunt;
	}

	public List<Emprunt> getListeDemandeEmprunt() {
		if (listeDemandeEmprunt == null) {
			listeDemandeEmprunt = new ArrayList<>();
			for (DtoEmprunt dto : serviceEmprunt.listerToutDemandeEmprunt(modelConnexion.getCompteActif().getId())) {
				System.out.println("model "+ mapper.map(dto));
				listeDemandeEmprunt.add(mapper.map(dto));
				
			}
		}

		return listeDemandeEmprunt;
	}
	
	public List<Document> getListeDocumentEmprunt(int idCompte) {
			List<Document> listeDocumentEmprunt = new ArrayList<>();
			for (DtoDocument dto : serviceEmprunt.listerToutDocumentEmprunt(idCompte)) {
				listeDocumentEmprunt.add(mapperD.map(dto));
			}
		return listeDocumentEmprunt;
	}

	public String demanderEmprunt(Compte item, Document doc) {
		try {
			DtoEmprunt dto;
			DtoEmprunt courant = this.getEmpruntExistant(modelConnexion.getCompteActif().getId(), item.getId())  ;
			if (courant instanceof DtoEmprunt) {
				dto = new DtoEmprunt(courant.getIdEmprunt(), mapperC.map(modelConnexion.getCompteActif()), mapperC.map(item), mapperD.map(doc), "E");
			} else {
				dto = new DtoEmprunt(mapperC.map(modelConnexion.getCompteActif()), mapperC.map(item), mapperD.map(doc), "E");
			}
			serviceEmprunt.inserer(dto);
			UtilJsf.messageInfo("Emprunt effectuée avec succès");
			return null;
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String accepterEmprunt(int idEmprunt, Compte item, Document doc) {
		try {
			DtoEmprunt dto = new DtoEmprunt(idEmprunt, mapperC.map(item), mapperC.map(modelConnexion.getCompteActif()), mapperD.map(doc), "V");
			serviceEmprunt.inserer(dto);
			UtilJsf.messageInfo("Demande d'emprunt de document de " + item.getPseudo() + " acceptée!");
			return "profil";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return "profil";
		}
	}

	public String refuserEmprunt(int idEmprunt, Compte item, Document doc) {
		if (serviceEmprunt.retrouver(idEmprunt).getStatus().compareTo("E") == 0) {
			try {
				DtoEmprunt dto = new DtoEmprunt(idEmprunt, mapperC.map(item), mapperC.map(modelConnexion.getCompteActif()), mapperD.map(doc), "R");
				serviceEmprunt.inserer(dto);
				UtilJsf.messageInfo("Demande d'emprunt de document de " + item.getPseudo() + " refusée!");

			} catch (ExceptionValidation e) {
				UtilJsf.messageError(e);
				return "profil";
			}
		}
		return "profil";
	}

	public String supprimerAmitie(int idEmprunt) {
		if (serviceEmprunt.retrouver(idEmprunt).getStatus().compareTo("E") != 0) {
			try {
				serviceEmprunt.supprimer(idEmprunt);
				UtilJsf.messageInfo("Amitié supprimée!");

			} catch (ExceptionValidation e) {
				UtilJsf.messageError(e);
				return null;
			}
		}
		return null;
	}

	public DtoEmprunt getEmpruntExistant(int idDemandeur, int idReceveur) {
		return serviceEmprunt.getEmpruntExistant(idDemandeur, idReceveur);
	}
	
	public DtoCompte getEmprunt(int idEmprunt) {
		DtoCompte compte = null;
		for (Emprunt emprunt : listeEmprunt) {
			if (emprunt.getDemandeur().getId() == modelConnexion.getCompteActif().getId()) {
				compte = mapperC.map(emprunt.getReceveur());
			}else if (emprunt.getReceveur().getId() == modelConnexion.getCompteActif().getId()) {
				compte = mapperC.map(emprunt.getDemandeur());
			}
		}
		return compte;
	}

}
