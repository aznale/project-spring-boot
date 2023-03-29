package com.project.projectspringboot.repositories;

import com.project.projectspringboot.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
