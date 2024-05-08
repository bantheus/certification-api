package com.bantheus.certification.modules.students.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersCertificationEntity {
  private UUID id;
  private UUID certificationId;
  private UUID studentId;
  private UUID questionId;
  private boolean isCorrect;
}
