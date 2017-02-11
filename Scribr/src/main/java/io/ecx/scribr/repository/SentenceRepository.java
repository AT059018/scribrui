package io.ecx.scribr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import io.ecx.scribr.domain.SentenceModel;

public interface SentenceRepository extends CrudRepository<SentenceModel, Long> {

}
