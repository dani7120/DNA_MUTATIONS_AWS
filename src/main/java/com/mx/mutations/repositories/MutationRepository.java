/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.repositories;

import com.mx.mutations.db.dto.DNAMutationsDto;
import com.mx.mutations.db.view.dto.MutationViewDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dsanchezbar2
 */
@Repository
public class MutationRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  @Transactional
  public void addNewRecord(Boolean hasMutation) {
    DNAMutationsDto dNAMutationsDto = new DNAMutationsDto();
    dNAMutationsDto.setHasMutation(hasMutation);
    hibernateTemplate.save(dNAMutationsDto);
  }

  public MutationViewDto getMutationsSummary() {
    MutationViewDto record = null;
    try (Session session = hibernateTemplate.getSessionFactory().openSession()) {
      record = (MutationViewDto) session.createNativeQuery(" select ID,COUNT_MUTATIONS,COUNT_NO_MUTATIONS from MUTATIONS_VIEW").addEntity(MutationViewDto.class).getSingleResult();
    }
    return record;
  }

}
