package com.carlos.inventary.system;

import java.util.Scanner;

import com.carlos.inventary.logic.*;

public class InventarioFrontend {
	Scanner sc = new Scanner(System.in);
	
	private gestor_productos productosService = new gestor_productos();
	private gestor_proveedores proveedoresService = new gestor_proveedores();
	private gestor_movimientos movimientosService = new gestor_movimientos(productosService);
	
	/////
	
	
}
