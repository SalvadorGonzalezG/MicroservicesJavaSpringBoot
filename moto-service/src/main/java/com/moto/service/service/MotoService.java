package com.moto.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoService {
	
	// realizamos la inyeccion del repositorio
	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll(){
		return motoRepository.findAll();
	}
	
	// Meotod para obtener una moto por Id
	public Moto getMotoById(int id) {
		return motoRepository.findById(id).orElse(null);
	}
	
	// metodo para guardar una moto
	public Moto save(Moto moto) {
		Moto newMoto = motoRepository.save(moto);
		return newMoto;
	}
	
	// Metodo para obtener todas las motos de un usuario
	public List<Moto> findByUserId(int userId){
		return motoRepository.findByUserId(userId);
	}

}
