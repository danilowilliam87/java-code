package org.treinamento.programacao_funcional;

import java.util.function.Function;

public class AumentoSalarioFunction implements Function<Empregado, Empregado> {

    @Override
    public Empregado apply(Empregado empregado) {
        double salario = (empregado.getSalario() * (20.0 / 100.0));
        empregado.setSalario(salario + empregado.getSalario());
        return empregado;
    }
}
