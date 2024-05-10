package com.bantheus.certification.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswearDTO {
  
  private String questionId;
  private String alternativeId;
  private boolean isCorrect;
}
