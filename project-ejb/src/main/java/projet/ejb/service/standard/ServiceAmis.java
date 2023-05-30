package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoAmis;
import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAmis;
import projet.ejb.dao.IDaoAmis;
import projet.ejb.data.Amis;
import projet.ejb.data.Compte;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceAmis implements IServiceAmis {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAmis daoAmis;

	// Actions

	@Override
	public int inserer(DtoAmis dtoAmis) throws ExceptionValidation {
		int id = daoAmis.inserer(mapper.map(dtoAmis));
		return id;
	}

	@Override
	public void modifier(DtoAmis dtoAmis) throws ExceptionValidation {
		daoAmis.modifier(mapper.map(dtoAmis));
	}

	@Override
	public void supprimer(int idAmis) throws ExceptionValidation {
		daoAmis.supprimer(idAmis);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAmis retrouver(int idAmis) {
		return mapper.map(daoAmis.retrouver(idAmis));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAmis> listerToutAmis(int idCompte) {
		List<DtoAmis> liste = new ArrayList<>();
		for (Amis Amis : daoAmis.listerToutAmis(idCompte)) {
			liste.add(mapper.map(Amis));
		}
		return liste;
	}
	
	@Override
	public List<DtoAmis> listerToutDemandeAmis(int idCompte) {
		List<DtoAmis> liste = new ArrayList<>();
		for (Amis Amis : daoAmis.listerToutDemandeAmis(idCompte)) {
			liste.add(mapper.map(Amis));
		}
		return liste;
	}
	
	@Override
	public DtoCompte afficherPseudoCompte(int idCompte) {
		DtoCompte pseudo = mapper.map(daoAmis.afficherPseudoCompte(idCompte));
		return pseudo;
	}
	
	@Override
	public DtoAmis getAmitieExistant(int idDemandeur, int idReceveur) {
		return mapper.map(daoAmis.getAmitieExistant(idDemandeur, idReceveur));
	}


}
