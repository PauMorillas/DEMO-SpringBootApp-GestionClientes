package com.example.demo.repository.entity;

import java.util.Objects;

import lombok.Data;

// Anotación de lombok - Define automáticamente los getters y setters de los datos de cliente entre otros
@Data
public class Cliente {

	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeg;
	private String email;
	private Recomendacion recomendacion;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
