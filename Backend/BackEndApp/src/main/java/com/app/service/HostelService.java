package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Hostel;
import com.app.repositories.HostelRepository;


@Service
@Transactional
public class HostelService implements IHostelService {

	
	@Autowired
	private HostelRepository hostelRepo;
	
	@Override
	public List<Hostel> fetchAllHostels() {
		// TODO Auto-generated method stub
		return hostelRepo.findAll();
	}

	@Override
	public String deleteHostelDetails(int HostelId) {
		hostelRepo.deleteById(HostelId);
		return "hostel record deleted ";
	}

	@Override
	public Hostel getHostelDetails(int HostelId) {
		return hostelRepo.getById(HostelId);
	}

	@Override
	public Hostel updateHostelDetails(Hostel detachedHostel) {
	
		return hostelRepo.save(detachedHostel);
	}

	@Override
	public Hostel saveHostelDetails(Hostel transientHostel) {

		return hostelRepo.save(transientHostel);
	}

}
