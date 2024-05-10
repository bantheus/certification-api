package com.bantheus.certification.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bantheus.certification.modules.questions.entities.QuestionEntity;
import com.bantheus.certification.modules.questions.repositories.QuestionRepository;
import com.bantheus.certification.modules.students.dto.StudentCertificationAnswearDTO;
import com.bantheus.certification.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswearsUseCase {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private QuestionRepository questionRepository;
  
  public StudentCertificationAnswearDTO execute(StudentCertificationAnswearDTO studentCertificationAnswearDTO) throws Exception {
    var student = studentRepository.findByEmail(studentCertificationAnswearDTO.getEmail());

    if(student.isEmpty()){
      throw new Exception("E-mail do aluno não encontrado!");
    }

    List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(studentCertificationAnswearDTO.getTechnology());

    studentCertificationAnswearDTO.getQuestionsAnswears()
    .stream()
    .forEach(questionAnswear -> {
      var question = questionsEntity
      .stream()
      .filter(q -> q.getId().equals(questionAnswear.getQuestionId()))
      .findFirst()
      .get();

      var findCorrectAlternative = question.getAlternatives()
      .stream()
      .filter(alternative -> alternative.isCorrect()).findFirst().get();

      if(findCorrectAlternative.getId().equals(questionAnswear.getAlternativeId())) {
        questionAnswear.setCorrect(true);
      } else {
        questionAnswear.setCorrect(false);
      }
    });

    return studentCertificationAnswearDTO;
  }
}
