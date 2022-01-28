package mx.unam.dgtic.proyectofinal7.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal7.models.entity.Usuario;

public interface IArregloMedicionRepository extends CrudRepository<ArregloMedicion, Integer> {
	
	public abstract List<ArregloMedicion> findByUsuario(Usuario usuario);

}
