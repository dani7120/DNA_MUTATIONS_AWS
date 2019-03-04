/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sanch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutationServiceTest {

  @Autowired
  private MutationService mutationService;

  @Test
  public void isMutation() {
    boolean ans = true;
    String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    boolean isMutation = mutationService.hasMutation(dna);
    assertEquals(ans, isMutation);
  }

  @Test
  public void isNotMutation() {
    boolean ans = false;
    String[] dna = {
      "ATGCGA",
      "CAGTGC",
      "TTATTT",
      "AGACGC",
      "GCGTCA",
      "TCACTG"};
    boolean isMutation = mutationService.hasMutation(dna);
    assertEquals(ans, isMutation);

  }

}
