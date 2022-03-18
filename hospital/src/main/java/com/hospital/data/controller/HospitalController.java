package com.hospital.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hospital.data.model.Hospital;
import com.hospital.data.repository.HospitalRepository;

@Controller
public class HospitalController {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping("/")
	public String home(){
		return "redirect:/hospital";
	}
	
	@GetMapping("hospital")
	public String home(Model model) {
		int startPage = 1;
		int endPage = 10;
		int num = 1;
		Sort sort = Sort.by("id");
		Pageable page = PageRequest.of(0, 15,sort);
		Page<Hospital> result = hospitalRepository.findAll(page);
		List<Hospital> list =	result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", num);
			return "main";
	}
	
	@GetMapping("hospital/{num}")
	public String home(Model model,@PathVariable("num")int num) {
		int startPage = (num - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		
		
		Sort sort = Sort.by("id");
		Pageable page = PageRequest.of(num-1, 15,sort);
		Page<Hospital> result = hospitalRepository.findAll(page);
		List<Hospital> list =	result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", num);
			return "main";
	}
	
	@GetMapping("test")
	public String test(Model model) {
		int startPage = 1;
		int endPage = 5;
		int num = 1;
		Sort sort = Sort.by("id");
		Pageable page = PageRequest.of(0, 15,sort);
		Page<Hospital> result = hospitalRepository.findAll(page);
		List<Hospital> list =	result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", num);
			return "test";
	}
	
	@GetMapping("test/{num}")
	public String test(Model model,@PathVariable("num")int num) {
		//int startPage = (num - 1) / 10 * 10 + 1;
		int startPage = num - 2;
		//int endPage = startPage + 9;
		int endPage = num + 2;
		if(startPage<1) {startPage=1;};
		if(endPage<5) {endPage=5;};
		
		
		Sort sort = Sort.by("id");
		Pageable page = PageRequest.of(num-1, 15,sort);
		Page<Hospital> result = hospitalRepository.findAll(page);
		List<Hospital> list =	result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", num);
			return "test";
	}

}
