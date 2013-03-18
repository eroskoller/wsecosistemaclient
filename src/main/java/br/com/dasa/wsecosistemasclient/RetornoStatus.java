/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import java.math.BigDecimal;


/**
 *
 * @author Marcos Naves
 */
public class RetornoStatus {
    
    private String reqStCodigo;
    private String exaStCodigo;
    private String reqStCodigoAlt;
    private String updStCodigo;
    private String edpStCodigo;
    private String uniStCodigo;
    private BigDecimal derInFlag;

    public RetornoStatus() {
    }

    public RetornoStatus(String reqStCodigo, String exaStCodigo, String reqStCodigoAlt, String updStCodigo, String edpStCodigo, String uniStCodigo, BigDecimal derInFlag) {
        this.reqStCodigo = reqStCodigo;
        this.exaStCodigo = exaStCodigo;
        this.reqStCodigoAlt = reqStCodigoAlt;
        this.updStCodigo = updStCodigo;
        this.edpStCodigo = edpStCodigo;
        this.uniStCodigo = uniStCodigo;
        this.derInFlag = derInFlag;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getReqStCodigoAlt() {
        return reqStCodigoAlt;
    }

    public void setReqStCodigoAlt(String reqStCodigoAlt) {
        this.reqStCodigoAlt = reqStCodigoAlt;
    }

    public String getUpdStCodigo() {
        return updStCodigo;
    }

    public void setUpdStCodigo(String updStCodigo) {
        this.updStCodigo = updStCodigo;
    }

    public String getEdpStCodigo() {
        return edpStCodigo;
    }

    public void setEdpStCodigo(String edpStCodigo) {
        this.edpStCodigo = edpStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public BigDecimal getDerInFlag() {
        return derInFlag;
    }

    public void setDerInFlag(BigDecimal derInFlag) {
        this.derInFlag = derInFlag;
    }

    
}
