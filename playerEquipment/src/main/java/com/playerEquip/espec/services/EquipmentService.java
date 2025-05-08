package com.playerEquip.espec.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.playerEquip.espec.models.Equipment;
import com.playerEquip.espec.models.Player;

@Service
public class EquipmentService implements IService{

	//Metodo para obtener los players de un equipment
	public List<Equipment> getEquipment(){
		Equipment Sidney = new Equipment();
		Sidney.setNombre("Sidney");
		Sidney.addPlayer(new Player("Alexandar Popovic", 41));
		Sidney.addPlayer(new Player("Andrew Redmayne", 1));
		Sidney.addPlayer(new Player("Harrison Devenish-Meares", 12));
		Sidney.addPlayer(new Player("Léo Sena", 15));
		Sidney.addPlayer(new Player("Corey Hollman", 6));
		Sidney.addPlayer(new Player("Andrew Redmayne", 13));
		

		
		Equipment Mexico = new Equipment();
		Mexico.setNombre("Mexico");
		Mexico.addPlayer(new Player("Julián Andrés Quiñones", 33));
		Mexico.addPlayer(new Player("ArturoGonzález", 23));
		Mexico.addPlayer(new Player("Roberto Alvarado", 21));
		Mexico.addPlayer(new Player("Érick Sánchez ", 20));
		Mexico.addPlayer(new Player("Luis Romo", 19));
		Mexico.addPlayer(new Player("Carlos Acevedo", 27));
		
		return List.of(Sidney, Mexico);
	}
	
}
