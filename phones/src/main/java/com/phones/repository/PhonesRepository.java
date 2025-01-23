package com.phones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phones.entity.Phones;

public interface PhonesRepository extends JpaRepository<Phones, Integer>{

}
