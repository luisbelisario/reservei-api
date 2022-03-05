package com.luis.reservei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.reservei.models.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
