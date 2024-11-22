package org.treinamento.programacao_funcional;

import java.util.Objects;

public class Empregado implements Comparable<Empregado>{

    private String nome;
    private Double salario;

    public Empregado(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregado empregado = (Empregado) o;
        return Double.compare(salario, empregado.salario) == 0 && Objects.equals(nome, empregado.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, salario);
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

    public boolean nonStaticRemoveByName(){
        return nome.equalsIgnoreCase("Miloca");
    }

    public static String staticNomeCaixaAlta(Empregado empregado){
        return empregado.getNome().toUpperCase();
    }

    @Override
    public int compareTo(Empregado outroEmpregado) {
        return -salario.compareTo(outroEmpregado.getSalario());
    }
}
