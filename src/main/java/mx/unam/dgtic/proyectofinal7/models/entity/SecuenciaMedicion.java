package mx.unam.dgtic.proyectofinal7.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "secuencia_medicion")
public class SecuenciaMedicion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6890790289380160993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_secuencia_medicion")
	private Integer idSecuenciaMedicion;

	@Column(name = "sec_med_titulo")
	private String titulo;

	@Column(name = "sec_med_descripcion")
	private String descripcion;

	@Column(name = "sec_med_fecha")
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "secuenciaMedicion")
	private Set<SecuenciaDetalle> secuenciaDetalles;

	public SecuenciaMedicion() {
		// TODO Auto-generated constructor stub
	}

	public SecuenciaMedicion(String titulo, String descripcion, LocalDateTime fecha) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public SecuenciaMedicion(String titulo, String descripcion, LocalDateTime fecha, Usuario usuario) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	public SecuenciaMedicion(Integer idSecuenciaMedicion, String titulo, String descripcion, LocalDateTime fecha,
			Usuario usuario) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	public SecuenciaMedicion(Integer idSecuenciaMedicion, String titulo, String descripcion, LocalDateTime fecha) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public SecuenciaMedicion(Integer idSecuenciaMedicion, String titulo, String descripcion, LocalDateTime fecha,
			Usuario usuario, Set<SecuenciaDetalle> secuenciaDetalles) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.secuenciaDetalles = secuenciaDetalles;
	}

	public SecuenciaMedicion(String titulo, String descripcion, LocalDateTime fecha, Usuario usuario,
			Set<SecuenciaDetalle> secuenciaDetalles) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.secuenciaDetalles = secuenciaDetalles;
	}

	public SecuenciaMedicion(Integer idSecuenciaMedicion) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
	}

	public Integer getIdSecuenciaMedicion() {
		return idSecuenciaMedicion;
	}

	public void setIdSecuenciaMedicion(Integer idSecuenciaMedicion) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<SecuenciaDetalle> getSecuenciaDetalles() {
		return secuenciaDetalles;
	}

	public void setSecuenciaDetalles(Set<SecuenciaDetalle> secuenciaDetalles) {
		this.secuenciaDetalles = secuenciaDetalles;
	}



}
