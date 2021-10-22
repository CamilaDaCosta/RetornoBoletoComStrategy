package com.mycompany.retornoboletopadraostrategy.entity;

//@author camila da costa

import com.mycompany.retornoboletopadraostrategy.dao.ProcessarBoletos;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Boleto {
    private int id;
    private String codBanco;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
     @Override
    public String toString() {
        String str = String.format("Id: %s Banco: %s", id, codBanco);
        String ag = "";
        if(agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty()){      
            ag = String.format(" Ag: %s CC: %s CPF: ", agencia, contaBancaria);
            try{
                javax.swing.text.MaskFormatter formatadorNumero = new javax.swing.text.MaskFormatter("###.###.###-##");
		javax.swing.JFormattedTextField txtNumero = new javax.swing.JFormattedTextField(formatadorNumero);
		txtNumero.setText(cpfCliente);
                ag+= txtNumero.getText();
            }catch (ParseException e){}
            
            
        }
        
        str += ag + String.format(
                " Vencimento: %s Data Pagamento: %s CPF: %s Valor: %.2f",ProcessarBoletos.FORMATO_DATA.format(dataVencimento),
                ProcessarBoletos.FORMATO_DATA_HORA.format(dataPagamento),cpfCliente,valor);
 
        if(multa > 0){
            str += String.format(" Multa: %10.2f", multa);
        }

        if(juros > 0){
            str += String.format(" Juros: %10.2f", juros);
        }

        return str;
    }
}
