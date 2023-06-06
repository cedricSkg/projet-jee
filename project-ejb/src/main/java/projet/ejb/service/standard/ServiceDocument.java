package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoDocument;
import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDocument;
import projet.ejb.dao.IDaoDocument;
import projet.ejb.data.Document;
import projet.ejb.data.Compte;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceDocument implements IServiceDocument {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoDocument daoDocument;

	// Actions

	@Override
	public int inserer(DtoDocument dtoDocument, int idCategorie) throws ExceptionValidation {
		int id = daoDocument.inserer(mapper.map(dtoDocument), idCategorie);
		return id;
	}

	@Override
	public void modifier(DtoDocument dtoDocument) throws ExceptionValidation {
		daoDocument.modifier(mapper.map(dtoDocument));
	}

	@Override
	public void supprimer(int idDocument) throws ExceptionValidation {
		daoDocument.supprimer(idDocument);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoDocument retrouver(int idDocument) {
		return mapper.map(daoDocument.retrouver(idDocument));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoDocument> listerToutDocument(int idCompte) {
		List<DtoDocument> liste = new ArrayList<>();
		for (Document Document : daoDocument.listerToutDocument(idCompte)) {
			liste.add(mapper.map(Document));
		}
		return liste;
		
	
	}
	
	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoDocument> listerToutDocument2(int idCompte) {
		List<DtoDocument> liste = new ArrayList<>();
		for (Document Document : daoDocument.listerToutDocument(idCompte)) {
			liste.add(mapper.map(Document));
		}
		return liste;
	}
	
	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoDocument> listerToutDocumentPourCategorie(int idCategorie) {
		List<DtoDocument> liste = new ArrayList<>();
		for (Document Document : daoDocument.listerToutDocumentPourCategorie(idCategorie)) {
			liste.add(mapper.map(Document));
		}
		return liste;
	}
}
