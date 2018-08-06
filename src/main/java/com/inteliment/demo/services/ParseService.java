package com.inteliment.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.models.Storage;

@Service
public interface ParseService {
	Storage parse(MultipartFile file,String type);



	Storage filter(MultipartFile file, String criteria);
	
	

}
