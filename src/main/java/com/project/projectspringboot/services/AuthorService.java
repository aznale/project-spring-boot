package com.project.projectspringboot.services;

import com.project.projectspringboot.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
