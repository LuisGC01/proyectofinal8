package mx.unam.dgtic.proyectofinal7.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal7.models.repository.IArregloMedicionRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IDerivadaModeloMatematicoRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IImagenRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IMagnitudArregloRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IMagnitudDetalleRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IModeloMatematicoRepository;

@Service
public class ArregloServiceImpl implements IArregloService {

	@Autowired
	private IImagenRepository imagenRepository;

	@Autowired
	private IArregloMedicionRepository arregloMedicionRepository;

	@Autowired
	private IModeloMatematicoRepository modeloMatematicoRepository;

	@Autowired
	private IDerivadaModeloMatematicoRepository derivadaModeloMatematicoRepository;

	@Autowired
	private IMagnitudArregloRepository magnitudArregloRepository;

	@Autowired
	private IMagnitudDetalleRepository magnitudDetalleRepository;

	public ArregloServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ArregloMedicion> findById(Integer id) {
		
	return arregloMedicionRepository.findById(id);
	
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ArregloMedicion> findAll() {
		return arregloMedicionRepository.findAll();

	}

	@Override
	@Transactional
	public ArregloMedicion save(ArregloMedicion entity) {
		return arregloMedicionRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		arregloMedicionRepository.deleteById(id);
	}

}
