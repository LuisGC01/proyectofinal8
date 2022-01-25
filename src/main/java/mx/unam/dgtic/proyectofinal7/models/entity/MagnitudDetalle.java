package mx.unam.dgtic.proyectofinal7.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "magnitud_detalle")
public class MagnitudDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3310351252038668929L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_magnitud_detalle")
	private Integer idMagnitudDetalle;

	@Column(name = "mag_det_tipo")
	private String tipo;

	@Column(name = "mag_det_descripcion")
	private String descripcion;

	@Column(name = "mag_det_distribucion")
	private String distribucion;

	@Column(name = "mag_det_evaluacion_incertidumbre")
	private String evaluacionIncertidumbre;

	@Column(name = "mag_det_metodo_observacion")
	private String metodoObservacion;

	@Column(name = "mag_det_valor")
	private Double valor;

	@OneToOne(targetEntity = Imagen.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_imagen", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Imagen imagen;

	@OneToOne(targetEntity = MagnitudArreglo.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_magnitud_arreglo", nullable = false)
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private MagnitudArreglo magnitudArreglo;

	public MagnitudDetalle() {
		// TODO Auto-generated constructor stub
	}

	public MagnitudDetalle(Integer idMagnitudDetalle, String tipo, String descripcion, String distribucion,
			String evaluacionIncertidumbre, String metodoObservacion, Double valor, Imagen imagen,
			MagnitudArreglo magnitudArreglo) {
		this.idMagnitudDetalle = idMagnitudDetalle;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.distribucion = distribucion;
		this.evaluacionIncertidumbre = evaluacionIncertidumbre;
		this.metodoObservacion = metodoObservacion;
		this.valor = valor;
		this.imagen = imagen;
		this.magnitudArreglo = magnitudArreglo;
	}

	public MagnitudDetalle(String tipo, String descripcion, String distribucion, String evaluacionIncertidumbre,
			String metodoObservacion, Double valor) {
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.distribucion = distribucion;
		this.evaluacionIncertidumbre = evaluacionIncertidumbre;
		this.metodoObservacion = metodoObservacion;
		this.valor = valor;
	}

	public MagnitudDetalle(String tipo, String descripcion, String distribucion, String evaluacionIncertidumbre,
			String metodoObservacion, Double valor, Imagen imagen, MagnitudArreglo magnitudArreglo) {
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.distribucion = distribucion;
		this.evaluacionIncertidumbre = evaluacionIncertidumbre;
		this.metodoObservacion = metodoObservacion;
		this.valor = valor;
		this.imagen = imagen;
		this.magnitudArreglo = magnitudArreglo;
	}

	public MagnitudDetalle(Integer idMagnitudDetalle, String tipo, String descripcion, String distribucion,
			String evaluacionIncertidumbre, String metodoObservacion, Double valor) {
		this.idMagnitudDetalle = idMagnitudDetalle;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.distribucion = distribucion;
		this.evaluacionIncertidumbre = evaluacionIncertidumbre;
		this.metodoObservacion = metodoObservacion;
		this.valor = valor;
	}

	public Integer getIdMagnitudDetalle() {
		return idMagnitudDetalle;
	}

	public void setIdMagnitudDetalle(Integer idMagnitudDetalle) {
		this.idMagnitudDetalle = idMagnitudDetalle;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(String distribucion) {
		this.distribucion = distribucion;
	}

	public String getEvaluacionIncertidumbre() {
		return evaluacionIncertidumbre;
	}

	public void setEvaluacionIncertidumbre(String evaluacionIncertidumbre) {
		this.evaluacionIncertidumbre = evaluacionIncertidumbre;
	}

	public String getMetodoObservacion() {
		return metodoObservacion;
	}

	public void setMetodoObservacion(String metodoObservacion) {
		this.metodoObservacion = metodoObservacion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public MagnitudArreglo getMagnitudArreglo() {
		return magnitudArreglo;
	}

	public void setMagnitudArreglo(MagnitudArreglo magnitudArreglo) {
		this.magnitudArreglo = magnitudArreglo;
	}

}
