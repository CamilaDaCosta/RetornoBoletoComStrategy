package com.mycompany.retornoboletopadraostrategy.dao;

//@author camila da costa

import com.mycompany.retornoboletopadraostrategy.entity.Boleto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeituraRetornoBradesco implements LeituraRetorno{

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            //csv file containing data
            // nomeArquivo = "D:\\Downloads\\PPJ\\arquivos-retorno-boleto\\bradesco-1.csv";
            Reader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
            List<String[]> linhas = csvReader.readAll();
            for (String[] linha : linhas){
                for (String coluna : linha){
                    int i = 0;
                    System.out.println("Boleto: "+linha[i]);
                    i++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LeituraRetornoBradesco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
