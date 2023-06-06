package projet.jsf.model.standard;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoDocument;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDocument;
import projet.jsf.data.Document;
import projet.jsf.data.mapper.IMapperDocument;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelDocument implements Serializable {

	// Champs

	private List<Document> listeDocument;

	@Inject
	private ModelConnexion modelConnexion;
	
	@Inject
	private ModelCategorie modelCategorie;

	private Document courant;

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
	
	public List<Document> getListeDocument2() {
		if (listeDocument == null) {
			listeDocument = new ArrayList<>();
			for (DtoDocument dto : serviceDocument.listerToutDocument2(modelConnexion.getCompteActif().getId())) {
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

	public Document getCourant() {
		if (courant == null) {
			courant = new Document();
		}
		return courant;
	}

// Initialisaitons

	public String actualiserCourant() {
		if (courant != null) {
			DtoDocument dto = serviceDocument.retrouver(courant.getIdDocument());
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

	public String validerMiseAJour(int idCategorie) {
		try {
			if (courant.getIdDocument() == null) {
				serviceDocument.inserer(mapper.map(courant), idCategorie);
			} else {
				serviceDocument.modifier(mapper.map(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return null;
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Document item ) {
		try {
			serviceDocument.supprimer( item.getIdDocument() );
			//listeDocument.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
			return null;
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
}
