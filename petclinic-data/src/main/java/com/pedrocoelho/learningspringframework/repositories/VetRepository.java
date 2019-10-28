package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
