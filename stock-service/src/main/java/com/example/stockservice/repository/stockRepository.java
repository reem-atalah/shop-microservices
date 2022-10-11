package com.example.stockservice.repository;

import com.example.stockservice.entity.stockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface stockRepository extends JpaRepository<stockEntity, Long> {

    Optional<stockEntity> findByCode(String code);
}
