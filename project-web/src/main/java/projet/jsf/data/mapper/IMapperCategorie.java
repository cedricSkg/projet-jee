package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCategorie;
import projet.jsf.data.Categorie;


@Mapper( componentModel = "cdi" )
public interface IMapperCategorie {
  

	// Compte
	
	Categorie   map( DtoCategorie source );
	
	DtoCategorie map( Categorie source );
	
	Categorie duplicate( Categorie source );

	Categorie update( @MappingTarget Categorie target, Categorie source );

}
