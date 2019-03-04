/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.db.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dsanchezbar2
 */
@Entity
@Table(name= "MUTATIONS")
public class DNAMutationsDto implements Serializable{
  
  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID_MUTATION")
  private Long idDNAMutationDto;
  
  @Getter
  @Setter
  @Column(name="HAS_MUTATION")
  private Boolean hasMutation;
  
}
