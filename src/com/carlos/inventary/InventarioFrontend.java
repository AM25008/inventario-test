package com.carlos.inventary;
import java.util.Scanner;

public class InventarioFrontend {
	Scanner sc = new Scanner(System.in);
	private InventarioBackend back = new InventarioBackend();
	
	public InventarioFrontend() {
		back.datosDeEjemplo();
	}
	
	public void run() {
		int opcion = 0;
		
		do{
            mostrarMenu();

            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){
                case 1:
                    registrarProducto();
                    break;

                case 2:
                    registrarProveedor();
                    break;

                case 3:
                    mostrarStock();
                    break;

                case 4:
                    ;
                    break;

                case 5:
                    ;
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpcion no valida");
                    System.out.println("\nIntenta nuevamente...");
                    continue;
            }
            
        }while(opcion != 0);
	}
	
	public void mostrarMenu() {
		System.out.println("""
				-- SISTEMA DE INVENTARIO --
				1. Registrar producto
				2. Registrar proveedor
				3. Mostrar stock actual
				4. Aumentar stock
				5. Restar stock
				0. Salir del sistema
				""");
	}
	
	public String mostrarProveedores() {
		String message = "";
		
		System.out.println("-- PROVEEDORES REGISTRADOS --");
		if(back.getProveedores().isEmpty()) {
			message += "Sin proveedores registrados";
		}
		for(int i = 0; i < back.getProveedores().size(); i++) {
			message += (i+1) + ". " + back.getProveedores().get(i) + "\n";
		}
		
		return message.toString();
	}
	
	public void registrarProducto() {
		String name = "";
		int stock = 0;
		double precio = 0;
		int proveIndex = 0;
		boolean nameOk = false;
		boolean stockOk = false;
		boolean precioOk = false;
		boolean proveOk= false;
		
		while(!nameOk) {
			System.out.println("Ingresa el nombre del producto: ");
			name = sc.nextLine();
			
			try {
				back.validarNombre(name);
				nameOk = true;
			}catch(IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		while(!stockOk) {
			System.out.println("Ingresa el stock inicial del producto: ");
			stock = Integer.parseInt(sc.nextLine());
			
			try {
				back.validarStock(stock);
				stockOk = true;
			}catch (IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		while(!proveOk) {
			System.out.println(mostrarProveedores()); 
			System.out.println("Ingresa el indice del proveedor del producto: ");
			proveIndex = Integer.parseInt(sc.nextLine()) - 1;
			
			try {
				back.validarIndex(proveIndex, back.getProveedores().size());
				proveOk = true;
			}catch (IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		while(!precioOk) {
			System.out.println("Ingresa el precio del producto: ");
			precio = Double.parseDouble(sc.nextLine());
			
			try {
				back.validarPrecio(precio);
				precioOk = true;
			}catch (IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		System.out.println("Ingresa una descripcion del producto (opcional)");
		String descripcion = sc.nextLine();
		
		back.registrarProducto(name, stock, back.getProveedores().get(proveIndex), precio, descripcion);
	}
	
	public void registrarProveedor() {
		String name = "";
		String email = "";
		String cel = "";
		boolean nameOk = false;
		boolean emailOk = false;
		boolean celOk = false;
		
		while(!nameOk) {
			System.out.println("Ingresa el nombre del proveedor: ");
			name = sc.nextLine();
			
			try {
				back.validarNombre(name);
				nameOk = true;
			}catch(IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		while(!emailOk) {
			System.out.println("Ingresa el email del proveedor: ");
			email = sc.nextLine();
			
			try {
				back.validarEmail(email);
				emailOk = true;
			}catch(IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		while(!celOk) {
			System.out.println("Ingresa el telefono del proveedor: ");
			cel = sc.nextLine();
			
			try {
				back.validarTelefono(cel);
				celOk = true;
			}catch(IllegalArgumentException e) {
				System.out.println("----------------------------");
                System.out.println("\nError: " + e.getMessage());
                System.out.println("\nIntenta nuevamente...");
                System.out.println("----------------------------");
			}
		}
		
		back.registrarProveedor(name, email, cel);
	}
	
	public void mostrarStock() {
		if(back.getProductos().isEmpty()) {
			System.out.println("");
			System.out.println("No hay productos registrados");
			System.out.println("");
		}else {
			System.out.println("-- STOCK ACTUAL --");
			for(int i = 0; i < back.getProductos().size(); i++) {
				System.out.println("Nombre del producto: " + back.getProductos().get(i).getNombreProducto());
				System.out.println("Stock actual del producto: " + back.getProductos().get(i).getStockProducto());
				System.out.println("Precio del producto: "+ back.getProductos().get(i).getPrecioProducto());
				System.out.println("Proveedor del producto: " + back.getProductos().get(i).getProveedor());
				System.out.println("Descripcion del producto: " + back.getProductos().get(i).getDescripcion());
				System.out.println("------------------------------------------------------------------");
				System.out.println("");
			}
		}
	}
	
	// faltan metodos para aumentar y restar el stock y optimizar codigo:v
	
	
	
}
