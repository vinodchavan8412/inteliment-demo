package com.inteliment.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.services.ParseService;
import com.inteliment.demo.services.ParseServiceImpl;

@Component
public class FileHandler {
	
	@Autowired
	private ParseServiceImpl parseService;
	
	public ParseService getHandler(MultipartFile file){
		String extention=getFileExtention(file);
		if(extention.equalsIgnoreCase("csv")||extention.equalsIgnoreCase("psv")){
			return parseService;
		}
		return null;
	}
	public  String getFileExtention(final MultipartFile file) {
		String fileExtention = null;
		if (file != null) {
			final String fileName = file.getOriginalFilename();
			String seprator = "\\.";
			int one = 1;
			final String[] fileExtentionArray = fileName.split(seprator);
			fileExtention = fileExtentionArray[fileExtentionArray.length - one];

		}
		return fileExtention;
	}

}
