package mx.unam.dgtic.proyectofinal7.models.dao;

import org.springframework.data.repository.CrudRepository;

import mx.unam.dgtic.proyectofinal7.models.entity.Usuario;

public interface IUsuariosDao extends CrudRepository<Usuario, Integer> {

}
