package com.carlos.inventary.models;

public class MovimientoInventario {
	private String nombreProducto;
	private String tipoMovimiento;
	private int cantidad;
	private String fecha;
	private String hora;
	
	public MovimientoInventario(String nombreProducto, String tipoMovimiento, int cantidad, String fecha, String hora) {
		this.nombreProducto = nombreProducto;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.hora = hora;
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
	
	public String getHora() {
		return hora;
	}
	
}
