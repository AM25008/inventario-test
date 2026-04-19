package com.carlos.inventary.logic;

import com.carlos.inventary.models.Productos;
import com.carlos.inventary.models.Proveedores;

import java.util.List;
import java.util.ArrayList;

public class gestor_productos {
	private List<Productos> listaProductos = new ArrayList<>();
	
	public int validarIndex(String index, int size) {
		if (index == null || index.trim().isEmpty()) {
			throw new IllegalArgumentException("El indice no puede estar vacio");
		}
		
		if (!index.matches("\\d+")) {
			throw new IllegalArgumentException("El indice debe ser numerico");
		}
		
		int indexCast = Integer.parseInt(index);
		
		if (indexCast <= 0 || indexCast > size) {
			throw new IllegalArgumentException("Indice fuera de rango");
		}
		
		return indexCast - 1;
	}
	
	public void validarNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		
		if (!nombre.matches("[a-zA-Z ]+")) {
			throw new IllegalArgumentException("El nombre debe contener unicamente letras");
		}
	}
	
	public int validarStock(String stock) {
		if (stock == null || stock.trim().isEmpty()) {
			throw new IllegalArgumentException("El stock no puede estar vacio");
		}
		
		if (!stock.matches("\\d+")) {
			throw new IllegalArgumentException("El precio debe ser numerico");
		}
		
		int stockCast = Integer.parseInt(stock);
		
		if (stockCast < 0) {
			throw new IllegalArgumentException("El stock no puede ser negativo");
		}
		
		return stockCast;
	}
	
	public double validarPrecio(String precio) {
		if (precio == null || precio.trim().isEmpty()) {
	        throw new IllegalArgumentException("El precio no puede estar vacío");
	    }

	    double precioCast;

	    try {
	        precioCast = Double.parseDouble(precio);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("El precio debe ser numérico");
	    }

	    if (precioCast < 0) {
	        throw new IllegalArgumentException("El precio no puede ser negativo");
	    }

	    return precioCast;
	}
	
	public void validarDescripcion(String descripcion) {
		if (!descripcion.matches("[a-zA-Z0-9]+")) {
			throw new IllegalArgumentException("La descripcion debe contener solo letras y numeros");
		}
	}
	
	public void validarProductoRegistrado(String nombre) {
		for (Productos prod : listaProductos) {
			if(prod.getNombreProducto().equalsIgnoreCase(nombre)) {
				throw new IllegalArgumentException("El producto ya ha sido registrado");
			}
		}
	}
	
	public void registrarProducto(String nombre, int stock, Proveedores proveedor, double precio, String descripcion) {
		validarNombre(nombre);
		validarProductoRegistrado(nombre);
		validarDescripcion(descripcion);
		
		listaProductos.add(new Productos(nombre, stock, proveedor, precio, descripcion));
		
	}
	
	public Productos buscarProducto(String nombre) {
		for (Productos prod : listaProductos) {
			if(prod.getNombreProducto().equalsIgnoreCase(nombre)) {
				return prod;
			}
		}
		throw new IllegalArgumentException("Producto no encontrado");
	}

	public List<Productos> getProductos(){
		return listaProductos;
	}
	
	public void actualizarPrecioProducto(int index, double precio) {
		listaProductos.get(index).setPrecioProducto(precio);
	}
	
	public void eliminarProducto(int index) {
		listaProductos.remove(index);
	}
	
	public void aumentarStock(int index, int cantidad) {
		int stock = listaProductos.get(index).getStockProducto();
		
		int newStock = stock + cantidad;
		
		listaProductos.get(index).setStockProducto(newStock);
	}
	
	public void disminuirStock(int index, int cantidad) {
		int stock = listaProductos.get(index).getStockProducto();
		
		int newStock = stock - cantidad;
		
		listaProductos.get(index).setStockProducto(newStock);
	}
	
}














