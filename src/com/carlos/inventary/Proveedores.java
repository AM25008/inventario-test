package com.carlos.inventary;

public class Proveedores {
	String nombreProveedor;
	String telefonoProveedor;
	String emailProveedor;
	
	public Proveedores(String nombreProveedor, String telefonoProveedor, String emailProveedor) {
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.emailProveedor = emailProveedor;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
}
