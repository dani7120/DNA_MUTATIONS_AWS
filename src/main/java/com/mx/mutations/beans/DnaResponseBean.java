/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dsanchezbar2
 */
public class DnaResponseBean {

  @Getter
  @Setter
  @JsonProperty("count_mutations")
  private Long countMutations;
  @Getter
  @Setter
  @JsonProperty("count_no_mutation")
  private Long countNoMutations;
  @Getter
  @Setter
  @JsonProperty("ratio")
  private float ratio;

  public void caculateRatio() {
    this.ratio = this.countMutations / this.countNoMutations;
  }
}
