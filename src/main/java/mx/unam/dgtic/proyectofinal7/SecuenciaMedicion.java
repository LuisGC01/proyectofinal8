package mx.unam.proyectoFinal.service.dto;

import java.time.LocalDateTime;

public class SecuenciaMedicion {
	private Integer idSecuenciaMedicion;
	private String titulo;
	private String descripcion;
	private LocalDateTime fecha;
	private Integer idUsuario;

	public SecuenciaMedicion() {
		// TODO Auto-generated constructor stub
	}

	public SecuenciaMedicion(Integer idSecuenciaMedicion, String titulo, String descripcion, LocalDateTime fecha,
			Integer idUsuario) {
		this.idSecuenciaMedicion = idSecuenciaMedicion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "SecuenciaMedicion [idSecuenciaMedicion=" + idSecuenciaMedicion + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", idUsuario=" + idUsuario + "]";
	}
}
