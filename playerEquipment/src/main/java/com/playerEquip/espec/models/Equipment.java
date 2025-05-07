package com.playerEquip.espec.models;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
	//Atributes
	private String nombre;
	private List<Player> plantilla;
	
	//COnstructor que inicializara la plantilla
	public Equipment() {
		plantilla = new ArrayList();
	}
	
	//getters & Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Player> getPlantilla(){
		return plantilla;
	}
	public void setPlantilla(List<Player> plantilla) {
		this.plantilla = plantilla;
	}
	
	//metodo para agregar un jugador a la plantilla
	public void addPlayer(Player player) {
		plantilla.add(player);
	}
	
}
