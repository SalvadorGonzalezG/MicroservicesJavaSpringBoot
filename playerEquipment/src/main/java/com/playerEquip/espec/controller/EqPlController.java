package com.playerEquip.espec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.playerEquip.espec.models.Equipment;
import com.playerEquip.espec.models.Player;
import com.playerEquip.espec.services.IService;

@Controller
public class EqPlController {
	
	@Autowired
	//EquipmentService equipmentService;
	
	//Iyeccion de dependecia atravez de una Interfaz
	IService equipmentService;
	
	@GetMapping("/parameters/{nombre}/{numero}")
	public String PathVariabl(@PathVariable String nombre, @PathVariable("numero") int numero, Model model) {
		
		//Instancia del objeto equipmentService
		//EquipmentService equipmentService = new EquipmentService();
		
		Optional<Equipment> optionalEquipment = equipmentService.getEquipment().stream().filter(equipment -> nombre.toLowerCase().equals(equipment.getNombre().toLowerCase())).findFirst();
			if(optionalEquipment.isPresent()) {
				Optional<Player> playerOptional = optionalEquipment.get().getPlantilla().stream().filter(player -> numero == player.getNumero()).findFirst();
				
				if(playerOptional.isPresent()) {
				model.addAttribute("player", playerOptional.get());
				}else {
					model.addAttribute("player", null);
				}
			}else {
				model.addAttribute("player", null);
			}
		return "viewPlayersAndEquipments";
	}
	
	@GetMapping({"/parameters/{nombre}", "//parameters/{nombre}/"}) 
    public String onlyNombre(@PathVariable String nombre, Model model) {
        model.addAttribute("player", null); // no hay jugador específico
        return "viewPlayersAndEquipments";
    }

}
