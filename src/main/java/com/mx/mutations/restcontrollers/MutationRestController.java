/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.restcontrollers;

import com.mx.mutations.beans.DnaRequestBean;
import com.mx.mutations.repositories.MutationRepository;
import com.mx.mutations.services.MutationService;
import com.mx.mutations.util.exceptions.DnaInvalidCharacterException;
import com.mx.mutations.util.exceptions.DnaInvalidSizeException;
import com.mx.mutations.util.validators.DnaValidator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanch
 */
@RestController
public class MutationRestController {

  @Autowired
  private MutationService mutationService;
  @Autowired
  private MutationRepository mutationRepository;

  @PostMapping(value = "mutation", consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity mutation(@RequestBody DnaRequestBean dnaRequestBean) {
    try {
      DnaValidator.validateCharacters(dnaRequestBean.getDna());
      DnaValidator.validateNxNArraySize(dnaRequestBean.getDna());
    } catch (DnaInvalidCharacterException | DnaInvalidSizeException exception ) {
      Map response = new HashMap();
      response.put("message", exception.getMessage());
      return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    boolean hasMutation = mutationService.hasMutation(dnaRequestBean.getDna());
    mutationRepository.addNewRecord(hasMutation);
    if (hasMutation) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
  }



}
