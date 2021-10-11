package com.mycompany.retornoboletopadraostrategy.dao;

//@author camila da costa

import com.mycompany.retornoboletopadraostrategy.entity.Boleto;
import java.util.List;


public class ProcessarBoletos {
    
    LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
    
    public void processar(String nomeArquivo){
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }   
}
