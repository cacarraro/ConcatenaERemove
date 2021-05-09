package Operacoes;

import java.util.Scanner;

public class OperacoesString {
    public OperacoesString() {
    }

    public boolean tamanhoValido(int tamanho) {
        return tamanho >= 1 && tamanho <= 100;
    }

    public boolean entradaValida(String entrada) {
        return entrada.equals(entrada.toLowerCase());
    }

    public String recebeString() {
        // cria um Scan para ler a entrada do usuario
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a string de caracteres minusculos com até 100 caracteres: ");
        String entrada = scan.nextLine();

        if (tamanhoValido(entrada.length()) && entradaValida(entrada)) {
            System.out.println("String inserida foi aceita!");
            return entrada;
        } else
        {
            System.out.println("Insira novamente a String, agora contendo mais de 0 e menos de 100 caracteres!");
            return recebeString();
        }
    }

    public int recebeInt() {
        // cria um Scan para ler a entrada do usuario
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o numero exato de operações (entre 1 e 100) que quer realizar a transformacao: ");
        int K = scan.nextInt();
        scan.close();
        if (!tamanhoValido(K)) {
            System.out.println("Insira novamente o valor, garanta que ele está entre 1 e 100");
            return recebeInt();
        }
        System.out.println("Valor inserido foi aceito!");
        return K;
    }

    public int tamanhoMaiorPrefixo(String inicial, String desejado)
    {
        for (int tamanho = 0; tamanho < desejado.length() && tamanho< inicial.length(); tamanho++) {
            String prefixoDesejado = desejado.substring(0, tamanho);
            String prfixoInicial = inicial.substring(0, tamanho);
            if (!prfixoInicial.equals(prefixoDesejado)) {
                return tamanho - 1;
            }
        }
        return desejado.length();
    }

    public String ConcatERemove(String inicial, String desejado, int k)
    {
        int tamanho = tamanhoMaiorPrefixo(inicial, desejado);

        int minimoRemocao = inicial.length() - tamanho;
        int minimoConcat = desejado.length() - tamanho;

        int minimoDeOperacoes = minimoRemocao + minimoConcat;

        return (k >= minimoDeOperacoes) ? "Sim" : "Não";
    }
}

class Main {
    public static void main(String[] args) {
        OperacoesString o = new OperacoesString();
        String s = o.recebeString();
        String t = o.recebeString();
        int k = o.recebeInt();

        System.out.println(o.ConcatERemove(s,t,k));

    }
}