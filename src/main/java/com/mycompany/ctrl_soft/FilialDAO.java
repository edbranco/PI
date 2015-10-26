/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

/**
 *
 * @author Lucas
 */
public class FilialDAO {

    private Long idfilial;
    private String nomefilial;
    private String uf;
    private String cnpj;

    public FilialDAO() {
    }

    public FilialDAO(String nomefilial, String uf, String cnpj) {

        this.nomefilial = nomefilial;
        this.uf = uf;
        this.cnpj = cnpj;

    }

    /**
     * @return the idfilial
     */
    public Long getIdfilial() {
        return idfilial;
    }

    /**
     * @param idfilial the idfilial to set
     */
    public void setIdfilial(Long idfilial) {
        this.idfilial = idfilial;
    }

    /**
     * @return the nomefilial
     */
    public String getNomefilial() {
        return nomefilial;
    }

    /**
     * @param nomefilial the nomefilial to set
     */
    public void setNomefilial(String nomefilial) {
        this.nomefilial = nomefilial;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
