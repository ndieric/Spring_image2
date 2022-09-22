package com.example.image.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.image.Entity.Attachement;

@Repository
public interface AttechementRepository extends JpaRepository<Attachement,Long> {
    
}
