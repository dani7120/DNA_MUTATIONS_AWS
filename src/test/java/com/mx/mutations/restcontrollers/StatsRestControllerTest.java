/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.restcontrollers;

import com.mx.mutations.beans.DnaResponseBean;
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
public class StatsRestControllerTest {

  @Autowired
  private StatsRestController statsRestController;

  @Test
  public void stats() {
    ResponseEntity<String> response = statsRestController.stats();
    assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void testRatio() {
    DnaResponseBean rb = new DnaResponseBean();
    rb.setCountMutations(40L);
    rb.setCountNoMutations(100L);
    float ratio = rb.getCountMutations() / rb.getCountNoMutations();
    assertEquals(0.4, 0.4, ratio);
  }
  
}
