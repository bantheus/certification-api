package com.bantheus.certification.modules.students.entities;

import java.util.UUID;

public class AnswersCertificationEntity {
  private UUID id;
  private UUID certificationId;
  private UUID studentId;
  private UUID questionId;
  private boolean isCorrect;
}
