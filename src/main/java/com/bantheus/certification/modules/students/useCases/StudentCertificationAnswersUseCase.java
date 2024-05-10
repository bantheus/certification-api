package com.bantheus.certification.modules.students.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bantheus.certification.modules.questions.entities.QuestionEntity;
import com.bantheus.certification.modules.questions.repositories.QuestionRepository;
import com.bantheus.certification.modules.students.dto.StudentCertificationAnswerDTO;
import com.bantheus.certification.modules.students.entities.AnswersCertificationEntity;
import com.bantheus.certification.modules.students.entities.CertificationStudentEntity;
import com.bantheus.certification.modules.students.entities.StudentEntity;
import com.bantheus.certification.modules.students.repositories.CertificationStudentRepository;
import com.bantheus.certification.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private CertificationStudentRepository certificationStudentRepository;
  
  public CertificationStudentEntity execute(StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
    
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

    var student = studentRepository.findByEmail(studentCertificationAnswerDTO.getEmail());

    UUID studentId;

    if(student.isEmpty()){
      var studentCreate = StudentEntity.builder().email(studentCertificationAnswerDTO.getEmail()).build();
      studentCreate =  studentRepository.save(studentCreate);
      studentId = studentCreate.getId();
    } else {
      studentId = student.get().getId();
    }

    List<AnswersCertificationEntity> answersCertifications = new ArrayList<>();

    CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
    .technology(studentCertificationAnswerDTO.getTechnology())
    .studentId(studentId)
    .answersCertificationEntities(answersCertifications)
    .build();

    var certificationStudentCreated = certificationStudentRepository.save(certificationStudentEntity);

    return certificationStudentCreated;
  }
}