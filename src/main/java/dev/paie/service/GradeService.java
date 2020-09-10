package dev.paie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Service
public class GradeService {
	@Autowired
	GradeRepository gradeRepository;
	
	public Optional<Grade> select(Integer idGrade) {
		return this.gradeRepository.findById(idGrade);
	}
}
