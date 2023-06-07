package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDocument;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEmprunt;
import projet.ejb.dao.IDaoEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.Document;
import projet.ejb.data.Emprunt;
import projet.ejb.data.Emprunt;
import projet.ejb.data.Emprunt;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEmprunt implements IServiceEmprunt {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEmprunt daoEmprunt;

	// Actions

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int inserer(DtoEmprunt dtoEmprunt) throws ExceptionValidation {
		System.out.println("d "+dtoEmprunt);
		System.out.println("s "+mapper.map(dtoEmprunt));
		int id = daoEmprunt.inserer(mapper.map(dtoEmprunt));
		return id;
	}

	@Override
	public void modifier(DtoEmprunt dtoEmprunt) throws ExceptionValidation {
		daoEmprunt.modifier(mapper.map(dtoEmprunt));
	}

	@Override
	public void supprimer(int idEmprunt) throws ExceptionValidation {
		daoEmprunt.supprimer(idEmprunt);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEmprunt retrouver(int idEmprunt) {
		return mapper.map(daoEmprunt.retrouver(idEmprunt));
	}
	
	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEmprunt> listerToutEmprunt(DtoCompte compte) {
		List<DtoEmprunt> liste = new ArrayList<>();
		for (Emprunt Emprunt : daoEmprunt.listerToutEmprunt(mapper.map(compte))) {
			liste.add(mapper.map(Emprunt));
		}
		return liste;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<DtoEmprunt> listerToutDemandeEmprunt(int idCompte) {
		List<DtoEmprunt> liste = new ArrayList<>();
		for (Emprunt Emprunt : daoEmprunt.listerToutDemandeEmprunt(idCompte)) {
			liste.add(mapper.map(Emprunt));
		}
		return liste;
	}
	
	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED )
	public List<DtoDocument> listerToutDocumentEmprunt(int idCompte) {
		List<DtoDocument> liste = new ArrayList<>();
		for (Document document : daoEmprunt.listerToutDocumentEmprunt(idCompte)) {
			liste.add(mapper.map(document));
		}
		return liste;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DtoEmprunt getEmpruntExistant(int idDemandeur, int idReceveur) {
		return mapper.map(daoEmprunt.getEmpruntExistant(idDemandeur, idReceveur));
	}

}
