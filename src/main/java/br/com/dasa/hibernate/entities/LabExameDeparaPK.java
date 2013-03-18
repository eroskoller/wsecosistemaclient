package br.com.dasa.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Marcos Naves
 */
@Embeddable
public class LabExameDeparaPK implements Serializable {

    @NotNull
    @Column(name = "SIS_ST_CODIGO")
    private String sisStCodigo;
    @ManyToOne(fetch= FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "EXA_ST_CODIGO")
    private LabExame labExame;
    @NotNull
    @Column(name = "EDP_ST_CODIGO")
    private String edpStCodigo;
    @NotNull
    @Column(name = "SEQ_ST_CODIGO")
    private String seqStCodigo;

    public LabExameDeparaPK() {
    }

    public LabExameDeparaPK(String sisStCodigo, LabExame labExame, String edpStCodigo, String seqStCodigo) {
        this.sisStCodigo = sisStCodigo;
        this.labExame = labExame;
        this.edpStCodigo = edpStCodigo;
        this.seqStCodigo = seqStCodigo;
    }
    
    

    public String getEdpStCodigo() {
        return edpStCodigo;
    }

    public void setEdpStCodigo(String edpStCodigo) {
        this.edpStCodigo = edpStCodigo;
    }

   

    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    public LabExame getLabExame() {
        return labExame;
    }

    public void setLabExame(LabExame labExame) {
        this.labExame = labExame;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.sisStCodigo != null ? this.sisStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.labExame != null ? this.labExame.hashCode() : 0);
        hash = 83 * hash + (this.edpStCodigo != null ? this.edpStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameDeparaPK other = (LabExameDeparaPK) obj;
        if ((this.sisStCodigo == null) ? (other.sisStCodigo != null) : !this.sisStCodigo.equals(other.sisStCodigo)) {
            return false;
        }
        if (this.labExame != other.labExame && (this.labExame == null || !this.labExame.equals(other.labExame))) {
            return false;
        }
        if ((this.edpStCodigo == null) ? (other.edpStCodigo != null) : !this.edpStCodigo.equals(other.edpStCodigo)) {
            return false;
        }
        if ((this.seqStCodigo == null) ? (other.seqStCodigo != null) : !this.seqStCodigo.equals(other.seqStCodigo)) {
            return false;
        }
        return true;
    }

}
