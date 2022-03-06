package com.luis.reservei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.reservei.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
