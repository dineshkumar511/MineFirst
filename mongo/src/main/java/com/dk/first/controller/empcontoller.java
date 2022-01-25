package com.dk.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dk.first.model.employee;
import com.dk.first.repository.empRepo;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class empcontoller {
	
	
	@Autowired
	empRepo emprepo;
	
	
	@GetMapping("/test")
	public String test()
	{
		return "Its working";
	}
	
	
	@PostMapping("/adduser")
	public String adduser(@RequestBody employee emp)
	{
	  employee save = emprepo.save(emp);
	  return save.toString();
		
	}
	
	@GetMapping("/getuser")
	public List<employee> getuser()
	{
		return emprepo.findAll();
	}
	
	
	@PutMapping("/putuser")
	public String putuser(@RequestBody employee emp)
	{
     emprepo.deleteById(emp.getId());
     emprepo.save(emp);
     return "Modified as requested";
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable("id") int id)
	{
	   emprepo.deleteById(id);
	   
	   return "deleted succesfully";
	}
	
	@GetMapping("/getnamedetails")
	public  List<employee> getnamedetails(@RequestParam("name") String name)
	{
       return emprepo.findbyname(name);
	}
	
	@DeleteMapping("/deletebylocation")
	public void deletebylocation(@RequestParam("location") String location)
	{
		emprepo.deletebylocation(location);
		
	}
	
	@DeleteMapping("/deleteallbylocation")
	public void deletealllocation(@RequestParam("location") String location)
	{
		emprepo.deleteallbylocation(location);
		
	}

}
