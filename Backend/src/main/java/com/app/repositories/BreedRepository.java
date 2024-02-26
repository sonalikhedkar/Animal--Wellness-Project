package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Breed;


public interface BreedRepository extends JpaRepository<Breed, Integer>{

	Breed getByBreed(String breed);
	
}
