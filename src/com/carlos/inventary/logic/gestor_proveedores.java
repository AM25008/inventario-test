package com.carlos.inventary.logic;

import com.carlos.inventary.models.Proveedores;
import java.util.List;
import java.util.ArrayList;

public class gestor_proveedores {
	private List<Proveedores> listaProveedores = new ArrayList<>();
	
	public void validarNombreProv(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		
		if (!nombre.matches("[a-zA-Z ]+")) {
			throw new IllegalArgumentException("El nombre debe contener unicamente letras");
		}
	}
	
	public void validarTelefono(String telefono) {
		if(telefono == null || telefono.trim().isEmpty()) {
			throw new IllegalArgumentException("El telefono no puede quedar vacio");
		}
		
		if (!telefono.matches("\\d{3}-\\d{3}")) {
			throw new IllegalArgumentException("Formato de telefono no valido. Formato: 123-456");
		}
	}
	
	public void validarEmail(String email) {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("El email no puede quedar vacio");
		}
		
		if(!email.matches("^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
			throw new IllegalArgumentException("Email no valido");
		}
	}
	
	public void validarProveedorRegistrado(String nombre) {
		for (Proveedores prov : listaProveedores) {
			if(prov.getNombreProveedor().equalsIgnoreCase(nombre)) {
				throw new IllegalArgumentException("El proveedor ya ha sido registrado");
			}
		}
	}
	
	public void registrarProveedor(String nombre, String telefono, String email) {
		validarNombreProv(nombre);
		validarProveedorRegistrado(nombre);
		validarTelefono(telefono);
		validarEmail(email);
		
		listaProveedores.add(new Proveedores(nombre, telefono, email));
	}
	
}
