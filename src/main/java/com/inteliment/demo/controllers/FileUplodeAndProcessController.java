package com.inteliment.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.config.FileHandler;
import com.inteliment.demo.models.Storage;
import com.inteliment.demo.services.ParseService;

@RestController
public class FileUplodeAndProcessController {
	
	public static final Logger logger = LoggerFactory.getLogger(FileUplodeAndProcessController.class);
	
	@Autowired
	private FileHandler fileHandler;
	
	@RequestMapping(path="/upload",method=RequestMethod.POST)
	Storage uploadeFile(@RequestParam("file") final MultipartFile file,@RequestParam("type") String type,
			 @RequestParam("criteria") String criteria)
	{
	logger.info("Rectify csv and psv files or not.");
	// rectify csv and psv files or not.
	ParseService parseService=	fileHandler.getHandler(file);
	// storing data of csv and psv files in database
	 
	 return parseService.parse(file,type);
		
	 // after providing criteria it will work. depending on which data and which field then we will filter on it.
	 //Storage storedData=parseService.filter(file,criteria);
	}
	
	/*@RequestMapping(path="/upload",method=RequestMethod.GET)
	Storage retrieveFile(@RequestParam("file") final MultipartFile file,@RequestParam("type") String type,
			@RequestParam("filter") String filter, @RequestParam("criteria") String criteria)
	{
	logger.info("Rectify csv and psv files or not.");
	// rectify csv and psv files or not.
	ParseService parseService=	fileHandler.getHandler(file);
	// storing data of csv and psv files in database
	return parseService.parse(file,type);*/
		
	//}

}
