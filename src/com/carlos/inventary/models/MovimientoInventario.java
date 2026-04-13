package com.carlos.inventary.models;

public class MovimientoInventario {
	private String nombreProducto;
	private String tipoMovimiento;
	private int cantidad;
	private String fecha;
	
	public MovimientoInventario(String nombreProducto, String tipoMovimiento, int cantidad, String fecha) {
		this.nombreProducto = nombreProducto;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	public String getNombreProduco() {
		return nombreProducto;
	}
	
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getFecha() {
		return fecha;
	}
	
}
