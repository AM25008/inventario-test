package com.carlos.inventary;
import java.util.ArrayList;
import java.util.List;

public class InventarioBackend {
	private List<Productos> productos = new ArrayList<>();
	private List<Proveedores> proveedores = new ArrayList<>();
	
	public void validarNombre(String name) {
		if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El nombre no puede estar vacio");
        }
		else if(name.matches(".*\\d.*")){
            throw new IllegalArgumentException("Error: El nombre debe contener unicamente letras");
        }
	}
	
	public void validarStock(int stock) {
		if(stock < 0) {
			throw new IllegalArgumentException("Error: El stock inicial no puede ser negativo");
		}
		
		String stockk = Integer.toString(stock);
				
		if(stockk.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("Error: El stock deben ser unicamente numeros");
		}
		else if(stockk == null || stockk.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El stock no puede estar vacio");
        }
	}
	
	public void validarPrecio(double precio) {
		if(precio < 0) {
			throw new IllegalArgumentException("Error: El precio no puede ser negativo");
		}
		
		String price = Double.toString(precio);
		
		if(price.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("Error: El precio deben ser unicamente numeros");
		}
		else if(price == null || price.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El precio no puede estar vacio");
        }
	}
	
	public void validarDescripcion(String descripcion) {
		if(!descripcion.matches("[A-Za-z ]+")){
            throw new IllegalArgumentException("Error: Solo se permiten letras");
        }
	}
	
	public void validarIndex(int index, int size) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Error: indice no valido");
		}
		
		String indice = Integer.toString(index);
		
		if(indice == null || indice.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El indice no puede estar vacio");
        }
	}
	
	public Proveedores mapProveedor(int index) {
		Proveedores prove = proveedores.get(index);
		
		return prove;
	}
	
	public void registrarProducto(String nombre, int stock, Proveedores proveedor, double precio, String desc) {
		validarNombre(nombre);
		
		for(Productos pro: productos) {
			if(pro.getNombreProducto().contains(nombre)) {
				throw new IllegalArgumentException("Error: el producto ya ha sido registrado");
			}
		}
		
		validarStock(stock);
		validarPrecio(precio);
		validarDescripcion(desc);
		
		productos.add(new Productos(nombre, stock, proveedor, precio, desc));
	}
	
	public void validarEmail(String email) {
		if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
		else if(!email.matches("^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("Correo invalido");
        }
	}
	
	public void validarTelefono(String telefono) {
		if(telefono == null || telefono.trim().isBlank()){
            throw new IllegalArgumentException("La placa no puede estar vacia");
        }
		else if(!telefono.matches("\\d{4}-\\d{4}")){
            throw new IllegalArgumentException("Error: Formato de telefono valido: 1234-5678");
        }
	}
	
	public void registrarProveedor(String name, String email, String cellphone) {
		validarNombre(name);
		
		for(Proveedores prov: proveedores) {
			if(prov.getNombreProveedor().contains(name)) {
				throw new IllegalArgumentException("Error: el proveedor ya ha sido registrado");
			}
		}
		
		validarEmail(email);
		validarTelefono(cellphone);
		
		proveedores.add(new Proveedores(name, email, cellphone));
	}
	
	public List<Proveedores> getProveedores() {
		return proveedores;
	}
	
	public List<Productos> getProductos(){
		return productos;
	}
	
	
	
	public void datosDeEjemplo() {
		Proveedores p1 = new Proveedores("Logitech", "7834-2844", "logi.tech@gmail.com");
		Proveedores p2 = new Proveedores("Razer", "1030-1934", "ra.zer@gmail.com");
		
		proveedores.add(p1);
		proveedores.add(p2);
		
		Productos pro1 = new Productos("Mouse Inalambrico", 10, p1, 30.50, "null");
		Productos pro2 = new Productos("Teclado mecanico", 20, p2, 60.58, "null");
		
		productos.add(pro1);
		productos.add(pro2);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
