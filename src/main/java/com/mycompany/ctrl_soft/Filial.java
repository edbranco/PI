
package com.mycompany.ctrl_soft;

public class Filial {

    protected Long idfilial;
    protected String nomefilial;
    protected String uf;
    protected String cnpj;

    public Filial(Long idfilial, String nomefilial, String uf, String cnpj) {
        this.idfilial = idfilial;
        this.nomefilial = nomefilial;
        this.uf = uf;
        this.cnpj = cnpj;
    }

    public Filial(){
    
    }
    
    /**
     * @return the idfilial
     */
    public long getIdfilial() {
        return idfilial;
    }

    /**
     * @param idfilial the idfilial to set
     */
    public void setIdfilial(long idfilial) {
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
