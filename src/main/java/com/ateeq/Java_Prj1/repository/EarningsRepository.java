package com.ateeq.Java_Prj1.repository;

import com.ateeq.Java_Prj1.model.Earnings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningsRepository extends JpaRepository<Earnings, Integer> {

}