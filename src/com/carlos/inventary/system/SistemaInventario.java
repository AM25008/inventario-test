package com.carlos.inventary.system;

import java.util.Scanner;

import com.carlos.inventary.logic.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaInventario {
	Scanner sc = new Scanner(System.in);
	
	private gestor_productos productosService = new gestor_productos();
	private gestor_proveedores proveedoresService = new gestor_proveedores();
	private gestor_movimientos movimientosService = new gestor_movimientos(productosService);
	
	public void run(){
		int opcion = 0;

		do{
			menuPrincipal();
			System.out.print("Elige una opcion: ");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
				case 1:
					menuProductos();
					continue;

				case 2:
					menuProveedores();
					continue;

				case 3:
					menuMovimientos();
					continue;

				case 0:
					System.out.println("\n-------------------------------------------");
					System.out.println("Saliendo del sistema...");
					System.out.println("-------------------------------------------");
					break;
			
				default:
					System.out.println("\n-------------------------------------------");
					System.out.println("Opcion no valida. Intenta nuevamente...");
					System.out.println("-------------------------------------------");
					
			}


		}while(opcion != 0);
	}

	public void menuPrincipal(){
		System.out.println("\n-- SISTEMA DE INVENTARIO --");
		System.out.println("""
			1. Gestion de productos
			2. Gestion de proveedores
			3. Movimientos de inventario
			0. Salir del sistema
			""");
	}
	
	public void menuProductos(){
		int opcion = 0;
		do{
			System.out.println("\n-- GESTION DE PRODUCTOS --");
			System.out.println("""
			1- Registrar producto
			2- Listar productos
			3- Eliminar productos
			4- Actualizar precio
			5- Ver stock
			0- Volver 
			""");

		System.out.print("Elige una opcion: ");
		opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
			case 1:
				registrarProducto();
				continue;

			case 2:
				showProducto();
				continue;

			case 3:
				eliminarProducto();
				continue;
			
			case 4:
				actualizarPrecioProducto();
				continue;

			case 5:
				verStockActual();
				continue;

			case 0:
				System.out.println("\n-------------------------------------------");
				System.out.println("Volviendo al menu principal...");
				System.out.println("-------------------------------------------");
				break;
		
			default:
				System.out.println("\n-------------------------------------------");
				System.out.println("Opcion no valida. Intenta nuevamente...");
				System.out.println("-------------------------------------------");
		}
		}while(opcion != 0);
	}

	public void menuProveedores(){
		int opcion = 0;
		do{
			System.out.println("\n-- GESTION DE PROVEEDORES --");
			System.out.println("""
			1- Registrar proveedor
			2- Listar proveedores
			3- Eliminar proveedor
			4- Actualizar informacion de un proveedor
			0- Volver 
			""");

		System.out.print("Elige una opcion: ");
		opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
			case 1:
				registrarProveedor();
				continue;

			case 2:
				showProvs();;
				continue;

			case 3:
				eliminarProveedor();
				continue;
			
			case 4:
				actualizarInfoProveedor();
				continue;

			case 0:
				System.out.println("\n-------------------------------------------");
				System.out.println("Volviendo al menu principal...");
				System.out.println("-------------------------------------------");
				break;
		
			default:
				System.out.println("\n-------------------------------------------");
				System.out.println("Opcion no valida. Intenta nuevamente...");
				System.out.println("-------------------------------------------");
		}
		}while(opcion != 0);
	}

	public void menuMovimientos(){
		int opcion = 0;
		do{
			System.out.println("\n-- GESTION DE MOVIMIENTOS --");
			System.out.println("""
			1- Registrar Entrada/Salida
			2- Ver historial de movimientos
			0- Volver 
			""");

		System.out.print("Elige una opcion: ");
		opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
			case 1:
				menuES();
				continue;

			case 2:
				mostrarHistorial();
				continue;

			case 0:
				System.out.println("\n-------------------------------------------");
				System.out.println("Volviendo al menu principal...");
				System.out.println("-------------------------------------------");
				break;
		
			default:
				System.out.println("\n-------------------------------------------");
				System.out.println("Opcion no valida. Intenta nuevamente...");
				System.out.println("-------------------------------------------");
		}
		}while(opcion != 0);
	}

	public void menuES(){
		int opcion = 0;
		do{
			System.out.println("\n-- REGISTRO DE ENTRADAS/SALIDAS --");
			System.out.println("""
			1- Registrar Entrada
			2- Registrar Salida
			0- Volver 
			""");

		System.out.print("Elige una opcion: ");
		opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
			case 1:
				registratEntrada();
				continue;

			case 2:
				registrarSalida();
				continue;

			case 0:
				System.out.println("\n-------------------------------------------");
				System.out.println("Volviendo al menu principal...");
				System.out.println("-------------------------------------------");
				break;
		
			default:
				System.out.println("\n-------------------------------------------");
				System.out.println("Opcion no valida. Intenta nuevamente...");
				System.out.println("-------------------------------------------");
		}
		}while(opcion != 0);
	}

	public void mostrarProveedores(){
		System.out.println("\n-- PROVEEDORES REGISTRADOS --");
		for(int i = 0; i < proveedoresService.getProveedores().size(); i++){
			System.out.println((i+1) + "- " + proveedoresService.getProveedores().get(i).getNombreProveedor());
		}
	}
	
	public void showProvs() {
		if(proveedoresService.getProveedores().isEmpty()) {
			System.out.println("\n----------------------------------");
			System.out.println("No hay proveedores registrados");
			System.out.println("----------------------------------\n");
		}else {
			mostrarProveedores();
		}
	}

	public void registrarProducto(){
		String nombre = "";
		int stock = 0;
		String indexProveedor = "";
		double precio = 0;
		String descripcion = "";
		boolean registrado = false;

		while (!registrado){
			System.out.print("\nIngresa el nombre del producto: ");
			nombre = sc.nextLine();

			try{
				productosService.validarNombre(nombre);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}

		registrado = false;

		while(!registrado){
			System.out.print("\nIngresa el stock inicial del producto: ");

			try{
				stock = productosService.validarStock(sc.nextLine());
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}

		registrado = false;
		int index = 0;
		
		while(!registrado){
			if (proveedoresService.getProveedores().isEmpty()){
				System.out.println("\n----------------------------------");
				System.out.println("No hay proveedores registrados. Debe registrar a uno primero");
				System.out.println("----------------------------------\n");
				return;
			}
			else{
				mostrarProveedores();
				System.out.print("\nIngresa el indice del proveedor: ");
				indexProveedor = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProveedor, proveedoresService.getProveedores().size());
					registrado = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}

		registrado = false;

		while(!registrado){
			System.out.print("\nIngresa el precio del producto: ");

			try{
				precio = productosService.validarPrecio(sc.nextLine());
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}

		registrado = false;

		while(!registrado){
			System.out.print("\nIngresa una descripcion del producto (opcional): ");
			descripcion = sc.nextLine();

			try{
				productosService.validarDescripcion(descripcion);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}

		productosService.registrarProducto(nombre, stock, proveedoresService.getProveedores().get(index), precio, descripcion);
		
		System.out.println("\n-- PRODUCTO REGISTRADO CON EXITO --");
	}

	public void mostrarProductos(){
		System.out.println("\n-- PRODUCTOS REGISTRADOS --");
		for(int i = 0; i < productosService.getProductos().size(); i++){
			System.out.println((i+1) + "- " + productosService.getProductos().get(i).getNombreProducto());
		}
	}
	
	public void showProducto() {
		if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
			return;
		}else {
			mostrarProductos();
		}
	}
		
	public void eliminarProducto(){
		boolean regis = false;
		int index = 0;

		while(!regis){
			if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				mostrarProductos();
				System.out.print("\nIngresa el indice del producto a eliminar: ");
				String indexProd = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProd, productosService.getProductos().size());
					regis = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		productosService.eliminarProducto(index);
	}
	
	public void actualizarPrecioProducto() {
		boolean regis = false;
		String indexProd = "";
		int index = 0;
		
		while(!regis) {
			if(productosService.getProductos().isEmpty()){
				System.out.println("\n----------------------------------");
				System.out.println("No hay productos registrados aun");
				System.out.println("----------------------------------");
				
				return;
			}
			else {
				mostrarProductos();
				System.out.print("\nIngresa el indice del producto: ");
				indexProd = sc.nextLine();
				
				try {
					index = productosService.validarIndex(indexProd, productosService.getProductos().size());
					regis = true;
					
				}catch(IllegalArgumentException e) {
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		regis = false;
		double precio = 0;
		
		while(!regis) {
			System.out.print("\nIngresa el precio del producto: ");

			try{
				precio = productosService.validarPrecio(sc.nextLine());
				regis = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		productosService.actualizarPrecioProducto(index, precio);
	}
	
	public void verStockActual() {
		if(productosService.getProductos().isEmpty()) {
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados");
			System.out.println("----------------------------------\n");
		}else {
			System.out.println("\n-- STOCK ACTUAL --\n");
			for(int i = 0; i < productosService.getProductos().size(); i++) {
				System.out.println("\n--- Producto [" + (i+1) + "] ---");
				System.out.println("Nombre del producto: " + productosService.getProductos().get(i).getNombreProducto());
				System.out.println("Stock: " + productosService.getProductos().get(i).getStockProducto());
				System.out.println("Proveedor: " + productosService.getProductos().get(i).getProveedor());
				System.out.println("Precio: " + productosService.getProductos().get(i).getPrecioProducto());
				System.out.println("Descripcion: " + productosService.getProductos().get(i).getDescripcion());
				System.out.println("------------------------------------------------------------");
			}
		}
	}
	
	public void registrarProveedor() {
		String nombre = "";
		String telefono = "";
		String email = "";
		boolean registrado = false;

		while (!registrado){
			System.out.print("\nIngresa el nombre del proveedor: ");
			nombre = sc.nextLine();

			try{
				proveedoresService.validarNombreProv(nombre);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		registrado = false;
		
		while (!registrado){
			System.out.print("\nIngresa el telefono del proveedor: ");
			telefono = sc.nextLine();

			try{
				proveedoresService.validarTelefono(telefono);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		registrado = false;
		
		while (!registrado){
			System.out.print("\nIngresa el email del proveedor: ");
			email = sc.nextLine();

			try{
				proveedoresService.validarEmail(email);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		proveedoresService.registrarProveedor(nombre, telefono, email);
		System.out.println("\n-- PROVEEDOR REGISTRADO CON EXITO --");
	}
	
	public void eliminarProveedor() {
		boolean regis = false;
		int index = 0;

		while(!regis){
			if(proveedoresService.getProveedores().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay proveedores registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				mostrarProveedores();
				System.out.print("\nIngresa el indice del proveedor a eliminar: ");
				String indexProv = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProv, proveedoresService.getProveedores().size());
					regis = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		proveedoresService.eliminarProveedor(index);
	}
	
	public void actualizarInfoProveedor() {
		boolean regis = false;
		int index = 0;

		while(!regis){
			if(proveedoresService.getProveedores().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay proveedores registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				mostrarProveedores();
				System.out.print("\nIngresa el indice del proveedor a editar: ");
				String indexProv = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProv, proveedoresService.getProveedores().size());
					regis = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		int indice = 0;
		
		do {
			menuEditarInfoProveedor();
			System.out.print("\nElige una opcion: ");
			indice = Integer.parseInt(sc.nextLine());
			
			switch (indice){
				case 1:
					setNombreProv(index);
					break;
					
				case 2:
					setTelefonoProv(index);
					break;
					
				case 3:
					setEmailProv(index);
					break;
					
				case 0:
					System.out.println("\n-------------------------------------------");
					System.out.println("Volviendo al menu de proveedores...");
					System.out.println("-------------------------------------------");
					break;
			}
		}while(indice != 0 || (indice < 1 && indice > 3));
		
	}
	
	public void menuEditarInfoProveedor() {
		System.out.println("""
				1- Editar nombre
				2- Editar Telefono
				3- Editar email
				0- Salir
				""");
	}
	
	public void setNombreProv(int index) {
		String nombre = "";
		boolean registrado = false;

		while (!registrado){
			System.out.print("\nIngresa el nombre del proveedor: ");
			nombre = sc.nextLine();

			try{
				proveedoresService.validarNombreProv(nombre);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		proveedoresService.getProveedores().get(index).setNombreProveedor(nombre);
		
		System.out.println("\n-- NOMBRE DEL PROVEEDOR CAMBIADO CON EXITO --");
	}
	
	public void setTelefonoProv(int index) {
		String telefono = "";
		boolean registrado = false;
		
		while (!registrado){
			System.out.print("\nIngresa el telefono del proveedor: ");
			telefono = sc.nextLine();

			try{
				proveedoresService.validarTelefono(telefono);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		proveedoresService.getProveedores().get(index).setTelefonoProveedor(telefono);
	}
	
	public void setEmailProv(int index) {
		String email = "";
		boolean registrado = false;
		
		while (!registrado){
			System.out.print("\nIngresa el email del proveedor: ");
			email = sc.nextLine();

			try{
				proveedoresService.validarEmail(email);
				registrado = true;
			}catch(IllegalArgumentException e){
				System.out.println("\n----------------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta nuevamente...");
                System.out.println("----------------------------------\n");
			}
		}
		
		proveedoresService.getProveedores().get(index).setEmailProveedor(email);
	}
	
	public void registratEntrada() {
		boolean estado = false;
		int index = 0;

		while(!estado){
			if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				mostrarProductos();
				System.out.print("\nIngresa el indice del producto: ");
				String indexProd = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProd, productosService.getProductos().size());
					estado = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		estado = false;
		int cantidad = 0;
		
		while(!estado) {
			System.out.print("\nIngresa la cantidad que deseas añadir: ");
			String cant = sc.nextLine();
			
			try {
				cantidad = movimientosService.validarEntrada(cant);
				estado = true;
			}catch(IllegalArgumentException e) {
				System.out.println("\n----------------------------------");
            	System.out.println("Error: " + e.getMessage());
            	System.out.println("Intenta nuevamente...");
            	System.out.println("----------------------------------\n");
			}
		}
		
		String nombre = productosService.getProductos().get(index).getNombreProducto();
		String tipoMovimiento = "Entrada";
		
		productosService.aumentarStock(index, cantidad);;
		
		LocalDateTime now = LocalDateTime.now();
		String fecha = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String hora = now.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		movimientosService.registrarEntrada(nombre, tipoMovimiento, cantidad, fecha, hora);
	}
	
	public void registrarSalida() {
		boolean estado = false;
		int index = 0;

		while(!estado){
			if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				mostrarProductos();
				System.out.print("\nIngresa el indice del producto: ");
				String indexProd = sc.nextLine();

				try{
					index = productosService.validarIndex(indexProd, productosService.getProductos().size());
					estado = true;
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
				}
			}
		}
		
		estado = false;
		int cantidad = 0;
		
		while(!estado) {
			System.out.print("\nIngresa la cantidad que deseas restar: ");
			String cant = sc.nextLine();
			
			try {
				cantidad = movimientosService.validarSalida(cant, productosService.getProductos().get(index).getStockProducto());
				estado = true;
			}catch(IllegalArgumentException e) {
				System.out.println("\n----------------------------------");
            	System.out.println("Error: " + e.getMessage());
            	System.out.println("Intenta nuevamente...");
            	System.out.println("----------------------------------\n");
			}
		}
		
		String nombre = productosService.getProductos().get(index).getNombreProducto();
		String tipoMovimiento = "Salida";
		
		productosService.disminuirStock(index, cantidad);
		
		LocalDateTime now = LocalDateTime.now();
		String fecha = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String hora = now.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		movimientosService.registrarSalida(nombre, tipoMovimiento, cantidad, fecha, hora);
	}
	
	public void mostrarHistorial() {
		if(movimientosService.getMovimientos().isEmpty()) {
			System.out.println("\n----------------------------------");
			System.out.println("No hay movimientos registrados aun");
			System.out.println("----------------------------------");
			return;
		}else {
			System.out.println("\n-- MOVIMIENTOS REGISTRADOS --");
			for(int i = 0; i < movimientosService.getMovimientos().size(); i++) {
				System.out.println("-- MOVIMIENTO " + (i+1) + " --");
				System.out.println("Producto: " + movimientosService.getMovimientos().get(i).getNombreProduco());
				System.out.println("Tipo de movimiento: " + movimientosService.getMovimientos().get(i).getTipoMovimiento());
				System.out.println("Cantidad: " + movimientosService.getMovimientos().get(i).getCantidad());
				System.out.println("Fecha: " + movimientosService.getMovimientos().get(i).getFecha());
				System.out.println("Hora: " + movimientosService.getMovimientos().get(i).getHora());
				System.out.println("------------------------------------------------------------------------\n");
			}
		}
	}
	
}
