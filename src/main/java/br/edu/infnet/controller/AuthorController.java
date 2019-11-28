package br.edu.infnet.controller;

import br.edu.infnet.model.Author;
import br.edu.infnet.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/secure/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Author> authors = authorRepository.findAll();
        model.put("authorList", authors);
        return "author/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return "author/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name,
                       @RequestParam("nationality") String nationality,
                       Map<String, Object> model) {
        Author author = new Author();
        author.setName(name);
        author.setNationality(nationality);
        authorRepository.save(author);
        model.put("message", name + " cadastrado");
        return "author/add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Author author = authorRepository.findOne(id);
        model.put("author", author);
        return "author/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@RequestParam("idAuthor") Long idAuthor,
                       @RequestParam("name") String name,
                       @RequestParam("nationality") String nationality,
                       Map<String, Object> model) {
        Author author = authorRepository.findOne(idAuthor);
        author.setName(name);
        author.setNationality(nationality);
        authorRepository.save(author);

        model.put("author", author);
        model.put("message", name + " editado.");
        return "redirect:/secure/author/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
        authorRepository.delete(id);
        return "redirect:/secure/author/";
    }

}
