package com.project.projectspringboot.repositories;

import com.project.projectspringboot.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
