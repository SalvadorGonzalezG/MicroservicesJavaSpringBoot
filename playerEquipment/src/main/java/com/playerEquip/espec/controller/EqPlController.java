package com.playerEquip.espec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.playerEquip.espec.models.Equipment;
import com.playerEquip.espec.models.Player;

@Controller
public class EqPlController {
	@GetMapping("/parameters/{nombre}/{numero}")
	public String PathVariabl(@PathVariable String nombre, @PathVariable("numero") int numero, Model model) {
		Optional<Equipment> optionalEquipment = getEquipment().stream().filter(equipment -> nombre.toLowerCase().equals(equipment.getNombre().toLowerCase())).findFirst();
			if(optionalEquipment.isPresent()) {
				Optional<Player> playerOptional = optionalEquipment.get().getPlantilla().stream().filter(player -> numero == player.getNumero()).findFirst();
				model.addAttribute("player", playerOptional.get());
			}
		return "viewPlayersAndEquipments";
	}

	public List<Equipment> getEquipment(){
		Equipment Sidney = new Equipment();
		Sidney.setNombre("Sidney");
		Sidney.addPlayer(new Player("Alexandar Popovic", 41));
		Sidney.addPlayer(new Player("Andrew Redmayne", 1));
		Sidney.addPlayer(new Player("Harrison Devenish-Meares", 12));
		Sidney.addPlayer(new Player("Léo Sena", 15));
		Sidney.addPlayer(new Player("Corey Hollman", 6));
		
		Equipment Mexico = new Equipment();
		Mexico.setNombre("Mexico");
		Mexico.addPlayer(new Player("ArturoGonzález", 23));
		Mexico.addPlayer(new Player("Roberto Alvarado", 21));
		Mexico.addPlayer(new Player("Érick Sánchez ", 20));
		Mexico.addPlayer(new Player("Luis Romo", 19));
		Mexico.addPlayer(new Player("Carlos Acevedo", 27));
		
		return List.of(Sidney, Mexico);
	}
}
