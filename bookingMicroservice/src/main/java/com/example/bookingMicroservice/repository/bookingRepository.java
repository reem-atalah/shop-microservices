package com.example.bookingMicroservice.repository;

import com.example.bookingMicroservice.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingRepository extends JpaRepository<order, Long> {
}
