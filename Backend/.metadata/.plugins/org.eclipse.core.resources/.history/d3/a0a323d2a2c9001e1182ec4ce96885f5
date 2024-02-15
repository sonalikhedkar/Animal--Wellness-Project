package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Breed;
import com.app.repositories.BreedRepository;


@Service
@Transactional
public class BreedService implements IBreedService {
	
	
	@Autowired
	private BreedRepository breedRepo;

	@Override
	public List<Breed> fetchAllBreeds() {
		// TODO Auto-generated method stub
		return breedRepo.findAll();
	}

	@Override
	public String deleteBreedDetails(int BreedId) {
		 breedRepo.deleteById(BreedId);
		return "Breed deleted sucessfully ";
	}

	@Override
	public Breed getBreedDetails(int BreedId) {
		return breedRepo.getById(BreedId);
	}
	
	@Override
	public Breed getBreedByBreed(String breed) {
		return breedRepo.getByBreed(breed);
	}

	@Override
	public Breed updateBreedDetails(Breed detachedBreed) {
		
		return breedRepo.save(detachedBreed);
	}

	@Override
	public Breed saveBreedDetails(Breed transientBreed) {
		return breedRepo.save(transientBreed);
	}
	
	

}
