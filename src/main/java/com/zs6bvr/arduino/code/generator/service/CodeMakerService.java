package com.zs6bvr.arduino.code.generator.service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;

public interface CodeMakerService {

	String doBuildProject(BuildProjectRequest request);

}
