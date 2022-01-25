package mx.unam.dgtic.proyectofinal7.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.dgtic.proyectofinal7.models.entity.Usuario;
import mx.unam.dgtic.proyectofinal7.models.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	public Iterable<Usuario> buscarTodos() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	public Usuario buscarUsuario(@PathVariable Integer id) {
		return usuarioService.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void insertarUsuario(@RequestBody Usuario u) {
		usuarioService.save(u);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
		Optional<Usuario> o = usuarioService.findById(id);
		if (o.isPresent()) {
			Usuario usuario = u;
			usuario.setIdUsuario(id);
			usuarioService.save(usuario);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> eliminarUsuarioPorId(@PathVariable Integer id) {
		Optional<Usuario> o = usuarioService.findById(id);
		if (o.isPresent()) {
			usuarioService.deleteById(id);
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);

		}

	}

}
