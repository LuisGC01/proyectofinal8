package mx.unam.dgtic.proyectofinal8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import mx.unam.dgtic.proyectofinal8.models.entity.ArregloMedicion;
import mx.unam.dgtic.proyectofinal8.models.entity.SecuenciaMedicion;
import mx.unam.dgtic.proyectofinal8.models.entity.Usuario;
import mx.unam.dgtic.proyectofinal8.models.service.IArregloService;
import mx.unam.dgtic.proyectofinal8.models.service.ISecuenciaService;
import mx.unam.dgtic.proyectofinal8.models.service.IUsuarioService;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" })
class Proyectofinal7ApplicationTests {

	@Autowired
	private IUsuarioService iUsuarioService;

	@Autowired
	private IArregloService iArregloService;

	@Autowired
	private ISecuenciaService iSecuenciaService;

	@Test
	void buscarTodosUsuariosTest() {
		Iterable<Usuario> it = iUsuarioService.findAll();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		it.forEach(usuarios::add);
		usuarios.forEach(System.out::println);
		assertThat(usuarios.size(), greaterThan(0));
	}

	@Test
	void buscarTodosArreglosTest() {
		Iterable<ArregloMedicion> it = iArregloService.findAll();
		List<ArregloMedicion> usuarios = new ArrayList<ArregloMedicion>();
		it.forEach(usuarios::add);
		usuarios.forEach(System.out::println);
		assertThat(usuarios.size(), greaterThan(0));
	}

	@Test
	void buscarTodasSecuenciasTest() {
		Iterable<SecuenciaMedicion> it = iSecuenciaService.findAll();
		List<SecuenciaMedicion> usuarios = new ArrayList<SecuenciaMedicion>();
		it.forEach(usuarios::add);
		usuarios.forEach(System.out::println);
		assertThat(usuarios.size(), greaterThan(0));
	}

}
