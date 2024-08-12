package com.example.pruebaLinkTic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaLinkTic.entity.Reservation;
import com.example.pruebaLinkTic.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;	
	}
	
	public List<Reservation> getReservations(){
		return reservationRepository.findAll();
	}
	
	public Optional<Reservation> getReservation(Long id){
		return reservationRepository.findById(id);
	}
	
	public void saveOrUpdate (Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void delete(Long id) {
		reservationRepository.deleteById(id);
	}
	
	public List<Reservation> getCustomerId(Long customerId){
		return reservationRepository.consultCustomerId(customerId);
	}
	
	public List<Reservation> getService(String service){
		return reservationRepository.consultService(service);
	} 
	
}
