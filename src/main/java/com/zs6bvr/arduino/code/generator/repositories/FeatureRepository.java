package com.zs6bvr.arduino.code.generator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;

public interface FeatureRepository extends JpaRepository<ProjectFeature, Long> {

	public ProjectFeature findByProjectFeatureId(Long projectFeatureId);
	
	public ProjectFeature findByProjectGUID(String projectGUID);

	public List<ProjectFeature> findByCategory(String category);

	@Query(nativeQuery=true,value="SELECT DISTINCT  category from feature  GROUP BY(category) ORDER BY(category)" )
	public List<String> getAllCategories();

	 
}
