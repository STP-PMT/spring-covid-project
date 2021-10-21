package net.csmsu.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{

}
