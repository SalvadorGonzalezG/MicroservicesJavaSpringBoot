package com.playerEquip.espec.services;

import java.util.List;

import com.playerEquip.espec.models.Equipment;

public interface IService {
	
	// Metodo de intarface para poder implementar en el service
	public List<Equipment> getEquipment();
}
