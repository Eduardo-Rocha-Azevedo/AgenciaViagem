package com.AgenciaViagem.AgenciaViagem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pacotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nome;
    private String destino;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private LocalDate data;
    private BigDecimal preco;
    private String inclusoes;
    private String exclusoes;
    
    @Lob
    private byte[] imagem;
    // Getters e Setters

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getInclusoes() {
        return inclusoes;
    }

    public void setInclusoes(String inclusoes) {
        this.inclusoes = inclusoes;
    }

    public String getExclusoes() {
        return exclusoes;
    }

    public void setExclusoes(String exclusoes) {
        this.exclusoes = exclusoes;
    }
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
