/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.util.validators;

import com.mx.mutations.util.exceptions.DnaInvalidCharacterException;
import com.mx.mutations.util.exceptions.DnaInvalidSizeException;

/**
 *
 * @author sanch
 */
public class DnaValidator {

  private static final String DNA_REGEX = "[ACGT]+";

  public static void validateCharacters(String[] dna) throws DnaInvalidCharacterException {
    for (String dna1 : dna) {
      if (!dna1.matches(DNA_REGEX)) {
        throw new DnaInvalidCharacterException();
      }
    }
  }

  public static void validateNxNArraySize(String[] dna) throws DnaInvalidSizeException {
    int size = dna.length;
    for (String dna1 : dna) {
      if (dna1.length()!=size) {
        throw new DnaInvalidSizeException();
      }
    }
  }

}
