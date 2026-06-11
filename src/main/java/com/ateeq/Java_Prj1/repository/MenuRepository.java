package com.ateeq.Java_Prj1.repository;

import com.ateeq.Java_Prj1.model.Menu;
import com.ateeq.Java_Prj1.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}