package com.luis.reservei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.reservei.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
