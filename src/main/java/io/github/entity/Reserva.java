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
    private Integer dias;
    private Double valor;
    public Reserva(String nomeHospede, String tipoQuarto, Integer dias, Double valor) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.dias = dias;
        this.valor = valor;
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
    public Integer getDias() {
        return dias;
    }
    public void setDias(Integer dias) {
        this.dias = dias;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Reserva [nomeHospede=" + nomeHospede + ", tipoQuarto=" + tipoQuarto + ", dias=" + dias + ", valor="
                + valor + "]";
    }
    
}
