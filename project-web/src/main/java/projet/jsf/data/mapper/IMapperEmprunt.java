package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoEmprunt;
import projet.jsf.data.Emprunt;


@Mapper( componentModel = "cdi" )
public interface IMapperEmprunt {
  

	// Compte
	
	Emprunt   map( DtoEmprunt source );
	
	DtoEmprunt map( Emprunt source );
	
	Emprunt duplicate( Emprunt source );

	Emprunt update( @MappingTarget Emprunt target, Emprunt source );

}
