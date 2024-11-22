package org.treinamento.programacao_funcional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExercicioFinal {
    public static void main(String[] args) {

        System.out.println("Calculando a média");
        List<Produto> produtos = getListaProdutoCsv();

        Double soma = produtos.stream().mapToDouble(Produto::getPreco).sum();
        Double media = produtos.stream().mapToDouble(Produto::getPreco).average().getAsDouble();

        System.out.println("Tamanho da Lista : " + produtos.size());
        System.out.printf("Soma R$ %.2f\n", soma);
        System.out.printf("Média R$ %.2f\n", media);

        System.out.println("Filtrando lista e ordenando de forma descrescente");
        List<Produto> produtoFilter = produtos
                .stream()
                .filter(p -> p.getPreco() < media)
                .sorted()
                .collect(Collectors.toList());

        produtoFilter.forEach(System.out::println);

    }

    static class Produto implements Comparable<Produto>{
        private String nome;
        private Double preco;

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Produto produto = (Produto) o;
            return Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, preco);
        }

        @Override
        public String toString() {
            return "Produto{" +
                    "nome='" + nome + '\'' +
                    ", preco=" + preco +
                    '}';
        }

        @Override
        public int compareTo(Produto outro) {
            return -preco.compareTo(outro.getPreco());
        }
    }

    static List<Produto> getListaProdutoCsv(){
        String path = "C:\\temp\\produtos.txt";

        List<Produto> produtos = new ArrayList<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String line = bufferedReader.readLine();

            while (line != null){
                produtos.add(converter(line));
                line = bufferedReader.readLine();
            }

        }catch (Exception e){
            System.out.println("Erro : " + e.getMessage());
        }
        return produtos;
    }

    static Produto converter(String linha){
        if (Objects.isNull(linha)){
            throw new RuntimeException("A linha é null/vazia");
        }
        String[] vet = linha.split(",");
        String nome = vet[0];
        Double preco = Double.parseDouble(vet[1]);

        return new Produto(nome, preco);
    }
}
