package com.tbp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa {

    @Column(name = "plano_saude")
    private String planoSaude;

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }
}
