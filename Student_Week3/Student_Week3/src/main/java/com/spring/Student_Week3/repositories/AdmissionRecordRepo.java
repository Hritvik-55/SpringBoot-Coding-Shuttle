package com.spring.Student_Week3.repositories;

import com.spring.Student_Week3.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecord,Long> {
}
