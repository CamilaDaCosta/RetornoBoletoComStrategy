package com.mycompany.retornoboletopadraostrategy.dao;

import java.io.IOException;
import java.util.Scanner;

// autor: Camila da Costa

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner dado = new Scanner(System.in);
        Main main = new Main();
        
        System.out.println("Digite 1 para Banco do Brasil e 2 Para Bradesco: ");
        int resposta = dado.nextInt();
        
        if(resposta == 1){
            main.BancoBrasil();
        }
        if (resposta==2){
            main.Bradesco();
        }else{
            System.out.println("Resposta Inválida");
        }
    }
    
    public void BancoBrasil(){
        ProcessarBoletos processador = new ProcessarBoletos(ProcessarBoletos::lerBancoBrasil);
        System.out.println("Banco Do Brasil");
        String nomeArquivo = "D:\\Downloads\\PPJ\\arquivos-retorno-boleto\\banco-brasil-1.csv";      
        processador.processar(nomeArquivo);
    }
    public void Bradesco(){
        ProcessarBoletos processador = new ProcessarBoletos(ProcessarBoletos::lerBradesco);
        System.out.println("Bradesco");
        String nomeArquivo = "D:\\Downloads\\PPJ\\arquivos-retorno-boleto\\bradesco-1.csv";     
        processador.processar(nomeArquivo);
    }
}