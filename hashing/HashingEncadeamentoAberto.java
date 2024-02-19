package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto implements EstruturaDeDados{

    private No[] dados;
    private int tamanho = 100;

    public HashingEncadeamentoAberto() {
        dados = new No[tamanho];
    }

    private int identidade(int chave) {
        return chave % tamanho;
    }

    @Override
    public void insert(int chave) {
        int pos = identidade(chave);
        No novo = new No(chave);
        if (dados[pos] == null) {
            dados[pos] = novo;
        } else {
            No aux = dados[pos];
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
        }
    }

    @Override
    public void delete(int chave) {
        int pos = identidade(chave);
        if (dados[pos] != null) {
            if (dados[pos].valor == chave) {
                dados[pos] = dados[pos].proximo;
            } else {
                No aux = dados[pos];
                while (aux.proximo != null && aux.proximo.valor != chave) {
                    aux = aux.proximo;
                }
                if (aux.proximo != null) {
                    aux.proximo = aux.proximo.proximo;
                }
            }
        }
    }

    @Override
    public boolean search(int chave) {
        int pos = identidade(chave);
        No aux = dados[pos];
        while (aux != null) {
            if (aux.valor == chave) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
    
}

class No {
    int valor; 
    No proximo; 
    public No(int valor) {
      this.valor = valor;
      this.proximo = null;
    }
  }