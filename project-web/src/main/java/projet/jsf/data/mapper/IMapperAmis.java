package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoAmis;
import projet.commun.dto.DtoCategorie;
import projet.jsf.data.Amis;
import projet.jsf.data.Categorie;


@Mapper( componentModel = "cdi" )
public interface IMapperAmis {
  

	// Compte
	
	Amis   map( DtoAmis source );
	
	DtoAmis map( Amis source );
	
	Amis duplicate( Amis source );

	Amis update( @MappingTarget Amis target, Amis source );

}
