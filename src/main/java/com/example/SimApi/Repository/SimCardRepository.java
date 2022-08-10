package com.example.SimApi.Repository;

import com.example.SimApi.Model.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimCardRepository extends JpaRepository<SimCard, Long> {
}