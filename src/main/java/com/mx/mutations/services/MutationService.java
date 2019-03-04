/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author sanch
 */
@Service
public class MutationService {

  public boolean hasMutation(String[] dna) {
    boolean hasMutation = Boolean.FALSE;
    int times = 0;
    int colPos = 0;
    int size = dna[0].length() - 1; // 5
    for (String mutation : MutationConstants.MUTATIONS) {
      // Search horizontally
      for (String dna2 : dna) {
        if (dna2.contains(mutation)) {
          times++;
        }//if
        // build vertical strings and verify it 
        StringBuilder sb = new StringBuilder();
        for (String dna1 : dna) {
          sb.append(dna1.charAt(colPos));
        } //for j
        if (sb.toString().contains(mutation)) {
          times++;
        }//if
        colPos++;
      } //for i
      // build vertical strings and verify it 
      colPos = 0;
      times += validateDiagonalLeftToRight(mutation, size, dna);
      times += validateDiagonalRighToLeft(mutation, size, dna);
    } //for data
    if (times >= 1) {
      hasMutation = Boolean.TRUE;
    }//if
    return hasMutation;
  }

  private static int validateDiagonalLeftToRight(String mutationSequence, int size, String[] dna) {
    int x = 0;
    int times = 0;
    for (int y = 0; y <= size; y++) {
      if (y + 1 >= MutationConstants.PATTERN_SIZE) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int temp = size;
        for (int i = 0; i <= x; i++) {
          sb.append(dna[i].charAt(x - i));
          if (y < size) {
            sb2.append(dna[temp--].charAt((size - x) + i));
          }//if
        }//for
        if (sb.toString().contains(mutationSequence) || sb2.toString().contains(mutationSequence)) {
          times++;
        }//if
      }
      x++;
    }//for i
    return times;
  }

  private static int validateDiagonalRighToLeft(String mutationSequence, int size, String[] dna) {
    int x = 0;
    int times = 0;
    for (int y = size; y >= 0; y--) {
      if (x + 1 >= MutationConstants.PATTERN_SIZE) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <= x; i++) {
          sb.append(dna[y + i].charAt(i));
          if (y > 0) {
            sb2.append(dna[i].charAt(y + i));
          }
        }//for
        if (sb.toString().contains(mutationSequence) || sb2.toString().contains(mutationSequence)) {
          times++;
        }//if
      }//if
      x++;
    }//for
    return times;
  }
}
