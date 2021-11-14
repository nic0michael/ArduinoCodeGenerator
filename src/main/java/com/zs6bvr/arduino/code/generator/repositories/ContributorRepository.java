package com.zs6bvr.arduino.code.generator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zs6bvr.arduino.code.generator.entities.Contributor;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {

}
