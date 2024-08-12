package com.example.pruebaLinkTic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pruebaLinkTic.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long>{
	
	@Query(value = "select * from tbl_reservation "
			+ "where customerid = :customerid " , nativeQuery = true)
	List<Reservation> consultCustomerId(@Param("customerid") Long customerid);
		
	@Query(value = "select * from tbl_reservation "
			+ "where service = :service " , nativeQuery = true)
	List<Reservation> consultService(@Param("service") String service);
}
