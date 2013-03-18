package br.com.dasa.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos Naves
 */

@Entity
@Table(name="lab_unidadedepara")
public class LabUnidadeDePara implements Serializable{
    
    @Id
    @Column(name="sis_st_codigo")
    private String sisStCodigo;
    private String uniStCodigo;
    private String udpStCodigo;
    private String oriStCodigo;
    private String udpStDescricao;
    

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }
    
}
