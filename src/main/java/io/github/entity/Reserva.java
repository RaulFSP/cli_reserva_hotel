/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.entity;

/**
 *
 * @author usuario
 */
public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private Integer diasQuantidade;
    private Double valorDiaria;
    private Double valorTotal;
    public Reserva(String nomeHospede, String tipoQuarto, Integer diasQuantidade, Double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.diasQuantidade = diasQuantidade;
        this.valorDiaria = valorDiaria;
        this.valorTotal = this.valorDiaria * this.diasQuantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }
    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
    public String getTipoQuarto() {
        return tipoQuarto;
    }
    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    public Integer getDiasQuantidade() {
        return diasQuantidade;
    }
    public void setDiasQuantidade(Integer diasQuantidade) {
        this.diasQuantidade = diasQuantidade;
    }
    public Double getValorDiaria() {
        return valorDiaria;
    }
    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return nomeHospede+"\t"+tipoQuarto+"\t"+diasQuantidade+"\t"+valorTotal;
    }
}
