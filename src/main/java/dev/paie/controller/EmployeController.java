package dev.paie.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Employe;
import dev.paie.service.EmployeService;
import dev.paie.utils.LinkService;

@RestController
@RequestMapping("/paie-app")
public class EmployeController {
	@Autowired
	EmployeService employeService;
	@Autowired
	LinkService linkService;
	
	@PostMapping("/insert-employe")
	public void insert(@RequestBody Employe e, HttpServletResponse response) {

	}
}
