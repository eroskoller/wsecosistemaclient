package br.com.dasa.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "LAB_EXAMEDEPARA")
public class LabExameDepara implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LabExameDeparaPK labExameDeparaPK;
    @Column(name = "CIN_ST_CODIGO")
    private String cinStCodigo;
    @Column(name = "EDP_ST_RESULTADO")
    private String edpStResultado;
    @Column(name = "EDP_ST_TIPO")
    private String edpStTipo;
    @Column(name = "EDP_ST_GRUPO")
    private String edpStGrupo;
    @Column(name = "EDP_ST_MATERIAL")
    private String edpStMaterial;
    @Column(name = "GRP_ST_CODIGO")
    private String grpStcodigo;
    @Column(name = "DEP_ST_CODIGO")
    private String depStCodigo;
    @Column(name = "EDP_IN_ORDEM")
    private String edpInOrdem;
    @Column(name = "EDP_ST_SETOR")
    private String edpStSetor;

    public LabExameDepara() {
    }

    public LabExameDepara(LabExameDeparaPK labExameDeparaPK) {
        this.labExameDeparaPK = labExameDeparaPK;
    }

    public LabExameDepara(LabExameDeparaPK labExameDeparaPK, String cinStCodigo, String edpStResultado, String edpStTipo, String edpStGrupo, String edpStMaterial, String grpStcodigo, String depStCodigo, String edpInOrdem, String edpStSetor) {
        this.labExameDeparaPK = labExameDeparaPK;
        this.cinStCodigo = cinStCodigo;
        this.edpStResultado = edpStResultado;
        this.edpStTipo = edpStTipo;
        this.edpStGrupo = edpStGrupo;
        this.edpStMaterial = edpStMaterial;
        this.grpStcodigo = grpStcodigo;
        this.depStCodigo = depStCodigo;
        this.edpInOrdem = edpInOrdem;
        this.edpStSetor = edpStSetor;
    }

    public LabExameDeparaPK getLabExameDeparaPK() {
        return labExameDeparaPK;
    }

    public void setLabExameDeparaPK(LabExameDeparaPK labExameDeparaPK) {
        this.labExameDeparaPK = labExameDeparaPK;
    }

    public String getCinStCodigo() {
        return cinStCodigo;
    }

    public void setCinStCodigo(String cinStCodigo) {
        this.cinStCodigo = cinStCodigo;
    }

    public String getEdpStResultado() {
        return edpStResultado;
    }

    public void setEdpStResultado(String edpStResultado) {
        this.edpStResultado = edpStResultado;
    }

    public String getEdpStTipo() {
        return edpStTipo;
    }

    public void setEdpStTipo(String edpStTipo) {
        this.edpStTipo = edpStTipo;
    }

    public String getEdpStGrupo() {
        return edpStGrupo;
    }

    public void setEdpStGrupo(String edpStGrupo) {
        this.edpStGrupo = edpStGrupo;
    }

    public String getEdpStMaterial() {
        return edpStMaterial;
    }

    public void setEdpStMaterial(String edpStMaterial) {
        this.edpStMaterial = edpStMaterial;
    }

    public String getGrpStcodigo() {
        return grpStcodigo;
    }

    public void setGrpStcodigo(String grpStcodigo) {
        this.grpStcodigo = grpStcodigo;
    }

    public String getDepStCodigo() {
        return depStCodigo;
    }

    public void setDepStCodigo(String depStCodigo) {
        this.depStCodigo = depStCodigo;
    }

    public String getEdpInOrdem() {
        return edpInOrdem;
    }

    public void setEdpInOrdem(String edpInOrdem) {
        this.edpInOrdem = edpInOrdem;
    }

    public String getEdpStSetor() {
        return edpStSetor;
    }

    public void setEdpStSetor(String edpStSetor) {
        this.edpStSetor = edpStSetor;
    }

    @Override
    public String toString() {
        return "LabExameDepara{" + "labExameDeparaPK=" + labExameDeparaPK + ", cinStCodigo=" + cinStCodigo + ", edpStResultado=" + edpStResultado + ", edpStTipo=" + edpStTipo + ", edpStGrupo=" + edpStGrupo + ", edpStMaterial=" + edpStMaterial + ", grpStcodigo=" + grpStcodigo + ", depStCodigo=" + depStCodigo + ", edpInOrdem=" + edpInOrdem + ", edpStSetor=" + edpStSetor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.labExameDeparaPK != null ? this.labExameDeparaPK.hashCode() : 0);
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
        final LabExameDepara other = (LabExameDepara) obj;
        if (this.labExameDeparaPK != other.labExameDeparaPK && (this.labExameDeparaPK == null || !this.labExameDeparaPK.equals(other.labExameDeparaPK))) {
            return false;
        }
        return true;
    }
}
