package org.treinamento.programacao_funcional;

import java.util.function.Function;

public class CaixaAltaFunction implements Function<Empregado, Empregado> {

    @Override
    public Empregado apply(Empregado empregado) {
        String nome = empregado.getNome().toUpperCase();
        empregado.setNome(nome);
        return empregado;
    }
}
