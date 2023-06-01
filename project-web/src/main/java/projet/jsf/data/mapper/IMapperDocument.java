package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoDocument;
import projet.jsf.data.Document;


@Mapper( componentModel = "cdi" )
public interface IMapperDocument {
  

	// Compte
	
	Document   map( DtoDocument source );
	
	DtoDocument map( Document source );
	
	Document duplicate( Document source );

	Document update( @MappingTarget Document target, Document source );

}
