package mx.unam.dgtic.proyectofinal7.models.repository;

import org.springframework.data.repository.CrudRepository;

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal7.models.entity.SecuenciaDetalle;

public interface ISecuenciaDetalleRepository extends CrudRepository<SecuenciaDetalle, Integer> {

}
