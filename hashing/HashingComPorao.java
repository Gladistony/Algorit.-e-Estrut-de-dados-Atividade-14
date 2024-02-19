package hashing;

public class HashingComPorao implements EstruturaDeDados{

    private  final int tamanho = 1011;
    private  final int porao = 100;

    private int[] dados;
    private int[] poraoDados;
    private int poraoIndex;

    public HashingComPorao() {
        dados = new int[tamanho];
        poraoDados = new int[porao];
        poraoIndex = 0;
    }

    private void aumentarPorao() {
        int[] novoPorao = new int[poraoIndex + (int)(porao/2)];
        for (int i = 0; i < poraoIndex; i++) {
            novoPorao[i] = poraoDados[i];
        }
        poraoDados = novoPorao;
        System.out.println("O porão ficou cheio, o tamanho do mesmo foi aumentado para " + poraoDados.length);
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
            if (poraoIndex >= poraoDados.length) {
                aumentarPorao();
            }
            poraoDados[poraoIndex] = chave;
            poraoIndex++;
        }
    }

    @Override
    public void delete(int chave) {
        int pos = identidade(chave);
        if (dados[pos] == chave) {
            dados[pos] = 0;
        } else {
            for (int i = 0; i < poraoIndex; i++){
                if (poraoDados[i] == chave) {
                    for (int j = i; j < poraoIndex; j++){
                        poraoDados[j] = poraoDados[j+1];
                    }
                    poraoIndex--;
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
            for (int i = 0; i < poraoIndex; i++){
                if (poraoDados[i] == chave) {
                    return true;
                }
            }
                
        }
        return false;
    }
    
}
