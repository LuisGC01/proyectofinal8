package mx.unam.dgtic.proyectofinal7.models.service;

import java.util.Optional;

import mx.unam.dgtic.proyectofinal7.models.entity.SecuenciaDetalle;
import mx.unam.dgtic.proyectofinal7.models.entity.SecuenciaMedicion;

public interface ISecuenciaService {

	Iterable<SecuenciaMedicion> findAll();

	Optional<SecuenciaMedicion> findById(Integer id);

	SecuenciaMedicion insertarSecuencia(SecuenciaMedicion s);

	SecuenciaMedicion actualizarSecuencia(SecuenciaMedicion s);

	void borrarSecuenciaPorId(Integer id);


}
