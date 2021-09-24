package com.zs6bvr.arduino.code.generator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;

public interface FeatureRepository extends JpaRepository<ProjectFeature, Long> {

	public ProjectFeature findByProjectFeatureId(Long projectFeatureId);
	
	public ProjectFeature findByProjectGUID(String projectGUID);

	
}
