/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.util.exceptions;

/**
 *
 * @author sanch
 */
public class DnaInvalidCharacterException extends Exception {

  private static final String INVALID_CHARACTERS_MESSAGE = "The array contents wrong character";

  public DnaInvalidCharacterException() {
    super(INVALID_CHARACTERS_MESSAGE);
  }

}
