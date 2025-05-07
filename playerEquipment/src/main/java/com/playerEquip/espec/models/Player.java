package com.playerEquip.espec.models;

public class Player {
	
	private String nombre;
	private int numero;
	
	//Constructor de la clase
	public Player(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
	}
	
	//Getters & Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumber(int numero) {
		this.numero = numero;
	}
	
	

}
