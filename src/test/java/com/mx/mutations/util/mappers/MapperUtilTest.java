/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.util.mappers;

import com.mx.mutations.beans.DnaResponseBean;
import com.mx.mutations.db.view.dto.MutationViewDto;
import org.junit.Assert;
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
public class MapperUtilTest {
  
  @Test
  public void testMapResponse(){
    MapperUtil mapToResponse = new MapperUtil();
    MutationViewDto record = new MutationViewDto();
    record.setCountMutations(Long.MIN_VALUE);
    record.setCountNoMutations(Long.MIN_VALUE);
    DnaResponseBean responseBean = (DnaResponseBean) mapToResponse.map(record, DnaResponseBean.class);
    Assert.assertEquals(responseBean.getCountMutations(), record.getCountMutations());
    Assert.assertEquals(responseBean.getCountNoMutations(), record.getCountNoMutations());
  }
  
  
}
