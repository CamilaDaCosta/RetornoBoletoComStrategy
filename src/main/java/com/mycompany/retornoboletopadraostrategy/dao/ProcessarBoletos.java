package com.mycompany.retornoboletopadraostrategy.dao;

import com.mycompany.retornoboletopadraostrategy.entity.Boleto;
import java.util.List;

public class ProcessarBoletos {
    
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno){
	 this.leituraRetorno = leituraRetorno;
    }
    public final void processar(String nomeArquivo){
        System.out.println("---------------------------------------------------------------------------------------------------------");
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }
    
    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
