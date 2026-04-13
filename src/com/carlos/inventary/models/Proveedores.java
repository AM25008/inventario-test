package com.carlos.inventary.models;

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
	
    public void setNombreProveedor(String nombreProveedor) {
    	this.nombreProveedor = nombreProveedor;
    }
    
    public void setTelefonoProveedor(String telefonoProveedor) {
    	this.telefonoProveedor = telefonoProveedor;
    }
    
    public void setEmailProveedor(String emailProveedor) {
    	this.emailProveedor = emailProveedor;
    }
}
