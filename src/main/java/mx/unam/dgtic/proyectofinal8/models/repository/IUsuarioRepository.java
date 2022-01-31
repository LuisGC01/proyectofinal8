package mx.unam.dgtic.proyectofinal8.models.repository;

import org.springframework.data.repository.CrudRepository;

import mx.unam.dgtic.proyectofinal8.models.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

}
