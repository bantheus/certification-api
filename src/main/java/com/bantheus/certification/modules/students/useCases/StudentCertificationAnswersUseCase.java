package com.bantheus.certification.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bantheus.certification.modules.questions.entities.QuestionEntity;
import com.bantheus.certification.modules.questions.repositories.QuestionRepository;
import com.bantheus.certification.modules.students.dto.StudentCertificationAnswerDTO;

@Service
public class StudentCertificationAnswersUseCase {

  @Autowired
  private QuestionRepository questionRepository;
  
  public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
    
    List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(studentCertificationAnswerDTO.getTechnology());

    studentCertificationAnswerDTO.getQuestionsAnswers()
    .stream()
    .forEach(questionAnswer -> {
      var question = questionsEntity
      .stream()
      .filter(q -> q.getId().equals(questionAnswer.getQuestionId()))
      .findFirst()
      .get();

      var findCorrectAlternative = question.getAlternatives()
      .stream()
      .filter(alternative -> alternative.isCorrect()).findFirst().get();

      if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId())) {
        questionAnswer.setCorrect(true);
      } else {
        questionAnswer.setCorrect(false);
      }
    });

    return studentCertificationAnswerDTO;
  }
}
