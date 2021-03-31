package com.tbp.excecao;

public class SemSaldoException extends Exception {

    public SemSaldoException() {
        super("Saldo insuficiente");
    }
    
}
