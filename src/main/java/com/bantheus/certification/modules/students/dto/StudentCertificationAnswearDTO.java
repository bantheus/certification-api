package com.bantheus.certification.modules.students.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCertificationAnswearDTO {
  
  private String email;
  private String technology;
  private List<QuestionAnswearDTO> questionsAnswears;
}
