package dev.fringe.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.fringe.app.domain.Desserts;

@Repository
public interface DessertsRepository extends CrudRepository<Desserts, String> {}
