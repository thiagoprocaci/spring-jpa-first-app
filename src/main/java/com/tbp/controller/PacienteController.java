package com.tbp.controller;


import com.tbp.model.Endereco;
import com.tbp.model.Paciente;
import com.tbp.repository.PacienteRepository;
import com.tbp.service.ViaCepService;
import com.tbp.service.dto.EnderecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("cadastro")
    public String paginaCadastro() {
        return "paciente/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastrar(
            @RequestParam("cep") String cep,
            @RequestParam("numero") Integer numero,
            @RequestParam("complemento") String complemento,
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("planoSaude") String planoSaude, Map<String, Object> model) {

        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        paciente.setPlanoSaude(planoSaude);
        paciente.setNome(nome);

        cep = cep.replace("-", "");
        EnderecoDto enderecoDto = viaCepService.buscarEnderecoPor(cep);

        Endereco endereco = new Endereco();
        endereco.setCep(enderecoDto.getCep());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setComplemento(complemento);
        endereco.setLocalidade(enderecoDto.getLocalidade());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setNumero(numero);
        endereco.setUf(enderecoDto.getUf());

        paciente.setEndereco(endereco);


        pacienteRepository.save(paciente);
        model.put("mensagem", "Paciente " + nome + " cadastrado com sucesso");
        return "paciente/cadastro";
    }



}
