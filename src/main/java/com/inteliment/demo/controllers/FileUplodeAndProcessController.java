package com.inteliment.demo.controllers;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.config.FileHandler;
import com.inteliment.demo.models.Storage;
import com.inteliment.demo.services.ParseService;
import com.inteliment.demo.util.MyResponse;

@RestController
public class FileUplodeAndProcessController {
	
	public static final Logger logger = LoggerFactory.getLogger(FileUplodeAndProcessController.class);
	
	HashMap<String, Object> result;
	
	@Autowired
	private MyResponse response;
 
	@Autowired
	private FileHandler fileHandler;
	
	@RequestMapping(path="/upload",method=RequestMethod.POST)
	ResponseEntity<?> uploadeFile(@RequestParam("file") final MultipartFile file,@RequestParam("type") String type,
			 @RequestParam("criteria") String criteria)
	{
	logger.info("Rectify csv and psv files or not.");
	// rectify csv and psv files or not.
	ParseService parseService=	fileHandler.getHandler(file);
	// storing data of csv and psv files in database
	  Storage storageData =parseService.parse(file,type);
	  // after providing criteria it will work. depending on which data and which field then we will filter on it.
		 //Storage storedData=parseService.filter(file,criteria);
	  		result.put("storageData", storageData);
			response.setResponseCode(200);
			response.setComment("File Save Successfully");
			response.setResponseMessage("FETCH");
			response.setResult(result);
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		
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
