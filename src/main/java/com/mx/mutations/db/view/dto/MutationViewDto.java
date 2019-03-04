/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.db.view.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dsanchezbar2
 */
@Entity
public class MutationViewDto implements Serializable {

  @Id
  @Column(name = "ID")
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  @Column(name = "COUNT_MUTATIONS")
  private Long countMutations;

  @Getter
  @Setter
  @Column(name = "COUNT_NO_MUTATIONS")
  private Long countNoMutations;
}
