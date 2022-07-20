package com.luis.reservei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.reservei.models.Court;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {

}
