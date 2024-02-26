package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer,Integer>{

}
