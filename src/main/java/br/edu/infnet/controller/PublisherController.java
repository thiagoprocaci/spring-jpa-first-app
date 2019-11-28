package br.edu.infnet.controller;

import br.edu.infnet.model.Publisher;
import br.edu.infnet.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/secure/publisher")
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.put("publisherList", publishers);
        return "publisher/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Map<String, Object> model) {
        return "publisher/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name,
                       Map<String, Object> model) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherRepository.save(publisher);

        model.put("message", name + " cadastrado");
        return "publisher/add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Publisher publisher = publisherRepository.findOne(id);
        model.put("publisher", publisher);
        return "publisher/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@RequestParam("idPublisher") Long idPublisher,
                          @RequestParam("name") String name,
                          Map<String, Object> model) {
        Publisher publisher = publisherRepository.findOne(idPublisher);
        publisher.setName(name);
        publisherRepository.save(publisher);

        model.put("publisher", publisher);
        model.put("message", name + " editado");
        return "redirect:/secure/publisher/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
        publisherRepository.delete(id);
        return "redirect:/secure/publisher/";
    }

}
