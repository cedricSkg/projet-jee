package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoAmis;
import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDocument;
import projet.commun.dto.DtoEmprunt;
import projet.ejb.data.Amis;
import projet.ejb.data.Categorie;
import projet.ejb.data.Compte;
import projet.ejb.data.Document;
import projet.ejb.data.Emprunt;

@Mapper(componentModel = "cdi")
public interface IMapperEjb {

	static final IMapperEjb INSTANCE = Mappers.getMapper(IMapperEjb.class);

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	// Categorie

	Categorie map(DtoCategorie source);

	DtoCategorie map(Categorie source);

	// Amis
	Amis map(DtoAmis source);

	DtoAmis map(Amis source);

	// Document
	Document map(DtoDocument source);

	DtoDocument map(Document source);

	// Amis
	Emprunt map(DtoEmprunt source);

	DtoEmprunt map(Emprunt source);
}
