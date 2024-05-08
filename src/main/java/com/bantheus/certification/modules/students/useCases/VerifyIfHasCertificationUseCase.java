package com.bantheus.certification.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.bantheus.certification.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
  
  public boolean execute(VerifyHasCertificationDTO dto) {
    if(dto.getEmail().equals("matheus@teste.com") && dto.getTechnology().equals("Java")) {
        return true;
    }

    return false;
  }
}
