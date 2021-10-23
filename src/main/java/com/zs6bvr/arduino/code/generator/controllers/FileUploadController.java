package com.zs6bvr.arduino.code.generator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zs6bvr.arduino.code.generator.business.logic.BusinessLogicProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

	private final String PERSIST_PROJECT_DATA="PERSIST_PROJECT_DATA";

	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	
	@Autowired
	BusinessLogicProcessor processor;

	@GetMapping("arduino-dashboard") //arduino-dashboard
	public String displayHome1(Model model) {
		return "redirect:/arduino-dashboard/home";
	}
	
	@GetMapping("/home")
	public String displayHome2(Model model) {
		return "redirect:/arduino-dashboard/home";
	}

	@GetMapping("/arduino-dashboard/home")
	public String displayHomePage(Model model) {	
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);

		return "main/home";
	}
	

    @PostMapping("/projects") 
    public String singleFileUploadProjectFile(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            log.info("Projects file uploaded size : "+bytes.length);
            String fileText=new String(bytes);
            String result=processor.processUploadData(fileText, PERSIST_PROJECT_DATA);
            
            if("SUCCESS".equalsIgnoreCase(result)) {
            	redirectAttributes.addFlashAttribute("message","You successfully uploaded file with content : \n" + fileText);
            } else {
            	redirectAttributes.addFlashAttribute("message","You got rerult : "+result+" while uploading file with content : \n" + fileText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
}
