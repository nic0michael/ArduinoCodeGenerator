package com.zs6bvr.arduino.code.generator.controllers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zs6bvr.arduino.code.generator.business.logic.BusinessLogicProcessor;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.CreateContributorDTO;
import com.zs6bvr.arduino.code.generator.dtos.CreateContributorResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.Contributor;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.utils.RequestResponseUtils;

@Controller
@RequestMapping("/project")
public class ProjectPageController {

	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

	private final String PERSIST_PROJECT_DATA="PERSIST_PROJECT_DATA";
	private final String OTHER_CATEGORY="otherCategory";
	private final String NEW_PROJECT="New Project";

	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	
	@Autowired
	BusinessLogicProcessor processor;
	

	@GetMapping("/listall")
	public String displayListallHomePage(Model model) {	
		UploadFeatureResponse response = processor.getAllFeatures();
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null) {
			featureDtos=new ArrayList<>();
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("featureDtos", featureDtos);

		return "project/listallpage";
	}
	
	@GetMapping("/listallAction")
	public String listall(Model model) {	
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);

		return "project/listAllPageResult";
	}
	
	@PostMapping(value = "/generatecode", 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String generateCode(@RequestBody BuildProjectRequest request) {
		log.info("GeneratorController | generateProjectCode | called");
		String generatedCode= processor.generateProjectCode(request);

		return "project/generatePageResult";
	}

	@GetMapping("/generate")
	public String displayGenerateHomePage(Model model) {	
		BuildProjectRequest buildProjectRequest=new BuildProjectRequest();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectRequest", buildProjectRequest);

		return "project/generatepage";
	}
	

	@PostMapping("/generateProjectAction")
	public String generateProject(BuildProjectRequest buildProjectRequest,Model model) {
		log.info("GeneratorController | generateProjectCode | request : "+buildProjectRequest);
		String firstModule=buildProjectRequest.getFirstModule();
		if(StringUtils.isNotEmpty(firstModule)) {
			firstModule=firstModule.stripLeading();
			firstModule=firstModule.stripTrailing();
			if(StringUtils.isNotEmpty(firstModule)) {
				buildProjectRequest.setFirstModule(firstModule);
			}
		}
		 BuildProjectResponse buildProjectResponse = processor.generateProjectCodeResponse(buildProjectRequest);

		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectResponse", buildProjectResponse);

		return "project/generatePageResult";
	}
	
	@GetMapping("/generateAction")
	public String generate(Model model) {	
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVer<br/>sion", projectVersion);
		model.addAttribute("projectName", projectName);

		return "project/generatePageResult";
	}
	
	@GetMapping("/create")
	public String displayCreateHomePage(Model model) {		

		ProjectFeature projectFeature=new ProjectFeature();
		projectFeature.setFeatureStatus(NEW_PROJECT);
		UploadFeatureDto uploadFeatureDto=new UploadFeatureDto();

		List<String> categories = processor.getAllCategories();
		UploadFeatureResponse response = processor.getAllFeatures();
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null||featureDtos.size()<1) {
			featureDtos=new ArrayList<>();
		}
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);
		model.addAttribute("featureDtos", featureDtos);
		model.addAttribute("categories", categories);
		model.addAttribute("projectFeature",projectFeature);

		return "project/createpage";
	}

	
	@GetMapping("/createAction")
	public String create(UploadFeatureDto uploadFeatureDto,Model model) {
		ProjectFeature feature = processor.createFeature(uploadFeatureDto);
		uploadFeatureDto=RequestResponseUtils.makeUploadFeatureDto(feature);
		BuildProjectResponse buildProjectResponse=new BuildProjectResponse();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectResponse", buildProjectResponse);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);

		return "project/createPageResult";
	}
	
	

	
	@GetMapping("/createcontributor")
	public String displayCreateContributorHomePage(Model model) {			
		UploadFeatureDto uploadFeatureDto=new UploadFeatureDto();

		List<String> categories = processor.getAllCategories();
		UploadFeatureResponse response = processor.getAllFeatures();
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null) {
			featureDtos=new ArrayList<>();
		}
		
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);
		model.addAttribute("featureDtos", featureDtos);
		model.addAttribute("categories", categories);

		return "project/createcontributorpage";
	}

	
	@GetMapping("/createContributorAction")
	public String createContributor(CreateContributorDTO contributorDTO,Model model) {
		CreateContributorResponse response = processor.createContributor(contributorDTO);
		BuildProjectResponse buildProjectResponse=new BuildProjectResponse();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectResponse", buildProjectResponse);
		model.addAttribute("response", response);

		return "project/createcontributorResult";
	}
	
	@GetMapping("/update")
	public String displayUpdateHomePage(Model model) {	
		UploadFeatureDto uploadFeatureDto=new UploadFeatureDto();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);

		return "project/updatepage";
	}
	

	
	@GetMapping("/updateForm")
	public String displayUpdateFormPage(UploadFeatureDto uploadFeatureDto,Model model) {
		List<String> categories = processor.getAllCategories();
		String projectGUID=null;
		ProjectFeature projectFeature = null;
		if(uploadFeatureDto!=null && StringUtils.isNotEmpty(uploadFeatureDto.getProjectGUID())) {
			projectGUID=uploadFeatureDto.getProjectGUID();
			projectGUID=projectGUID.stripLeading();
			projectGUID=projectGUID.stripTrailing();
			projectFeature = processor.findByProjectGuid(projectGUID);
		}
		
		if(projectFeature==null) {
			projectFeature=new ProjectFeature();
		}

		UploadFeatureResponse response = processor.getAllFeatures();
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null) {
			featureDtos=new ArrayList<>();
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);
		model.addAttribute("featureDtos", featureDtos);
		model.addAttribute("categories", categories);
		model.addAttribute("projectFeature", projectFeature);

		return "project/updateForm";
	}

	
	@GetMapping("/updateAction")
	public String update(UploadFeatureDto uploadFeatureDto,Model model) {
		if(uploadFeatureDto!=null && OTHER_CATEGORY.equalsIgnoreCase(uploadFeatureDto.getCategory())) {
			uploadFeatureDto.setCategory(uploadFeatureDto.getOtherCategory());
		}

		ProjectFeature projectFeature = processor.updateFeature(uploadFeatureDto);
		BuildProjectResponse buildProjectResponse=new BuildProjectResponse();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectResponse", buildProjectResponse);
		model.addAttribute("uploadFeatureDto", uploadFeatureDto);
		model.addAttribute("projectFeature", projectFeature);

		return "project/updatePageResult";
	}
	

	
	@GetMapping("/generateNewProject")
	public String generateNewProject(Model model) {	

		BuildProjectRequest buildProjectRequest=new BuildProjectRequest();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectRequest", buildProjectRequest);

		return "project/generateNewProject";
	}
	

	

	@PostMapping("/generateNewProjectAction")
	public String generateNewProject(BuildProjectRequest request,Model model) {
		
		
		log.info("ProjectPageController | generateNewProject | POST called");
		 BuildProjectResponse buildProjectResponse = processor.generateNewProjectResponse(request);

		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectResponse", buildProjectResponse);

		return "project/generateNewProjectResult";
	}
	
	@GetMapping(value="/generateNewProjectAction", 
	consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String generateNewProjectAction(@RequestBody BuildProjectRequest request,Model model) {	

		
		log.info("ProjectPageController | generateNewProjectAction | get called");
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);

		return "project/generateNewProjectResult";
	}
	

	
	@GetMapping("/searchPage")
	public String displaySearchHomePage(Model model) {	
		BuildProjectRequest buildProjectRequest=new BuildProjectRequest();
		List<String> categories = processor.getAllCategories();
		UploadFeatureResponse response = new UploadFeatureResponse();
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null) {
			featureDtos=new ArrayList<>();
		}
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("buildProjectRequest", buildProjectRequest);
		model.addAttribute("featureDtos", featureDtos);
		model.addAttribute("categories", categories);

		return "project/searchPage";
	}
	
	@GetMapping("/searchPageAction")
	public String search(BuildProjectRequest buildProjectRequest,Model model) {	
		String category=null;
		if(buildProjectRequest!=null) {
			category=buildProjectRequest.getCategory().trim();
			category=category.stripLeading();
			category=category.stripTrailing();
		}
		UploadFeatureResponse response = processor.getAllFeaturesByCategory(category);
		List<UploadFeatureDto> featureDtos = response.getUploadFeatureDtos();
		if(featureDtos==null) {
			featureDtos=new ArrayList<>();
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("featureDtos", featureDtos);

		return "project/searchPageResult";
	}
}
