package br.edu.infnet.controller;

import br.edu.infnet.model.Author;
import br.edu.infnet.model.Book;
import br.edu.infnet.model.Publisher;
import br.edu.infnet.repository.AuthorRepository;
import br.edu.infnet.repository.BookRepository;
import br.edu.infnet.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/book")
public class BookRestController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book insert(@RequestBody Book book) {
        Publisher publisher = book.getPublisher();
        if(publisher != null && (publisher.getId() == null || publisherRepository.findOne(publisher.getId()) == null) ) {
            publisher.setId(null);
            publisherRepository.save(publisher);
        }
        Author author = book.getAuthor();
        if(author != null && (author.getId() == null || authorRepository.findOne(author.getId()) == null)) {
            author.setId(null);
            authorRepository.save(author);
        }
        bookRepository.save(book);
        return book;
    }


}
