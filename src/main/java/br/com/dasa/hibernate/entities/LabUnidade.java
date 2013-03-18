/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dasa.hibernate.entities;

import br.com.dasa.hibernate.utils.OracleHelper;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_UNIDADE")
public class LabUnidade implements Serializable {

    @Id
    @Column(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String uniStCodigo;
    
    
    @Column(name="UNI_ST_DESCRICAO")
    private String uniStDescricao;
    @Column(name="UNI_CH_TELEFONE")
    private char uniStTelefone;
    @Column(name="UNI_ST_SISTEMA")
    private String uniStSistema;
    
    @Column(name="UNI_CH_USASEMENTE")
    private Character uniChUsaSemente;


    @OneToMany(mappedBy="uniStCodigo")
    private List<LabUsuario> uniListLabUsuario;

//    @OneToMany(mappedBy="oriStCodigo",fetch= FetchType.EAGER)
//    @Fetch(FetchMode.JOIN)
    





//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPaciente;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabLocal> listLabLocal;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabOrigem> listLabOrigem;


//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabPaciente> listLabPaciente;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabRegras> listLabRegras;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabSistema> listLabSistema;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabUsuario> listLabUsuario;
    
    
    @Transient
    private boolean blSelected = false;
    
    
//    @Transient
//    private List<LabOrigem> listLabOrigem;
//    
//    @Transient
//    private List<LabLocal> listLabLocal;
//    
//    @Transient
//    private List<LabSetor> listLabSetor;
    
    
    
    @Transient
    private String strDbName;

    public LabUnidade() {
    }

    public LabUnidade(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public LabUnidade(String uniStCodigo, String uniStDescricao) {
        this.uniStCodigo = uniStCodigo;
        this.uniStDescricao = uniStDescricao;
    }

    
    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }
    
    

    
    
    



//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabAgenda> listLabAgenda;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabColetor> listLabColetor;
    
//    public List<LabUsuario> getListLabUsuario() {
//        return listLabUsuario;
//    }
//
//    public void setListLabUsuario(List<LabUsuario> listLabUsuario) {
//        this.listLabUsuario = listLabUsuario;
//    }


   

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUniStDescricao() {
        return uniStDescricao;
    }

    public void setUniStDescricao(String uniStDescricao) {
        this.uniStDescricao = uniStDescricao;
    }

    public String getUniStSistema() {
        return uniStSistema;
    }

    public void setUniStSistema(String uniStSistema) {
        this.uniStSistema = uniStSistema;
    }

    public char getUniStTelefone() {
        return uniStTelefone;
    }

    public void setUniStTelefone(char uniStTelefone) {
        this.uniStTelefone = uniStTelefone;
    }

    public List<LabUsuario> getUniListLabUsuario() {
        return uniListLabUsuario;
    }

    public void setUniListLabUsuario(List<LabUsuario> uniListLabUsuario) {
        this.uniListLabUsuario = uniListLabUsuario;
    }

    @Transient
    public boolean isBlSelected() {
        return blSelected;
    }

    public void setBlSelected(boolean blSelected) {
        this.blSelected = blSelected;
    }
    
    
    
    
    
    @Transient
    public String getUniStDescricaoResumida(){
        if(this.uniStDescricao != null && uniStDescricao.length()>13){
            return  uniStDescricao.substring(0, 10)+"...";
        }else{
            return  uniStDescricao;
        }

    }
    
    @Transient
    public String getUniStDescricaoResumida7(){
        if(this.uniStDescricao != null && uniStDescricao.length()>7){
            return  uniStDescricao.substring(0, 4)+"...";
        }else{
            return  uniStDescricao;
        }

    }

    
//    @Transient
//    public List<LabOrigem> getListLabOrigem() {
//        if(listLabOrigem == null  && strDbName != null ){
//            listLabOrigem =   (List<LabOrigem>) OracleHelper.getListOfObjectByKeyEq(LabOrigem.class, "uniStCodigo", this.uniStCodigo, "oriStCodigo", true,strDbName);//TODO properlly solve multi dbs
//        }
//        return listLabOrigem;
//    }

    
    
//    @Transient
//    public List<LabLocal> getListLabLocal() {
//        if(listLabLocal == null && strDbName != null ){
//           listLabLocal =  (List<LabLocal>) OracleHelper.getListOfObjectByKeyEq(LabLocal.class, "uniStCodigo", this.uniStCodigo, "locStCodigo", true,strDbName);//TODO properlly solve multi dbs
//        }
//                return listLabLocal;
//    }

//    @Transient
//    public List<LabSetor> getListLabSetor() {
//        if(listLabSetor ==  null  && strDbName != null){
//            listLabSetor = (List<LabSetor>) OracleHelper.getListOfObjectByKeyEq(LabSetor.class, "uniStCodigo", this.uniStCodigo, "setStCodigo", true,strDbName);////TODO properlly solve multi dbs
//        }
//        return listLabSetor;
//    }

    public Character getUniChUsaSemente() {
        return uniChUsaSemente;
    }

    public void setUniChUsaSemente(Character uniChUsaSemente) {
        this.uniChUsaSemente = uniChUsaSemente;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUnidade other = (LabUnidade) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return uniStDescricao ;
    }

    
    
    
    

}
