package com.carlos.inventary.models;

public class Productos {
	private String nombreProducto;
	private int stockProducto;
	private Proveedores proveedorProducto;
	private double precioProducto;
	private String descripcionProducto;
	
	public Productos(String nombreProducto, int stockProducto, Proveedores proveedorProducto, double precioProducto, String descripcionProducto){
		this.nombreProducto = nombreProducto;
		this.stockProducto = stockProducto;
		this.proveedorProducto = proveedorProducto;
		this.precioProducto = precioProducto;
		this.descripcionProducto = descripcionProducto;
	}
	
	public String getNombreProducto(){
		return nombreProducto;
	}
	
	public int getStockProducto() {
		return stockProducto;
	}
	
	public Proveedores getProveedor() {
		return proveedorProducto;
	}
	
	public double getPrecioProducto() {
		return precioProducto;
	}
	
	public String getDescripcion() {
		return descripcionProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	public void setDescripcion(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	
	
}
