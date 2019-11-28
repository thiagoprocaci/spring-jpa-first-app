package br.edu.infnet;

import br.edu.infnet.model.*;
import br.edu.infnet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseBoot {

    private void testUsuarioComHeranca(SuperUsuarioRepository superUsuarioRepository,
                                       UsuarioAdminRepository usuarioAdminRepository,
                                       UsuarioComumRepository usuarioComumRepository) {

        Long count = superUsuarioRepository.count();
        if(count == 0) {
            UsuarioAdmin usuarioAdmin = new UsuarioAdmin();
            usuarioAdmin.setEmail("usuarioAdmin@usuario.com");
            usuarioAdmin.setName("usuarioAdmin");
            usuarioAdmin.setPassword("123");
            usuarioAdmin.setUsername("usuarioAdmin");
            usuarioAdmin.setDescricao("desc");
            usuarioAdminRepository.save(usuarioAdmin);


            UsuarioComum usuarioComum = new UsuarioComum();
            usuarioComum.setEmail("usuarioComum@usuario.com");
            usuarioComum.setName("usuarioComum");
            usuarioComum.setUsername("usuarioComum");
            usuarioComum.setPassword("123");
            usuarioComum.setEndereco("endereco");
            usuarioComumRepository.save(usuarioComum);
        }


    }


    private void testUsuarioClasseUnica(UsuarioRepository usuarioRepository) {
        Long count = usuarioRepository.countByTipo(0);
        if(count == 0) {
            Usuario usuario = new Usuario();
            usuario.setName("usuario");
            usuario.setEmail("usuario@usuario.com");
            usuario.setUsername("usuario");
            usuario.setPassword("123");
            usuario.setTipo(0);
            usuarioRepository.save(usuario);
        }
        count = usuarioRepository.countByTipo(1);
        if(count == 0) {
            Usuario usuario = new Usuario();
            usuario.setName("usuario1");
            usuario.setEmail("usuario1@usuario.com");
            usuario.setUsername("usuario1");
            usuario.setPassword("123");
            usuario.setTipo(1);
            usuarioRepository.save(usuario);
        }
        Usuario usuario = usuarioRepository.findByUsernameOrEmail("usuario", null);
        System.out.println("Usuario recuperado: " + usuario.getName());

        usuario = usuarioRepository.findByUsernameOrEmail(null, "usuario@usuario.com");
        System.out.println("Usuario recuperado: " + usuario.getName());
    }

    @Autowired
    public DatabaseBoot(SuperUsuarioRepository superUsuarioRepository,
                        UsuarioAdminRepository usuarioAdminRepository,
                        UsuarioComumRepository usuarioComumRepository,
            AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository, UsuarioRepository usuarioRepository) {


        testUsuarioClasseUnica(usuarioRepository);
        testUsuarioComHeranca(superUsuarioRepository, usuarioAdminRepository, usuarioComumRepository);

        Long authorCount = authorRepository.count();
        Long publisherCount = publisherRepository.count();
        Long bookCount = bookRepository.count();
        if(authorCount == 0 && publisherCount == 0 && bookCount == 0) {

            Author a1 = new Author();
            a1.setName("George Orwell");
            a1.setNationality("Inglês");
            authorRepository.save(a1);

            Author a2 = new Author();
            a2.setName("H. G. Wells");
            a2.setNationality("Inglês");
            authorRepository.save(a2);

            Author a3 = new Author();
            a3.setName("Alexandre Dumas");
            a3.setNationality("Francês");
            authorRepository.save(a3);

            Author a4 = new Author();
            a4.setName("Machado de Assis");
            a4.setNationality("Brasileiro");
            authorRepository.save(a4);


            Publisher p1 = new Publisher();
            p1.setName("Fundamento");
            publisherRepository.save(p1);

            Publisher p2 = new Publisher();
            p2.setName("Companhia das Letras");
            publisherRepository.save(p2);

            Publisher p3 = new Publisher();
            p3.setName("Editora 34");
            publisherRepository.save(p3);

            Publisher p4 = new Publisher();
            p4.setName("Rocco");
            publisherRepository.save(p4);


            Book b1 = new Book();
            b1.setName("A Máquina do Tempo");
            b1.setYear(1895);
            b1.setAuthor(a2);
            b1.setPublisher(p2);
            bookRepository.save(b1);

            Book b2 = new Book();
            b2.setName("O Conde de Monte Cristo");
            b2.setYear(1844);
            b2.setAuthor(a3);
            b2.setPublisher(p1);
            bookRepository.save(b2);

            Book b3 = new Book();
            b3.setName("A Revolução dos Bichos");
            b3.setYear(1945);
            b3.setAuthor(a1);
            b3.setPublisher(p3);
            bookRepository.save(b3);

            Book b4 = new Book();
            b4.setName("Dom Casmurro");
            b4.setYear(1900);
            b4.setAuthor(a4);
            b4.setPublisher(p4);
            bookRepository.save(b4);
        }
    }
}
