package com.carlos.inventary.logic;

import com.carlos.inventary.models.MovimientoInventario;
import com.carlos.inventary.models.Productos;

import java.util.List;
import java.util.ArrayList;

public class gestor_movimientos {
	private gestor_productos gestorProductos;
	
	public gestor_movimientos(gestor_productos gestorProductos) {
		this.gestorProductos = gestorProductos;
	}
	private List<MovimientoInventario> listaMovimientos = new ArrayList<>();
	
	public int validarEntrada(String cant) {
		if (cant == null || cant.trim().isEmpty()) {
			throw new IllegalArgumentException("La cantidad no puede ser nula");
		}
		
		if (!cant.matches("\\d+")) {
			throw new IllegalArgumentException("La cantidad debe ser numerica");
		}
		
		int cantidad = Integer.parseInt(cant);
		
		if(cantidad < 0) {
			throw new IllegalArgumentException("La cantidad no puede ser negativa");
		}
		
		return cantidad;
	}
	
	public int validarSalida(String cant, int stock) {
		if (cant == null || cant.trim().isEmpty()) {
			throw new IllegalArgumentException("La cantidad no puede ser nula");
		}
		
		if (!cant.matches("\\d+")) {
			throw new IllegalArgumentException("La cantidad debe ser numerica");
		}
		
		int cantidad = Integer.parseInt(cant);
		
		if(cantidad > stock) {
			throw new IllegalArgumentException("No hay suficiente stock disponible");
		}
		
		return cantidad;
	}
	
	public void registrarEntrada(String nombre, String tipo, int cantidad, String fecha, String hora) {
		listaMovimientos.add(new MovimientoInventario(nombre, tipo, cantidad, fecha, hora));
	}
	
	public void registrarSalida(String nombre, String tipo, int cantidad, String fecha, String hora) {
		listaMovimientos.add(new MovimientoInventario(nombre, tipo, cantidad, fecha, hora));
	}
	
	public List<MovimientoInventario> getMovimientos() {
		return listaMovimientos;
	}
	
}
