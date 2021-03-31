package com.tbp.service;

import com.tbp.modelo.Conta;
import com.tbp.modelo.Pessoa;
import com.tbp.modelo.Transacao;
import java.util.List;

public class Extrato {
    
    private Pessoa pessoa;
    private Conta conta;
    private List<Transacao> transacaoList;

    public Extrato(Pessoa pessoa, Conta conta, List<Transacao> transacaoList) {
        this.pessoa = pessoa;
        this.conta = conta;
        this.transacaoList = transacaoList;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Pessoa: ");
        buffer.append(pessoa.getNome());
        buffer.append("\n");
        
        buffer.append("Conta: ");
        buffer.append(conta.toString());
        buffer.append("\n");
        if(transacaoList != null) {
            for(Transacao t : transacaoList) {
                buffer.append(t.toString());
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }
    
    
    
}
