package com.example.pruebaLinkTic.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReservationID")
	private Long reservationId;
	
	@Column(name = "Service", nullable = false)
	private String service;
	
	@Column(name = "CustomerID", nullable = false)
	private int customerId;

	@Column(name = "RoomID", nullable = false)
	private int roomId;
	
	@Column(name = "NumberOfGuests", nullable = false)
	private int numberOfGuests;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "ReservationDate", nullable = false)
	private Date reservationDate;
	 
	@Column(name = "TotalPrice", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalPrice; 
}
