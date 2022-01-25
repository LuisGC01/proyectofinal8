package mx.unam.dgtic.proyectofinal7.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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

@Entity
@Table(name = "arreglo_medicion")
public class ArregloMedicion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3881095940867153931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_arreglo_medicion")
	private Integer idArregloMedicion;

	@Column(name = "arr_med_titulo")
	private String titulo;

	@Column(name = "arr_med_fecha")
	private LocalDateTime fecha;

	@Column(name = "arr_med_version")
	private String version;

	@Column(name = "arr_med_descripcion")
	private String descripcion;

	@Column(name = "arr_med_formato_cal_cert")
	private String formatoCalCert;

	@OneToOne(targetEntity = Imagen.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_imagen", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Imagen imagen;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Usuario usuario;

	@OneToOne(mappedBy = "arregloMedicion", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	private ModeloMatematico modeloMatematico;

	public ArregloMedicion() {
		// TODO Auto-generated constructor stub
	}

	public ArregloMedicion(Integer idArregloMedicion, String titulo, LocalDateTime fecha, String version,
			String descripcion, String formatoCalCert, Imagen imagen, Usuario usuario,
			ModeloMatematico modeloMatematico) {
		this.idArregloMedicion = idArregloMedicion;
		this.titulo = titulo;
		this.fecha = fecha;
		this.version = version;
		this.descripcion = descripcion;
		this.formatoCalCert = formatoCalCert;
		this.imagen = imagen;
		this.usuario = usuario;
		this.modeloMatematico = modeloMatematico;
	}

	public ArregloMedicion(String titulo, LocalDateTime fecha, String version, String descripcion,
			String formatoCalCert, Imagen imagen, Usuario usuario, ModeloMatematico modeloMatematico) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.version = version;
		this.descripcion = descripcion;
		this.formatoCalCert = formatoCalCert;
		this.imagen = imagen;
		this.usuario = usuario;
		this.modeloMatematico = modeloMatematico;
	}

	public ArregloMedicion(String titulo, LocalDateTime fecha, String version, String descripcion,
			String formatoCalCert) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.version = version;
		this.descripcion = descripcion;
		this.formatoCalCert = formatoCalCert;
	}

	public ArregloMedicion(Integer idArregloMedicion, String titulo, LocalDateTime fecha, String version,
			String descripcion, String formatoCalCert) {
		this.idArregloMedicion = idArregloMedicion;
		this.titulo = titulo;
		this.fecha = fecha;
		this.version = version;
		this.descripcion = descripcion;
		this.formatoCalCert = formatoCalCert;
	}

	public Integer getIdArregloMedicion() {
		return idArregloMedicion;
	}

	public void setIdArregloMedicion(Integer idArregloMedicion) {
		this.idArregloMedicion = idArregloMedicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFormatoCalCert() {
		return formatoCalCert;
	}

	public void setFormatoCalCert(String formatoCalCert) {
		this.formatoCalCert = formatoCalCert;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ModeloMatematico getModeloMatematico() {
		return modeloMatematico;
	}

	public void setModeloMatematico(ModeloMatematico modeloMatematico) {
		this.modeloMatematico = modeloMatematico;
	}

}
