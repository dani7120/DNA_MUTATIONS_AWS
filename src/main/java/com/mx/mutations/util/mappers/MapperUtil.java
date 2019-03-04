/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.util.mappers;

import org.modelmapper.ModelMapper;

/**
 *
 * @author sanch
 */
public class MapperUtil<T> {

  public T map(T source, Class<T> tipo) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(source, tipo);
  }
}

