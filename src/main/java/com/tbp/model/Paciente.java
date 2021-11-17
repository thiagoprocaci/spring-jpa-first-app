package com.tbp.model;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa {

    @Column(name = "plano_saude")
    private String planoSaude;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
