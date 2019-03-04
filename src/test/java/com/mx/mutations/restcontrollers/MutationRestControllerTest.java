/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.restcontrollers;

import com.mx.mutations.beans.DnaRequestBean;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sanch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutationRestControllerTest {

  @Autowired
  private MutationRestController mutationRestController;

  @Test
  public void mutation() {
    DnaRequestBean mutation = new DnaRequestBean();
    String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    mutation.setDna(dna);
    ResponseEntity<String> response = mutationRestController.mutation(mutation);
    assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

   @Test
  public void noMutation() {
    DnaRequestBean mutation = new DnaRequestBean();
    String[] dna = {
      "ATGCGA", 
      "CAGTGC", 
      "TTATTT", 
      "AGACGC", 
      "GCGTCA", 
      "TCACTG"};
    mutation.setDna(dna);
    ResponseEntity<String> response = mutationRestController.mutation(mutation);
    assertEquals(response.getStatusCode(), HttpStatus.FORBIDDEN);
  }
  


}
