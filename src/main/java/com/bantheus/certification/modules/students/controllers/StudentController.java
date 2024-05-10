package com.bantheus.certification.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantheus.certification.modules.students.dto.StudentCertificationAnswerDTO;
import com.bantheus.certification.modules.students.dto.VerifyHasCertificationDTO;
import com.bantheus.certification.modules.students.entities.CertificationStudentEntity;
import com.bantheus.certification.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.bantheus.certification.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @Autowired
  private StudentCertificationAnswersUseCase studentCertificationAnswerUseCase;
  
  @PostMapping("/verifyIfHasCertification")
  public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {

    var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);

    if(result) {
      return "Certified!";
    }

    return "Not certified!";

  }

  @PostMapping("/certification/answer")
  public CertificationStudentEntity certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
    return studentCertificationAnswerUseCase.execute(studentCertificationAnswerDTO);
  }
}
