package mx.unam.dgtic.proyectofinal7.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unam.dgtic.proyectofinal7.models.dao.IUsuariosDao;
import mx.unam.dgtic.proyectofinal7.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuariosDao usuariosDao;

	@Override
	public Iterable<Usuario> findAll() {
		return usuariosDao.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuariosDao.findById(id);
	}

	@Override
	public Usuario save(Usuario u) {
		return usuariosDao.save(u);
	}

	@Override
	public void deleteById(Integer id) {
		usuariosDao.deleteById(id);
	}

}
