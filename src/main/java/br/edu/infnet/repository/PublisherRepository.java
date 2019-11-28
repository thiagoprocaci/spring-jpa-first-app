package br.edu.infnet.repository;

import br.edu.infnet.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Publisher findByName(String name);
}
