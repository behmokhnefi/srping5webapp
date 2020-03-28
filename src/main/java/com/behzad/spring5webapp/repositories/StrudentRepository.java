package com.behzad.spring5webapp.repositories;

import com.behzad.spring5webapp.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StrudentRepository extends CrudRepository<Student,Long> {
}
