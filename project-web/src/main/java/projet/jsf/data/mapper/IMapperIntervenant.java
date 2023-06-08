package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoIntervenant;
import projet.jsf.data.Intervenant;


@Mapper( componentModel = "cdi" )
public interface IMapperIntervenant {
  

	// Compte
	
	Intervenant   map( DtoIntervenant source );
	
	DtoIntervenant map( Intervenant source );
	
	Intervenant duplicate( Intervenant source );

	Intervenant update( @MappingTarget Intervenant target, Intervenant source );

}
