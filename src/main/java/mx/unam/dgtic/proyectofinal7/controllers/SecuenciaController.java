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

import mx.unam.dgtic.proyectofinal7.models.entity.SecuenciaDetalle;
import mx.unam.dgtic.proyectofinal7.models.entity.SecuenciaMedicion;
import mx.unam.dgtic.proyectofinal7.models.service.ISecuenciaService;

@RestController
@RequestMapping("/secuencias")
public class SecuenciaController {

	@Autowired
	private ISecuenciaService secuenciaService;

	@GetMapping
	public Iterable<SecuenciaMedicion> findAll() {
		return secuenciaService.findAll();
	}

	@GetMapping("/{id}")
	public SecuenciaMedicion findById(@PathVariable Integer id) {
		return secuenciaService.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SecuenciaMedicion insertarSecuencia(@RequestBody SecuenciaMedicion s) {
		return secuenciaService.insertarSecuencia(s);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarSecuencia(@PathVariable Integer id, @RequestBody SecuenciaMedicion s) {
		Optional<SecuenciaMedicion> o = secuenciaService.findById(id);
		if (o.isPresent()) {
			SecuenciaMedicion secuenciaMedicion = s;
			secuenciaMedicion.setIdSecuenciaMedicion(id);
			secuenciaService.actualizarSecuencia(secuenciaMedicion);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SecuenciaMedicion> borrarSecuenciaPorId(@PathVariable Integer id) {
		Optional<SecuenciaMedicion> o = secuenciaService.findById(id);
		if (o.isPresent()) {
			secuenciaService.borrarSecuenciaPorId(id);
			return new ResponseEntity<SecuenciaMedicion>(HttpStatus.OK);
		} else {
			return new ResponseEntity<SecuenciaMedicion>(HttpStatus.NOT_FOUND);
		}
	}

}
