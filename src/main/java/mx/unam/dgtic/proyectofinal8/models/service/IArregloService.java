package mx.unam.dgtic.proyectofinal8.models.service;

import java.util.List;
import java.util.Optional;

import mx.unam.dgtic.proyectofinal8.models.entity.ArregloMedicion;

public interface IArregloService {

	public abstract Optional<ArregloMedicion> findById(Integer id);

	public abstract Iterable<ArregloMedicion> findAll();

	public abstract ArregloMedicion insertarArreglo(ArregloMedicion entity);

	public abstract ArregloMedicion actualizarArreglo(ArregloMedicion entity);

	public abstract void eliminarArregloPorId(Integer id);

	public abstract List<ArregloMedicion> findByUsuario(Integer idUsuario);

}
