package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto implements EstruturaDeDados{

    private static final int tamanho = 1011;
    private int[] dados;

    public HashingEncadeamentoAberto() {
        dados = new int[tamanho];
    }

    private int identidade(int chave) {
        return chave % tamanho;
    }

    @Override
    public void insert(int chave) {
        int pos = identidade(chave);
        if (dados[pos] == 0) {
            dados[pos] = chave;
        } else {
            for (int i = pos; i < tamanho; i++) {
                if (dados[i] == 0) {
                    dados[i] = chave;
                    break;
                }
            }
        }
    }

    @Override
    public void delete(int chave) {
        int pos = identidade(chave);
        if (dados[pos] == chave) {
            dados[pos] = 0;
        } else {
            for (int i = pos; i < tamanho; i++) {
                if (dados[i] == chave) {
                    dados[i] = 0;
                    break;
                }
            }
        }
    }

    @Override
    public boolean search(int chave) {
        int pos = identidade(chave);
        if (dados[pos] == chave) {
            return true;
        } else {
            for (int i = pos; i < tamanho; i++) {
                if (dados[i] == chave) {
                    return true;
                }
            }
        }
        return false;
    }
    
}