package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.FeedBack;
import com.app.entities.Product;


public interface AdminFeedbackRepository extends JpaRepository<FeedBack, Integer>{

	FeedBack save(FeedBack details);

	@Query(value = "select * from tbl_feed_back as fb join tbl_cust as cs on fb. cust_id = cs.id",nativeQuery = true)
	//select * from tbl_feed_back
	List<FeedBack> getAll();

}
