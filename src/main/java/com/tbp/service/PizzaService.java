package com.tbp.service;

import com.tbp.modelo.Composicao;
import com.tbp.modelo.Ingrediente;
import com.tbp.modelo.Pizza;
import com.tbp.repository.ComposicaoRepository;
import com.tbp.repository.IngredienteRepository;
import com.tbp.repository.PizzaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
   @Autowired
   private ComposicaoRepository composicaoRepository;
   @Autowired
   private PizzaRepository pizzaRepository;
   @Autowired
   private IngredienteRepository ingredienteRepository;
   
   public void inicializar() {
       long count = composicaoRepository.count();
       if(count == 0) {        
            Pizza pizza = new Pizza("calabresa", 10d);
            pizzaRepository.save(pizza);
            
            Ingrediente presunto = new Ingrediente("presunto");
            ingredienteRepository.save(presunto);
            
            Ingrediente cebola = new Ingrediente("cebola");
            ingredienteRepository.save(cebola);
            
            Ingrediente queijo = new Ingrediente("queijo");
            ingredienteRepository.save(queijo);
            
            Composicao c1 = new Composicao(pizza, presunto);
            composicaoRepository.save(c1);
            
            Composicao c2 = new Composicao(pizza, cebola);
            composicaoRepository.save(c2);
            
            Composicao c3 = new Composicao(pizza, queijo);
            composicaoRepository.save(c3);
            
       }
   }
   
   public List<Composicao> salvarPizza(String nome, Double preco, String[] ingredientes) {
       Pizza pizza = new Pizza(nome, preco);
       pizzaRepository.save(pizza);
       for(String nomeIngrediente : ingredientes) {
           Ingrediente ingrediente = ingredienteRepository.findByNome(nome);
            if(ingrediente == null) {
                ingrediente = new Ingrediente(nomeIngrediente);
                ingredienteRepository.save(ingrediente);
            }
           Composicao c = new Composicao(pizza, ingrediente);
           composicaoRepository.save(c);
       }
       return composicaoRepository.findByPizza(pizza);
   }
   
}
