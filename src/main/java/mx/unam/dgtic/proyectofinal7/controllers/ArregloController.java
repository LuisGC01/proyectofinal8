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

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal7.models.service.IArregloService;

@RestController
@RequestMapping("/arreglos")
public class ArregloController {

	@Autowired
	private IArregloService arregloService;

	@GetMapping("/{id}")
	public ArregloMedicion buscarPorId(@PathVariable Integer id) {
		return arregloService.findById(id).get();
	}

	@GetMapping
	public Iterable<ArregloMedicion> buscarTodos() {
		return arregloService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ArregloMedicion insertarArreglo(@RequestBody ArregloMedicion entity) {
		return arregloService.insertarArreglo(entity);
		//arregloService.save(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarArreglo(@PathVariable Integer id, @RequestBody ArregloMedicion entity) {
		Optional<ArregloMedicion> o = arregloService.findById(id);
		
		if (o.isPresent()) {
			ArregloMedicion arregloMedicion = entity;
			arregloMedicion.setIdArregloMedicion(id);
			arregloService.actualizarArreglo(arregloMedicion);
		}
		
		//entity.setIdArregloMedicion(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ArregloMedicion> eliminarArregloPorId(@PathVariable Integer id) {
		Optional<ArregloMedicion> o = arregloService.findById(id);
		if (o.isPresent()) {
			arregloService.eliminarArregloPorId(id);
			return new ResponseEntity<ArregloMedicion>(HttpStatus.OK);
		} else {
			return new ResponseEntity<ArregloMedicion>(HttpStatus.NOT_FOUND);
		}
	}

}
