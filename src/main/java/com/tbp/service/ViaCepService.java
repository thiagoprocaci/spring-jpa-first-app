package com.tbp.service;

import com.tbp.service.dto.EnderecoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( url = "https://viacep.com.br/ws/", name = "viaCepService")
public interface ViaCepService {

    @GetMapping("{cep}/json")
    EnderecoDto buscarEnderecoPor(@PathVariable("cep") String cep);
}
