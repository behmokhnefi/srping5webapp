package com.behzad.spring5webapp.repositories;

import com.behzad.spring5webapp.model.Guid;
import org.springframework.data.repository.CrudRepository;

public interface GuidRepository extends CrudRepository<Guid,Long> {
}
