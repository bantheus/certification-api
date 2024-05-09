package com.bantheus.certification.modules.questions.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlternativesResultDTO {
  
  private UUID id;
  private String description;
}
