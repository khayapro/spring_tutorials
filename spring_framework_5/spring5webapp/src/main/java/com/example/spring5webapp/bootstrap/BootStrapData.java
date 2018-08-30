package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Address;
import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repository.AuthorRepository;
import com.example.spring5webapp.repository.BookRepository;
import com.example.spring5webapp.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {


    private static final Logger Log = LoggerFactory.getLogger(BootstrapData.class);

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {

        Log.info("Start - init data into the database ");
        final Author author = new Author("George", "Brown");

        final Address address = new Address();
        address.setStreetName("some Street");
        address.setSuburb("some suburb");
        address.setCity("Germiston");
        address.setPostalCode(1702);

        final Publisher publisher = new Publisher("Xaba Publishers", address);
        publisherRepository.save(publisher);

        final Book book = new Book("Habbits", UUID.randomUUID().toString(), publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        bookRepository.save(book);
        authorRepository.save(author);

        final Author author1 = new Author("George", "Simmons");
        final Book book1 = new Book("Habbit Stacking", UUID.randomUUID().toString(), publisher);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        bookRepository.save(book1);
        authorRepository.save(author1);

        Log.info("Finish - init data into the database");
    }
}
