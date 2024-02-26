package com.app.service;

import java.util.List;

import com.app.entities.Trainer;

public interface ITrainerService {

	List<Trainer> fetchAllTrainers();

	String saveTrainerDetails(Trainer trainer);

}
