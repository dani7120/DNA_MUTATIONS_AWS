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
public class DnaInvalidSizeException extends Exception {

  private static final String INVALID_SIZE_EXCEPTION = "The array is not NxN ";

  public DnaInvalidSizeException() {
    super(INVALID_SIZE_EXCEPTION);
  }

}
