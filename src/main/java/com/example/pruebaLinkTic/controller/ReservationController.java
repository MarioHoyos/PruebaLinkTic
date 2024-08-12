package com.example.pruebaLinkTic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaLinkTic.entity.Reservation;
import com.example.pruebaLinkTic.service.ReservationService;

/**
 * Documentación: http://localhost:8080/swagger-ui/index.html
 * 
 * */

@RestController
@RequestMapping(path = "api/v1/reservations")
public class ReservationController {
	
	@Autowired
	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public List<Reservation> getAll(){
		return reservationService.getReservations();
	}
	
	@GetMapping("/{reservationId}")
	public Optional<Reservation> getById(@PathVariable("reservationId") Long reservationId){
		return reservationService.getReservation(reservationId);
	}
	
	@PostMapping
	public void saveOrUpdate(@RequestBody Reservation reservation) {
		reservationService.saveOrUpdate(reservation);
	} 
	
	@DeleteMapping("/{reservationId}")
	public void delete(@PathVariable("reservationId") Long reservationId) {
		reservationService.delete(reservationId);	
	}
	
	@GetMapping("/customerid/{customerId}")
	public List<Reservation> getByCustomerId(@PathVariable("customerId") Long customerId){
		return reservationService.getCustomerId(customerId);
	}
	
	@GetMapping("/service/{service}")
	public List<Reservation> getByService(@PathVariable("service") String service){
		return reservationService.getService(service);
	}
	
}
