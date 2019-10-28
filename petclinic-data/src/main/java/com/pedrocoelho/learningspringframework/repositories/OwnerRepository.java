package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
