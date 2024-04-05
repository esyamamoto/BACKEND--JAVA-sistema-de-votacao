package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.lang.Math;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (!pessoasCandidatas.isEmpty()) {
      for (PessoaCandidata candidata : pessoasCandidatas) {
        if (candidata.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
      }
    }
    PessoaCandidata novaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novaCandidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (!pessoasEleitoras.isEmpty()) {
      for (PessoaEleitora eleitora : pessoasEleitoras) {
        if (eleitora.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
      }
    }
    PessoaEleitora eleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(eleitora);
  }

  @Override
  public void votar (String cpfPessoaEleitora,int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        break;
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    for (PessoaCandidata candidato : pessoasCandidatas) {
      System.out.println("Nome: " + candidato.getNome()
          + " - " + candidato.getVotos() + " votos " + "( " + Math.round(
          (float) (candidato.getVotos() * 100) / cpfsComputados.size()) + " )");
    }
    System.out.println("Total de votos: " + cpfsComputados.size());
  }
}

