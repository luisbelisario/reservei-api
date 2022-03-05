package com.luis.reservei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.reservei.models.Court;

public interface CourtRepository extends JpaRepository<Court, Integer> {

}
