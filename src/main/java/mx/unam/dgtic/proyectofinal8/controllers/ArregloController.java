package mx.unam.dgtic.proyectofinal8.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.dgtic.proyectofinal8.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal8.models.service.IArregloService;

@Controller
@RequestMapping("/arreglos")
public class ArregloController {

	@Autowired
	private IArregloService arregloService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listadoInicial(Model model) {
		Iterable<ArregloMedicion> arreglos = arregloService.findAll();
		model.addAttribute("arreglos", arreglos);
		return "ArreglosDefinidos";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String nuevoArreglo(Model model) {
		
		ArregloMedicion arreglo = new ArregloMedicion();
		
		model.addAttribute("arreglo", arreglo);
		return "crearArreglo";
	}
	
	@RequestMapping(value = "/procesarEcuacion",method = RequestMethod.POST)
	public ModelAndView ecuacionProcesada(@ModelAttribute("arreglo") ArregloMedicion arreglo) {
		System.out.println(arreglo);
		ModelAndView model = new ModelAndView("crearArregloEcuacion");
		model.addObject("arreglo", arreglo);
		return model;
	}
	
	

}
