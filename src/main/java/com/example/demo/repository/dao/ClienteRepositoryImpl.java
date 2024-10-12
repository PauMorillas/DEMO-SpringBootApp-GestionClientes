package com.example.demo.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Recomendacion;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	private static List<Cliente> datos = new ArrayList<Cliente>();

	static {
		// Creamos 5 clientes
		Cliente c1 = new Cliente();
		c1.setId(Long.valueOf(datos.size() + 1));
		c1.setNombre("Antonio");
		c1.setApellidos("Lopez");
		c1.setNif("11111111A");
		c1.setEmail("antonio.loapez@prueba.com");
		c1.setClaveSeg("12345");

		Recomendacion r1 = new Recomendacion();
		r1.setId(Long.valueOf(datos.size() + 1));
		r1.setObservaciones("No tiene ninguna.");
		r1.setCliente(c1);
		c1.setRecomendacion(r1);

		datos.add(c1);

		Cliente c2 = new Cliente();
		c2.setId(Long.valueOf(datos.size() + 1));
		c2.setNombre("Beatriz");
		c2.setApellidos("Martinez");
		c2.setNif("22222222B");
		c2.setEmail("beatriz.martinez@prueba.com");
		c2.setClaveSeg("abcde");

		Recomendacion r2 = new Recomendacion();
		r2.setId(Long.valueOf(datos.size() + 1));
		r2.setObservaciones("Buena cliente.");
		r2.setCliente(c2);
		c2.setRecomendacion(r2);
		datos.add(c2);

		Cliente c3 = new Cliente();
		c3.setId(Long.valueOf(datos.size() + 1));
		c3.setNombre("Carlos");
		c3.setApellidos("Fernandez");
		c3.setNif("33333333C");
		c3.setEmail("carlos.fernandez@prueba.com");
		c3.setClaveSeg("qwerty");

		Recomendacion r3 = new Recomendacion();
		r3.setId(Long.valueOf(datos.size() + 1));
		r3.setObservaciones("Cliente con historial de recomendaciones.");
		r3.setCliente(c3);
		c3.setRecomendacion(r3);
		datos.add(c3);

		Cliente c4 = new Cliente();
		c4.setId(Long.valueOf(datos.size() + 1));
		c4.setNombre("Diana");
		c4.setApellidos("Gomez");
		c4.setNif("44444444D");
		c4.setEmail("diana.gomez@prueba.com");
		c4.setClaveSeg("xyz123");

		Recomendacion r4 = new Recomendacion();
		r4.setId(Long.valueOf(datos.size() + 1));
		r4.setObservaciones("Ninguna observación relevante.");
		r4.setCliente(c4);
		c4.setRecomendacion(r4);
		datos.add(c4);

		Cliente c5 = new Cliente();
		c5.setId(Long.valueOf(datos.size() + 1));
		c5.setNombre("Eduardo");
		c5.setApellidos("Ruiz");
		c5.setNif("55555555E");
		c5.setEmail("eduardo.ruiz@prueba.com");
		c5.setClaveSeg("edr123");

		Recomendacion r5 = new Recomendacion();
		r5.setId(Long.valueOf(datos.size() + 1));
		r5.setObservaciones("Cliente recomendado por otros.");
		r5.setCliente(c5);
		c5.setRecomendacion(r5);
		datos.add(c5);
	}

	@Override
	public List<Cliente> findAll() {
		return datos;
	}

	@Override
	public Cliente findById(Cliente cliente) {
		int posicion = datos.indexOf(cliente);
		return datos.get(posicion);
	}

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null) {
			int posicion = datos.indexOf(cliente);
			datos.set(posicion, cliente);
		} else {
			Long id = datos.get(datos.size() - 1).getId() + 1;
			cliente.setId(id);
			cliente.getRecomendacion().setId(id);
			datos.add(cliente);
		}

	}

	@Override
	public void delete(Cliente cliente) {
		int posicion = datos.indexOf(cliente);
		datos.remove(posicion);
	}

}
