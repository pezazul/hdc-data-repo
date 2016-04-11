package org.bjc.hi.hdc.data.repository;

import java.util.Date;
import java.util.List;

import org.bjc.hi.hdc.data.bean.DocumentIndex;
import org.springframework.data.repository.CrudRepository;

public interface DocumentIndexRepository extends CrudRepository<DocumentIndex, String> {

    List<DocumentIndex> findByUpiAndEventTsBetween(String upi, Date startDate, Date endDate);
}