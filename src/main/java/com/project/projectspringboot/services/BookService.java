package com.project.projectspringboot.services;

import com.project.projectspringboot.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
