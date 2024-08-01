package com.Demo.hero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.hero.dao.IHero;
import com.Demo.hero.dto.HeroDto;
import com.Demo.hero.model.Hero;
import com.Demo.hero.service.UploadImageService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200" , "http://192.168.1.11:4200" })
@RequestMapping("/hero/")
public class heroController {
	
    @Autowired
    IHero ihero;
    
    @Autowired
    UploadImageService uploadImageService;
    
    @PostMapping(value = "ajout" , produces = "application/json") 
	  public ResponseEntity<Hero> addHero(@RequestBody Hero h) {
    	//System.out.println("Hero :: " +h);
    	ihero.save(h);
    	ihero.getReferenceById(h.getId());
    	return new ResponseEntity<Hero>(h , HttpStatus.OK);
	  }
    
    @GetMapping("list")
    public ResponseEntity<List<Hero>> listHero() {
    	return new ResponseEntity<List<Hero>>(ihero.findAll(),HttpStatus.OK );
    }
    
    @DeleteMapping("deletehero/{id}")
    public ResponseEntity<Void> deltehero(@PathVariable long id){
    	String imageName = ihero.findById(id).get().getImage();
    	try {
    	ihero.deleteById(id);
    	boolean existed = uploadImageService.deleteImage(imageName);
    	if (existed) {
    	    return new ResponseEntity<Void>(HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    	}
    	
    	}catch(RuntimeException ex) {
    		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GetMapping("gethero/{id}")
    public ResponseEntity<Hero> gethero(@PathVariable long id) {
    	return new ResponseEntity<Hero>(ihero.findById(id).get(),HttpStatus.OK );
    }
    
    @PutMapping("updatehero/{id}")
    public ResponseEntity<Hero> updatehero(@PathVariable long id , @RequestBody Hero h) {
    	Hero h2 =ihero.findById(id).get();
    	h2.setName(h.getName());
    	h2.setPower(h.getPower());
    	h2.setImage(h.getImage());
    	ihero.save(h2);
    	return  ResponseEntity.ok(h2);
    }
    
    @PostMapping(value = "create" , consumes = { "multipart/form-data" })
    public ResponseEntity<Hero> createHero(@ModelAttribute HeroDto h) {
    	uploadImageService.uploadFile(h.getImage());
    	Hero h2 = new Hero(h.getName(), h.getPower(), h.getImage().getOriginalFilename());
    	ihero.save(h2);
    	return  ResponseEntity.ok(h2);
    }
    

}
