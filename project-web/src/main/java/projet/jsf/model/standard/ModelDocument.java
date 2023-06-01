package projet.jsf.model.standard;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoDocument;
import projet.commun.service.IServiceDocument;
import projet.jsf.data.Document;
import projet.jsf.data.mapper.IMapperDocument;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelDocument implements Serializable {

	// Champs

	private List<Document> listeDocument;

	@Inject
	private ModelConnexion modelConnexion;

	@EJB
	private IServiceDocument serviceDocument;

	@Inject
	private IMapperDocument mapper;

	// Getters

	public List<Document> getListeDocument() {
		if (listeDocument == null) {
			listeDocument = new ArrayList<>();
			for (DtoDocument dto : serviceDocument.listerToutDocument(modelConnexion.getCompteActif().getId())) {
				listeDocument.add(mapper.map(dto));
			}
		}
		return listeDocument;
	}

	public List<Document> getListeDocumentsParCategorie(int idCategorie) {
		List<Document> listeDocumentPourCategorie = new ArrayList<Document>();
		for (DtoDocument dto : serviceDocument.listerToutDocumentPourCategorie(idCategorie)) {
			listeDocumentPourCategorie.add(mapper.map(dto));
		}
		return listeDocumentPourCategorie;
	}
}
