package com.hospital.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.data.model.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
