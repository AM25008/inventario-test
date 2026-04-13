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

	
}
