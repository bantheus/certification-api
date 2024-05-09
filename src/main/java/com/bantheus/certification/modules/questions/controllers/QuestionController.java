package com.bantheus.certification.modules.questions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantheus.certification.modules.questions.entities.QuestionEntity;
import com.bantheus.certification.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

  @Autowired
  private QuestionRepository questionRepository;

  @GetMapping("/technology/{technology}")
  public List<QuestionEntity> findByTechnology(@PathVariable String technology) {
    return this.questionRepository.findByTechnology(technology);
  }
  
}
