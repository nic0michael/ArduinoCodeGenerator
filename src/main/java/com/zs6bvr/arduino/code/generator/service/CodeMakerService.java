package com.zs6bvr.arduino.code.generator.service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;

public interface CodeMakerService {

	BuildProjectResponse doBuildProject(BuildProjectResponse response);

}
