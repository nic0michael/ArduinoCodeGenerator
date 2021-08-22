package com.zs6bvr.arduino.code.generator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Autowired
	BusinessLogicProcessor processor;

    @GetMapping("/")
    public String index() {
        return "upload";
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
