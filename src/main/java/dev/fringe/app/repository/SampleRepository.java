package dev.fringe.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.fringe.app.domain.Sample;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Integer> {}
