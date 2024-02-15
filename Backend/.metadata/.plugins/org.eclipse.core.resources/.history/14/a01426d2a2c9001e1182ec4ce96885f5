package com.app.service;

import java.util.List;

import com.app.entities.Breed;
import com.app.entities.Provider;



public interface IBreedService {

	
    List<Breed> fetchAllBreeds();
	
    //add a method to delete Breed details
	String deleteBreedDetails(int BreedId);
	//add method to fetch Breed details
	Breed getBreedDetails(int BreedId);
	//update Breed
	Breed updateBreedDetails(Breed detachedBreed);

	Breed saveBreedDetails(Breed transientBreed);
	
	public Breed getBreedByBreed(String breed);
}
