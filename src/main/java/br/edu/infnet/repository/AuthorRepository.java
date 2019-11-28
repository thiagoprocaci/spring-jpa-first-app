package br.edu.infnet.repository;

import br.edu.infnet.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}
