package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.jsf.data.Compte;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelCompte implements Serializable {

	// Champs

	private List<Compte> liste;
	private List<Compte> listeAutresComptes;

	private Compte courant;

	@EJB
	private IServiceCompte serviceCompte;

	@Inject
	private IMapper mapper;

	@Inject
	private ModelConnexion modelConnexion;

	// Getters

	public List<Compte> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoCompte dto : serviceCompte.listerTout()) {
				liste.add(mapper.map(dto));
			}
		}
		return liste;
	}

	public List<Compte> getListeAutresComptes() {
		if (listeAutresComptes == null) {
			listeAutresComptes = new ArrayList<>();
			for (DtoCompte dto : serviceCompte.listerTout()) {
				if (dto.getId() != modelConnexion.getCompteActif().getId())
					listeAutresComptes.add(mapper.map(dto));
			}
		}
		return listeAutresComptes;
	}

	public Compte getCourant() {
		if (courant == null) {
			courant = new Compte();
		}
		return courant;
	}

	// Initialisaitons

	public void setCourant(Compte courant) {
		this.courant = courant;
	}

	public String actualiserCourant() {
		if (courant != null) {
			DtoCompte dto = serviceCompte.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("Le compte demandé n'existe pas");
				return "test/liste";
			} else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}

	// Actions

	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				serviceCompte.inserer(mapper.map(courant));
			} else {
				serviceCompte.modifier(mapper.map(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(Compte item) {
		try {

			serviceCompte.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

	public void demanderAmis(Compte item) {
		try {
			courant.getDemandesAmis().add(item);
		} catch (Exception e) {
			UtilJsf.messageError(e);
		}
	}

}
