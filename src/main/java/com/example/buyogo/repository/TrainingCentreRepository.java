package com.example.buyogo.repository;

import com.example.buyogo.model.TrainingCentre;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCentreRepository extends JpaRepository<TrainingCentre, Long> {
    List<TrainingCentre> findAll(Specification<TrainingCentre> spec);
}
