package com.Demo.hero.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

//import com.Demo.hero.exception.MessageParamException;



@Service
public class UploadImageService {
	
	//@Value("${app.upload.dir:${user.home}}")
		 @Value("${app.uploaddir}")
	    private String uploadDir ;
		private Path copyLocation;
		
		private Optional<String> getExtensionByFileName(String filename) {
		    return Optional.ofNullable(filename)
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
		}
		
		
		public void uploadFile(MultipartFile file) {
			
			System.out.println(uploadDir);
	    	
	    	// verifier si le fichier est selectionné
	    	try {
	    		if (file.isEmpty()) {
	    			 throw new RuntimeException("");}
	    	}
	    	catch (RuntimeException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Empty File");
	        }
	    	
	    	// verifier si le fichier est une image 		
			  try { 
				  if (!getExtensionByFileName(file.getOriginalFilename()).get().equals("jpg")) { 
					  throw new RuntimeException("");} 
				  } 
			  catch (RuntimeException e) {
	            e.printStackTrace(); throw new
	            RuntimeException("Invalid File Format"); }
			 
	    	
	    	// copier fichier
			  
	        try {
	            copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
	            System.out.println(copyLocation);
	            Path parent = copyLocation.getParent();
	            Files.createDirectories(parent);
	            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
	           // System.out.println(copyLocation);
	           
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could Not store the file");
	        }
	        
	        	//return readexcel.readExcel(copyLocation.toFile(), locale);

	    }
		
		public boolean deleteImage(String imageName) {
			
			try {
	            copyLocation = Paths.get(uploadDir + File.separator + imageName);
	            System.out.println(copyLocation);
	            return Files.deleteIfExists(copyLocation);
	            }
			catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could Not delete the file");
	        }
			
		}

}
