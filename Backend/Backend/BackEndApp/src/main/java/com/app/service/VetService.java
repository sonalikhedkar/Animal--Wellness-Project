package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Vet;
import com.app.repositories.VetRepository;



@Service
@Transactional
public class VetService implements IVetService {

	
	@Autowired
	private VetRepository vetRepo;
	
	
	@Override
	public List<Vet> fetchAllVets() {
		return vetRepo.findAll();
		
	}

	@Override
	public String deleteVetDetails(int VetId) {
		vetRepo.deleteById(VetId);
		return "vet record deleted ";
	}

	@Override
	public Vet getVetDetails(int VetId) {	
		return vetRepo.getById(VetId);
	}

	@Override
	public Vet updateVetDetails(Vet detachedVet) {
		return vetRepo.save(detachedVet);
	}

	@Override
	public Vet saveVetDetails(Vet transientVet) {
		return vetRepo.save(transientVet);
	}

}
