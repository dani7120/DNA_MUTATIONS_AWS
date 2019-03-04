/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.util.validator;

import com.mx.mutations.util.exceptions.DnaInvalidCharacterException;
import com.mx.mutations.util.exceptions.DnaInvalidSizeException;
import com.mx.mutations.util.validators.DnaValidator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sanch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaValidatorTest {

  @Test
  public void validDna() {
    boolean thrown = true;
    String[] dna = {"CAGT", "TAAC", "CCCA"};
    try {
      DnaValidator.validateCharacters(dna);
    } catch (DnaInvalidCharacterException dnaInvalidCharacterException) {
      thrown = false;
      assertTrue(thrown);
    }
    assertTrue(thrown);
  }

  @Test
  public void invalidDna() {
    boolean thrown = false;
    String[] dna = {"CAGT", "TDAC", "CCCA"};
    try {
      DnaValidator.validateCharacters(dna);
    } catch (DnaInvalidCharacterException dnaInvalidCharacterException) {
      thrown = true;
      assertEquals("The array contents wrong character", dnaInvalidCharacterException.getMessage());
    }
    assertTrue(thrown);
  }

  @Test
  public void invalidArraysize() {
    boolean thrown = false;
    String[] dna = {"CAGT", "TDAC", "CCC"};
    try {
      DnaValidator.validateNxNArraySize(dna);
    } catch (DnaInvalidSizeException dnaInvalidSizeException) {
      thrown = true;
      assertEquals("The array is not NxN ", dnaInvalidSizeException.getMessage());
    }
    assertTrue(thrown);
  }
}
