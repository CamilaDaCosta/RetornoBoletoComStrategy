package com.mycompany.retornoboletopadraostrategy.dao;

import static com.mycompany.retornoboletopadraostrategy.dao.LeituraRetorno.FORMATO_DATA;
import com.mycompany.retornoboletopadraostrategy.entity.Boleto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(0,0,0));  
                boleto.setCpfCliente(vetor[6].substring(0, 3)+"."+vetor[6].substring(3,6)+"."+vetor[6].substring(6,9)+"-"+vetor[6].substring(9,11));
                
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
