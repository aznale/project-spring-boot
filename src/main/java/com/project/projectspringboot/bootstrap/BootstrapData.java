package com.project.projectspringboot.bootstrap;

import com.project.projectspringboot.domain.Author;
import com.project.projectspringboot.domain.Book;
import com.project.projectspringboot.domain.Publisher;
import com.project.projectspringboot.repositories.AuthorRepository;
import com.project.projectspringboot.repositories.BookRepository;
import com.project.projectspringboot.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456789");

        Publisher tigredepaper = new Publisher();
        tigredepaper.setPublisherName("Columna");
        tigredepaper.setAddress("Foneria, 5-7, baixos. 08243 Manresa (Països Catalans)");
        tigredepaper.setCity("Barcelona");
        tigredepaper.setState("Catalunya");
        tigredepaper.setZipCode("000000");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher tigredepaperSaved = publisherRepository.save(tigredepaper);



        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("456567345");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        dddSaved.setPublisher(tigredepaperSaved);
        noEJBSaved.setPublisher(tigredepaperSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}
