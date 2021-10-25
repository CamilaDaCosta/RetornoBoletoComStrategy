package com.mycompany.retornoboletopadraostrategy.dao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        Scanner dado = new Scanner(System.in);
        Main main = new Main();
        
        System.out.println("Digite 1 para Banco do Brasil e 2 Para Bradesco: ");
        int resposta = dado.nextInt();
        
        switch (resposta) {
            case 1:
                main.BancoBrasil();
                break;
            case 2:
                main.Bradesco();
                break;
            default:
                System.out.println("Resposta Inválida");
                break;
        }
    }
    
    public void BancoBrasil(){
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        String nomeArquivo = "D:\\NetbeansProjects\\RetornoBoletoPadraoStrategy\\src\\main\\resources\\banco-brasil-1.csv";  
        System.out.println("Lendo arquivo " + nomeArquivo);
        System.out.println("Banco Do Brasil");
        processador.processar(nomeArquivo);
    }
    public void Bradesco(){
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBradesco());
        String nomeArquivo = "D:\\NetbeansProjects\\RetornoBoletoPadraoStrategy\\src\\main\\resources\\bradesco-1.csv";     
        System.out.println("Lendo arquivo " + nomeArquivo);
        System.out.println("Bradesco");
        processador.processar(nomeArquivo);
    }
}