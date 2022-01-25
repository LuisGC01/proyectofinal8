package mx.unam.dgtic.proyectofinal7.models.service;

import java.util.Optional;

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;

public interface IArregloService {

	public abstract Optional<ArregloMedicion> findById(Integer id);
	public abstract Iterable<ArregloMedicion> findAll();
	public abstract ArregloMedicion save(ArregloMedicion entity);
	public abstract void deleteById(Integer id);


}
