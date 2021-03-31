package com.tbp.service;

import com.tbp.excecao.SemSaldoException;
import com.tbp.modelo.Conta;
import com.tbp.modelo.Pessoa;
import com.tbp.modelo.Transacao;
import com.tbp.repository.ContaRepository;
import com.tbp.repository.PessoaRepository;
import com.tbp.repository.TransacaoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Pessoa obterPessoaPelaConta(Integer idConta) {
           Optional<Conta> optionalConta = contaRepository.findById(idConta);
        if(optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            return pessoaRepository.findByConta(conta);
        }
        return null;
    }
    
    public List<Conta> buscarContaPeloNumero(Integer numero) {
        return contaRepository.findByNumero(numero);
    }
    
    public List<Conta> listarContas() {
        Iterable<Conta> contas = contaRepository.findAll();
        List<Conta> contaList = new ArrayList();
        for(Conta c : contas) {
            contaList.add(c);
        }
        return contaList;
    }
    
    public Extrato obterExtratoConta(Integer idConta) {
        Optional<Conta> optionalPessoa = contaRepository.findById(idConta);
        if(optionalPessoa.isPresent()) {
            Conta conta = optionalPessoa.get();
            Pessoa pessoa = obterPessoaPelaConta(idConta);
            List<Transacao> transacaoList = transacaoRepository.findByConta(conta);
            return new Extrato(pessoa, conta, transacaoList);
        }
        return null;
    }

    
    public Conta sacar(Integer idConta, Double valor) throws SemSaldoException {
        Optional<Conta> optionalConta = contaRepository.findById(idConta);
        if(optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            if(conta.getSaldo() >= valor) {
                Transacao transacao = new Transacao(conta, Transacao.SAQUE, valor);    
                transacaoRepository.save(transacao);
                atualizarSaldoConta(conta);
                return conta;
            }
            throw new SemSaldoException();
        }
        return null;
    }
    
    public Conta deposito(Integer idConta, Double valor) {
        Optional<Conta> optionalConta = contaRepository.findById(idConta);
        if(optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            Transacao transacao = new Transacao(conta, Transacao.DEPOSITO, valor);    
            transacaoRepository.save(transacao);
            atualizarSaldoConta(conta);   
            return conta;
        }
        return null;
    }
    
    private void atualizarSaldoConta(Conta conta) {
        List<Transacao> transacaoList = transacaoRepository.findByConta(conta);
        if(transacaoList != null) {
            Double soma = 0.0;
            for(Transacao t : transacaoList) {
                if(t != null) {
                    if(Transacao.SAQUE.equals(t.getTipo())) {
                        soma = soma - t.getValor();
                    } else if(Transacao.DEPOSITO.equals(t.getTipo())) {
                        soma = soma + t.getValor();
                    }    
                }
            }
            conta.setSaldo(soma);
            contaRepository.save(conta);
        }
    }
    
    
    public void inicializar() {
        long count = pessoaRepository.count();
        if(count == 0) {
            Conta c1 = new Conta(123, "Banco do Brasil");
            contaRepository.save(c1);
            Pessoa p1 = new Pessoa("Jose da Silva", "000.000.000-00", c1);
            pessoaRepository.save(p1);
            
            Conta c2 = new Conta(456, "Caixa Economica");
            contaRepository.save(c2);
            Pessoa p2 = new Pessoa("Maria Souza", "111.000.000-00", c2);
            pessoaRepository.save(p2);
                       
        }
    }
}
