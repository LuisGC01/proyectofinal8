package mx.unam.dgtic.proyectofinal7.models.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.dgtic.proyectofinal7.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal7.models.entity.DerivadaModeloMatematico;
import mx.unam.dgtic.proyectofinal7.models.entity.Imagen;
import mx.unam.dgtic.proyectofinal7.models.entity.MagnitudArreglo;
import mx.unam.dgtic.proyectofinal7.models.entity.MagnitudDetalle;
import mx.unam.dgtic.proyectofinal7.models.entity.ModeloMatematico;
import mx.unam.dgtic.proyectofinal7.models.entity.Usuario;
import mx.unam.dgtic.proyectofinal7.models.repository.IArregloMedicionRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IDerivadaModeloMatematicoRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IImagenRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IMagnitudArregloRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IMagnitudDetalleRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IModeloMatematicoRepository;
import mx.unam.dgtic.proyectofinal7.models.repository.IUsuarioRepository;

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

	@Autowired
	private IUsuarioRepository usuarioRepository;

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
	public void eliminarArregloPorId(Integer id) {
		
		ArregloMedicion amr=arregloMedicionRepository.findById(id).get();
		
		for (MagnitudArreglo mar : amr.getModeloMatematico().getMagnitudesArreglo()) {
			if (mar.getMagnitudDetalle() != null) {
				magnitudDetalleRepository.deleteById(mar.getMagnitudDetalle().getIdMagnitudDetalle());
			}
			magnitudArregloRepository.deleteById(mar.getIdMagnitudArreglo());
		}
		
		for (DerivadaModeloMatematico dmmr : amr.getModeloMatematico().getDerivadasModeloMatematico()) {
			derivadaModeloMatematicoRepository.deleteById(dmmr.getIdDerivadaModeloMatematico());
		}
		modeloMatematicoRepository.deleteById(amr.getModeloMatematico().getIdModeloMatematico());
		arregloMedicionRepository.deleteById(amr.getIdArregloMedicion());
	}



	@Override
	@Transactional
	public ArregloMedicion insertarArreglo(ArregloMedicion entity) {
		// TODO Auto-generated method stub

		Imagen ir1 = imagenRepository.save(new Imagen(entity.getImagen().getImagen(), entity.getImagen().getLeyenda(),
				entity.getImagen().getDescripcion()));
		ArregloMedicion amaux = new ArregloMedicion(entity.getTitulo(), LocalDateTime.now(), entity.getVersion(),
				entity.getDescripcion(), entity.getFormatoCalCert());
		amaux.setImagen(ir1);
		Usuario u = entity.getUsuario();
		amaux.setUsuario(usuarioRepository.findById(u.getIdUsuario()).get());
		ArregloMedicion amr = arregloMedicionRepository.save(amaux);
		ModeloMatematico mmr = modeloMatematicoRepository
				.save(new ModeloMatematico(entity.getModeloMatematico().getEcuacion(), amr));
		Set<DerivadaModeloMatematico> derivadas = new HashSet<DerivadaModeloMatematico>();
		for (DerivadaModeloMatematico dme : entity.getModeloMatematico().getDerivadasModeloMatematico()) {
			DerivadaModeloMatematico dmr = derivadaModeloMatematicoRepository
					.save(new DerivadaModeloMatematico(dme.getDerivadaParcial(), dme.getRespectoA(), modeloMatematicoRepository.findById(mmr.getIdModeloMatematico()).get()));
			derivadas.add(dme);
		}

		Set<MagnitudArreglo> magnitudes = new HashSet<MagnitudArreglo>();

		for (MagnitudArreglo mae : entity.getModeloMatematico().getMagnitudesArreglo()) {
			MagnitudArreglo mar = magnitudArregloRepository.save(new MagnitudArreglo(mae.getMagnitud(), mae.getUnidad(),
					mae.getDefinicion(), mae.getCapturar(), mae.getRepetir(), mae.getAsociado(), mmr));
			if (mae.getMagnitudDetalle() != null) {
				Imagen ir2 = imagenRepository.save(new Imagen(mae.getMagnitudDetalle().getImagen().getImagen(),
						mae.getMagnitudDetalle().getImagen().getLeyenda(),
						mae.getMagnitudDetalle().getImagen().getDescripcion()));
				MagnitudDetalle mdr = magnitudDetalleRepository
						.save(new MagnitudDetalle(mae.getMagnitudDetalle().getTipo(),
								mae.getMagnitudDetalle().getDescripcion(), mae.getMagnitudDetalle().getDistribucion(),
								mae.getMagnitudDetalle().getEvaluacionIncertidumbre(),
								mae.getMagnitudDetalle().getMetodoObservacion(), mae.getMagnitudDetalle().getValor(),
								ir2, mar));
				mar.setMagnitudDetalle(mdr);
			}
			magnitudes.add(mar);
		}

		mmr.setDerivadasModeloMatematico(derivadas);
		mmr.setMagnitudesArreglo(magnitudes);
		amr.setModeloMatematico(mmr);

		return amr;
	}

	@Override
	@Transactional
	public ArregloMedicion actualizarArreglo(ArregloMedicion entity) {
		// TODO Auto-generated method stub
		
		Imagen ir1 = imagenRepository.save(entity.getImagen());
		ArregloMedicion amaux = new ArregloMedicion(entity.getIdArregloMedicion(),entity.getTitulo(), LocalDateTime.now(), entity.getVersion(),
				entity.getDescripcion(), entity.getFormatoCalCert(),ir1,usuarioRepository.findById(entity.getUsuario().getIdUsuario()).get());
		//amaux.setImagen(ir1);
		//Usuario u = entity.getUsuario();
		//amaux.setUsuario();
		ArregloMedicion amr = arregloMedicionRepository.save(amaux);
		ModeloMatematico mmr = modeloMatematicoRepository
				.save(new ModeloMatematico(entity.getModeloMatematico().getIdModeloMatematico(),entity.getModeloMatematico().getEcuacion(), amr));
		Set<DerivadaModeloMatematico> derivadas = new HashSet<DerivadaModeloMatematico>();
		for (DerivadaModeloMatematico dme : entity.getModeloMatematico().getDerivadasModeloMatematico()) {
			DerivadaModeloMatematico dmr = derivadaModeloMatematicoRepository
					.save(new DerivadaModeloMatematico(dme.getIdDerivadaModeloMatematico(),dme.getDerivadaParcial(), dme.getRespectoA(), modeloMatematicoRepository.findById(mmr.getIdModeloMatematico()).get()));
			derivadas.add(dme);
		}

		Set<MagnitudArreglo> magnitudes = new HashSet<MagnitudArreglo>();

		for (MagnitudArreglo mae : entity.getModeloMatematico().getMagnitudesArreglo()) {
			MagnitudArreglo mar = magnitudArregloRepository.save(new MagnitudArreglo(mae.getIdMagnitudArreglo(),mae.getMagnitud(), mae.getUnidad(),
					mae.getDefinicion(), mae.getCapturar(), mae.getRepetir(), mae.getAsociado(), mmr));
			if (mae.getMagnitudDetalle() != null) {
				Imagen ir2 = imagenRepository.save(new Imagen(mae.getMagnitudDetalle().getImagen().getIdImagen(),mae.getMagnitudDetalle().getImagen().getImagen(),
						mae.getMagnitudDetalle().getImagen().getLeyenda(),
						mae.getMagnitudDetalle().getImagen().getDescripcion()));
				MagnitudDetalle mdr = magnitudDetalleRepository
						.save(new MagnitudDetalle(mae.getMagnitudDetalle().getIdMagnitudDetalle(),mae.getMagnitudDetalle().getTipo(),
								mae.getMagnitudDetalle().getDescripcion(), mae.getMagnitudDetalle().getDistribucion(),
								mae.getMagnitudDetalle().getEvaluacionIncertidumbre(),
								mae.getMagnitudDetalle().getMetodoObservacion(), mae.getMagnitudDetalle().getValor(),
								ir2, mar));
				mar.setMagnitudDetalle(mdr);
			}
			magnitudes.add(mar);
		}

		mmr.setDerivadasModeloMatematico(derivadas);
		mmr.setMagnitudesArreglo(magnitudes);
		amr.setModeloMatematico(mmr);

		return amr;
		
		//return null;
	}

}
