/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.restcontrollers;

import com.mx.mutations.beans.DnaResponseBean;
import com.mx.mutations.db.view.dto.MutationViewDto;
import com.mx.mutations.repositories.MutationRepository;
import com.mx.mutations.util.mappers.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanch
 */
@RestController
public class StatsRestController {

  @Autowired
  private MutationRepository mutationRepository;

  @GetMapping(value = "stats", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity stats() {
    MutationViewDto record = mutationRepository.getMutationsSummary();
    if (record != null) {
      MapperUtil mapToResponse = new MapperUtil();
      DnaResponseBean rb = (DnaResponseBean) mapToResponse.map(record, DnaResponseBean.class);
      rb.caculateRatio();
      return new ResponseEntity(rb, HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
