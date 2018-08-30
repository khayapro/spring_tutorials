package com.example.spring5webapp.repository;

import com.example.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {
}
