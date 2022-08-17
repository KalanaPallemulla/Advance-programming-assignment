package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    
}
