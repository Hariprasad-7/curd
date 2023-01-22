package com.example.demo.repository;

import com.example.demo.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer> {
  //  Optional<Object> findByname(String name);
}
