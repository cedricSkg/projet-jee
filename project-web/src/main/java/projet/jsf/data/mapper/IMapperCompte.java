package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.jsf.data.Compte;


@Mapper( componentModel = "cdi" )
public interface IMapperCompte {
  

	// Compte
	Compte   map( projet.ejb.data.Compte source );
	Compte   map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte duplicate( Compte source );

	Compte update( @MappingTarget Compte target, Compte source );

}
