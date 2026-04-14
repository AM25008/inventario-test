package com.carlos.inventary.system;

import java.util.Scanner;

import com.carlos.inventary.logic.*;

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
				mostrarProductos();
				continue;

			case 3:
				//
				continue;
			
			case 4:
				//
				continue;

			case 5:
				//
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
				// 
				continue;

			case 2:
				//
				continue;

			case 3:
				//
				continue;
			
			case 4:
				//
				continue;

			case 5:
				//
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
				//
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
				//
				continue;

			case 2:
				//
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
			System.out.print("Ingresa el precio del producto: ");

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
			System.out.print("Ingresa una descripcion del producto (opcional): ");
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
	}

	public void mostrarProductos(){
		if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
		}
		else{
			System.out.println("\n-- PRODUCTOS REGISTRADOS --");
			for(int i = 0; i < productosService.getProductos().size(); i++){
				System.out.println((i+1) + "- " + productosService.getProductos().get(i).getNombreProducto());
			}
		}
	}

	public void eliminarProducto(){
		boolean reg = false;

		while(!reg){
			if(productosService.getProductos().isEmpty()){
			System.out.println("\n----------------------------------");
			System.out.println("No hay productos registrados aun");
			System.out.println("----------------------------------");
			return;

			}
			else{
				System.out.println("\n-- PRODUCTOS REGISTRADOS --");
				for(int i = 0; i < productosService.getProductos().size(); i++){
					System.out.println((i+1) + "- " + productosService.getProductos().get(i).getNombreProducto());
				}
				System.out.print("Ingresa el indice del producto a eliminar: ");
				String indexProd = sc.nextLine();

				try{
					productosService.validarIndex(indexProd, productosService.getProductos().size());
				}catch(IllegalArgumentException e){
					System.out.println("\n----------------------------------");
                	System.out.println("Error: " + e.getMessage());
                	System.out.println("Intenta nuevamente...");
                	System.out.println("----------------------------------\n");
			}
		}
		}
	}


	
	
}
