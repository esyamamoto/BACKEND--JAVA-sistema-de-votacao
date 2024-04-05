package com.betrybe.sistemadevotacao;

/**
 * Pessoa Candidata.
 */
public class PessoaCandidata extends Pessoa {
  public int numero;
  public int votos;

  /**
   * Pessoa Candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos++;
  }
}
