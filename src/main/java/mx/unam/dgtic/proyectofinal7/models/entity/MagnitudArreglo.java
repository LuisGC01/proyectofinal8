package mx.unam.dgtic.proyectofinal7.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "magnitud_arreglo")
public class MagnitudArreglo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7795149520782695069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_magnitud_arreglo")
	private Integer idMagnitudArreglo;

	@Column(name = "mag_arr_magnitud")
	private String magnitud;

	@Column(name = "mag_arr_unidad")
	private String unidad;

	@Column(name = "mag_arr_definicion")
	private String definicion;

	@Column(name = "mag_arr_capturar")
	private Boolean capturar;

	@Column(name = "mag_arr_repetir")
	private Boolean repetir;

	@Column(name = "mag_arr_asociado")
	private String asociado;

	@ManyToOne(targetEntity = ModeloMatematico.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_modelo_matematico", nullable = false)
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private ModeloMatematico modeloMatematico;

	@OneToOne(mappedBy = "magnitudArreglo", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private MagnitudDetalle magnitudDetalle;

	public MagnitudArreglo() {
		// TODO Auto-generated constructor stub
	}

	public MagnitudArreglo(Integer idMagnitudArreglo, String magnitud, String unidad, String definicion,
			Boolean capturar, Boolean repetir, String asociado, ModeloMatematico modeloMatematico,
			MagnitudDetalle magnitudDetalle) {
		this.idMagnitudArreglo = idMagnitudArreglo;
		this.magnitud = magnitud;
		this.unidad = unidad;
		this.definicion = definicion;
		this.capturar = capturar;
		this.repetir = repetir;
		this.asociado = asociado;
		this.modeloMatematico = modeloMatematico;
		this.magnitudDetalle = magnitudDetalle;
	}

	public MagnitudArreglo(String magnitud, String unidad, String definicion, Boolean capturar, Boolean repetir,
			String asociado) {
		this.magnitud = magnitud;
		this.unidad = unidad;
		this.definicion = definicion;
		this.capturar = capturar;
		this.repetir = repetir;
		this.asociado = asociado;
	}

	public MagnitudArreglo(String magnitud, String unidad, String definicion, Boolean capturar, Boolean repetir,
			String asociado, ModeloMatematico modeloMatematico, MagnitudDetalle magnitudDetalle) {
		this.magnitud = magnitud;
		this.unidad = unidad;
		this.definicion = definicion;
		this.capturar = capturar;
		this.repetir = repetir;
		this.asociado = asociado;
		this.modeloMatematico = modeloMatematico;
		this.magnitudDetalle = magnitudDetalle;
	}

	public MagnitudArreglo(Integer idMagnitudArreglo, String magnitud, String unidad, String definicion,
			Boolean capturar, Boolean repetir, String asociado) {
		this.idMagnitudArreglo = idMagnitudArreglo;
		this.magnitud = magnitud;
		this.unidad = unidad;
		this.definicion = definicion;
		this.capturar = capturar;
		this.repetir = repetir;
		this.asociado = asociado;
	}

	public Integer getIdMagnitudArreglo() {
		return idMagnitudArreglo;
	}

	public void setIdMagnitudArreglo(Integer idMagnitudArreglo) {
		this.idMagnitudArreglo = idMagnitudArreglo;
	}

	public String getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public Boolean getCapturar() {
		return capturar;
	}

	public void setCapturar(Boolean capturar) {
		this.capturar = capturar;
	}

	public Boolean getRepetir() {
		return repetir;
	}

	public void setRepetir(Boolean repetir) {
		this.repetir = repetir;
	}

	public String getAsociado() {
		return asociado;
	}

	public void setAsociado(String asociado) {
		this.asociado = asociado;
	}

	public ModeloMatematico getModeloMatematico() {
		return modeloMatematico;
	}

	public void setModeloMatematico(ModeloMatematico modeloMatematico) {
		this.modeloMatematico = modeloMatematico;
	}

	public MagnitudDetalle getMagnitudDetalle() {
		return magnitudDetalle;
	}

	public void setMagnitudDetalle(MagnitudDetalle magnitudDetalle) {
		this.magnitudDetalle = magnitudDetalle;
	}

}
