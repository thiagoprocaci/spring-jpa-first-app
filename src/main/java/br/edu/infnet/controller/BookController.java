package br.edu.infnet.controller;

import br.edu.infnet.model.Author;
import br.edu.infnet.model.Book;
import br.edu.infnet.model.Publisher;
import br.edu.infnet.repository.AuthorRepository;
import br.edu.infnet.repository.PublisherRepository;
import br.edu.infnet.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/secure/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Book> books = bookRepository.findAll();
        model.put("bookList", books);
        return "book/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Map<String, Object> model) {
        Iterable<Author> authors = authorRepository.findAll();
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.put("authorList", authors);
        model.put("publisherList", publishers);
        return "book/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name,
                       @RequestParam("year") Integer year,
                       @RequestParam(value = "idAuthor", required = false) Long idAuthor,
                       @RequestParam(value = "idPublisher", required = false) Long idPublisher,
                       Map<String, Object> model) {
        Book book = new Book();
        book.setName(name);
        book.setYear(year);
        if (idAuthor != null) {
            Author author = authorRepository.findOne(idAuthor);
            book.setAuthor(author);
        }
        if (idPublisher != null) {
            Publisher publisher = publisherRepository.findOne(idPublisher);
            book.setPublisher(publisher);
        }
        bookRepository.save(book);
        model.put("message", name + " cadastrado");
        Iterable<Author> authors = authorRepository.findAll();
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.put("authorList", authors);
        model.put("publisherList", publishers);
        return "book/add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Book book = bookRepository.findOne(id);
        model.put("book", book);
        Iterable<Author> authors = authorRepository.findAll();
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.put("authorList", authors);
        model.put("publisherList", publishers);
        return "book/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@RequestParam("idBook") Long idBook,
                         @RequestParam("name") String name,
                         @RequestParam("year") Integer year,
                         @RequestParam("idAuthor") Long idAuthor,
                         @RequestParam("idPublisher") Long idPublisher,
                         Map<String, Object> model) {
        Book book = bookRepository.findOne(idBook);
        Author author = authorRepository.findOne(idAuthor);
        Publisher publisher = publisherRepository.findOne(idPublisher);
        book.setName(name);
        book.setYear(year);
        book.setAuthor(author);
        book.setPublisher(publisher);
        bookRepository.save(book);

        model.put("message", name + " editado.");
        return "redirect:/secure/book/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
        bookRepository.delete(id);
        return "redirect:/secure/book/";
    }

}
