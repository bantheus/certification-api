package com.bantheus.certification.modules.students.entities;

import java.util.List;
import java.util.UUID;

public class CertificationStudentEntity {
  private UUID id;
  private UUID studentId;
  private String technology;
  private int grate;
  List<AnswersCertificationEntity> answersCertificationEntity;
}
