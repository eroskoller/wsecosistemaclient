/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dasa.hibernate.entities;


import br.com.dasa.hibernate.utils.OracleHelper;
//import br.com.utils.shared.RelatorioItens;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Temporal;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_REQUISICAO")
public class LabRequisicao implements Serializable, Comparable{


    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_IN_CODIGO")
    private Long reqInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "REQ_ST_CODIGO")
    private String reqStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 5)
    @Column(name = "CON_ST_CODIGO")
    private String conStCodigo;
    @Size(max = 10)
    @Column(name = "REG_ST_CODIGO")
    private String regStCodigo;
    @Column(name = "PAC_IN_CODIGO")
    private Long pacInCodigo;
    @Size(max = 6)
    @Column(name = "CID_ST_CODIGO")
    private String cidStCodigo;
    @Size(max = 2)
    @Column(name = "SOL_ST_ESTADO")
    private String solStEstado;
    @Size(max = 3)
    @Column(name = "PRO_ST_CODIGO")
    private String proStCodigo;
    @Size(max = 10)
    @Column(name = "SOL_ST_CODIGO")
    private String solStCodigo;
    @Column(name = "REQ_DT_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtCadastro;
    @Column(name = "REQ_HR_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqHrCadastro;
    @Size(max = 20)
    @Column(name = "REQ_ST_GUIA")
    private String reqStGuia;
    @Size(max = 30)
    @Column(name = "REQ_ST_MATRICULA")
    private String reqStMatricula;
    @Column(name = "REQ_DT_VALIDADECART")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtValidadeCart;
    @Size(max = 10)
    @Column(name = "REQ_ST_QUARTO")
    private String reqStQuarto;
    @Size(max = 10)
    @Column(name = "REQ_ST_LEITO")
    private String reqStLeito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_CH_PRECADASTRO")
    private Character reqChPrecadastro;
    @Size(max = 20)
    @Column(name = "REQ_ST_DUM")
    private String reqStDUM;
    @Size(max = 10)
    @Column(name = "COL_ST_CODIGO")
    private String colStCodigo;
    @Size(max = 10)
    @Column(name = "LOC_ST_CODIGO")
    private String locStCodigo;
    @Size(max = 3)
    @Column(name = "LEG_ST_CODIGO")
    private String legStCodigo;
    @Column(name = "REQ_IN_FLAG")
    private Long reqInFlag;
    @Column(name = "REQ_CH_ETIQUETA")
    private Character reqChEtiqueta;
    @Size(max = 5)
    @Column(name = "REQ_ST_PESO")
    private String reqStPeso;
    @Size(max = 5)
    @Column(name = "REQ_ST_ALTURA")
    private String reqStAltura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_DT_FATURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtFatura;
    @Column(name = "REQ_DT_ETIQUETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtEtiqueta;
    @Column(name = "REQ_HR_ETIQUETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqHrEtiqueta;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGOETIQUETA")
    private String usuStCodigoEtiqueta;
    @Size(max = 4000)
    @Column(name = "REQ_BL_OBSMEDICAMENTO")
    private String reqBlObsMedicamento;
    @Size(max = 4000)
    @Column(name = "REQ_BL_OBSHD")
    private String reqBlObsHD;
    @Size(max = 4000)
    @Column(name = "REQ_BL_OBSERVACAO")
    private String reqBlObservacao;
    @Size(max = 20)
    @Column(name = "REQ_ST_CODIGOALT")
    private String reqStCodigoAlt;
    @Column(name = "REQ_CH_ENVIADO")
    private Character reqChEnviado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "LEG_ST_CODIGOFAT")
    private String legStCodigoFat;
     
    @Column(name = "REQ_CH_URGENTE")
    private Character reqChUrgente;
    @Column(name = "REQ_CH_NOVO")
    private Character reqChNovo;
    @Column(name = "REQ_DT_ASSINATURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtAssinatura;
    @Column(name = "REQ_DT_TRIAGEM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtTriagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_CH_RN")
    private Character reqChRN;
    @Column(name = "REQ_IN_VIASIMPRESSAS")
    private Integer reqInViasImpressas;
    @Column(name = "REQ_CH_AGENDADO")
    private Character reqChAgendado;
    @Size(max = 20)
    @Column(name = "REQ_ST_CODIGOTESTE")
    private String reqStCodigoTeste;
    @Column(name = "REQ_DT_COLETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtColeta;
    @Column(name = "REQ_HR_COLETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqHrColeta;
    @Column(name = "REQ_DT_IMPRESSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtImpressao;
    @Column(name = "REQ_CH_OCORRENCIA")
    private Character reqChOcorrencia;
    @Column(name = "REQ_CH_GESTANTE")
    private Character reqChGestante;
    @Column(name = "REQ_CH_ESPECIAL")
    private Character reqChEspecial;
    @Size(max = 20)
    @Column(name = "REQ_ST_CODIGOLIS")
    private String reqStCodigoLis;
    @Column(name = "REQ_IN_ENVIOLIS")
    private Integer reqInEnvioLis;
    @Column(name = "ALO_IN_CODIGO")
    private Long aloInCodigo;
    @Column(name = "REQ_CH_ATENDIDO")
    private Character reqChAtendido;
    @Column(name = "REQ_CH_CHAMADO")
    private Character reqChChamado;
    @Column(name = "REQ_HR_CHAMADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqHrChamado;
    @Column(name = "REQ_HR_ATENDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqHrAtendido;
    @Column(name = "AGP_IN_CODIGO")
    private Long agpInCodigo;
    @Size(max = 20)
    @Column(name = "REQ_ST_CODBENEF")
    private String reqStCodBenef;
    @Column(name = "REQ_CH_RECEBIDOPARTICULAR")
    private Character reqChRecebidoparticular;
    @Column(name = "RPA_IN_CODIGO")
    private Long rpaInCodigo;
    @Size(max = 30)
    @Column(name = "REQ_ST_LOCALCOLETA")
    private String reqStLocalColeta;
    @Column(name = "REQ_CH_RESTRICAO")
    private Character reqChRestricao;
    @Column(name = "REQ_CH_IMAGEM")
    private Character reqChImagem;
    @Column(name = "REQ_CH_CD")
    private Character reqChCd;
    @Column(name = "REQ_CH_LAUDORECEBIDO")
    private Character reqChLaudorecebido;
    @Column(name = "MRE_IN_CODIGO")
    private Long mreInCodigo;
    @Column(name = "REQ_CH_IMAGE")
    private Character reqChImage;
    @Column(name = "VCA_IN_CODIGO")
    private Long vcaInCodigo;
    @Column(name = "REQ_DT_LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDtLastupdate;
    @Size(max = 255)
    @Column(name = "REQ_BL_INFOAUXILIAR")
    private String reqBlInfoAux;
    
    
    @OneToMany(mappedBy="reqInCodigo")
//    @Transient
    private List<LabDetalheRequisicao> listLabDetalheRequisicao;
    
    

    @Transient
    private boolean salvoNoDb= false;
    
    
    
    @Transient
    private String strDbName;

    public LabRequisicao() {
    }

    public LabRequisicao(Long reqInCodigo, String reqStCodigo) {
        this.reqInCodigo = reqInCodigo;
        this.reqStCodigo = reqStCodigo;
    }

    public LabRequisicao(Long reqInCodigo, String reqStCodigo, String uniStCodigo, Long pacInCodigo, Date reqDtCadastro, Date reqHrCadastro) {
        this.reqInCodigo = reqInCodigo;
        this.reqStCodigo = reqStCodigo;
        this.uniStCodigo = uniStCodigo;
        this.pacInCodigo = pacInCodigo;
        this.reqDtCadastro = reqDtCadastro;
        this.reqHrCadastro = reqHrCadastro;
    }
    
      
    public Character getReqChImage() {
        return reqChImage;
    }

    public void setReqChImage(Character reqChImage) {
        this.reqChImage = reqChImage;
    }

    public boolean isSalvoNoDb() {
        return salvoNoDb;
    }

    public void setSalvoNoDb(boolean salvoNoDb) {
        this.salvoNoDb = salvoNoDb;
    }


    public String getReqStLocalColeta() {
        return reqStLocalColeta;
    }

    public void setReqStLocalColeta(String reqStLocalColeta) {
        this.reqStLocalColeta = reqStLocalColeta;
    }

    
    
    public Long getMreInCodigo() {
        return mreInCodigo;
    }

    public void setMreInCodigo(Long mreInCodigo) {
        this.mreInCodigo = mreInCodigo;
    }

    
    @Transient
    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }

    public String getReqBlInfoAux() {
        return reqBlInfoAux;
    }

    public void setReqBlInfoAux(String reqBlInfoAux) {
        this.reqBlInfoAux = reqBlInfoAux;
    }
    
    
    public String getColStCodigo() {
        return colStCodigo;
    }

    public void setColStCodigo(String colStCodigo) {
        this.colStCodigo = colStCodigo;
    }



    public String getCidStCodigo() {
        return cidStCodigo;
    }

    public void setCidStCodigo(String cidStCodigo) {
        this.cidStCodigo = cidStCodigo;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }
    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
    }

    public String getProStCodigo() {
        return proStCodigo;
    }

    public void setProStCodigo(String proStCodigo) {
        this.proStCodigo = proStCodigo;
    }


    public List<LabDetalheRequisicao> getListLabDetalheRequisicao() {
        return listLabDetalheRequisicao;
    }

    public void setListLabDetalheRequisicao(List<LabDetalheRequisicao> listLabDetalheRequisicao) {
        this.listLabDetalheRequisicao = listLabDetalheRequisicao;
    }

    
    
    
//    @Transient
//    public String getListTextExames(){
//        StringBuilder sb = new StringBuilder();
//        if(listLabDetalheRequisicaoFiltrado != null && listLabDetalheRequisicaoFiltrado.size()>0){
//            boolean bltIghterText = false;
//            for(int i = 0 ; i < listLabDetalheRequisicaoFiltrado.size(); i ++){
//                LabDetalheRequisicao ldr = listLabDetalheRequisicaoFiltrado.get(i);
//                bltIghterText = listLabDetalheRequisicaoFiltrado.size() > 17 ?  true : false; 
//                sb.append(ldr.getExaStCodigo())
//                        .append(RelatorioItens.getMapLegResumido().get(ldr.getLegStCodigo()));
//                
//                if(bltIghterText){
//                    if(i < listLabDetalheRequisicaoFiltrado.size()-1){sb.append(", ");}
//                }else{
//                    if(i < listLabDetalheRequisicaoFiltrado.size()-1){sb.append(" , ");}
//                }
//                
//                
//            }
//        }
//        return sb.toString();
//    }
    
    public Long getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(Long aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    public String getLegStCodigo() {
        return legStCodigo;
    }

    public void setLegStCodigo(String legStCodigo) {
        this.legStCodigo = legStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    

    public String getLegStCodigoFat() {
        return legStCodigoFat;
    }

    public void setLegStCodigoFat(String legStCodigoFat) {
        this.legStCodigoFat = legStCodigoFat;
    }

    public Long getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(Long pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public Date getReqHrAtendido() {
        return reqHrAtendido;
    }

    public void setReqHrAtendido(Date reqHrAtendido) {
        this.reqHrAtendido = reqHrAtendido;
    }


    

    public String getReqBlObsHD() {
        return reqBlObsHD;
    }

    public void setReqBlObsHD(String reqBlObsHD) {
        this.reqBlObsHD = reqBlObsHD;
    }

    public String getReqBlObsMedicamento() {
        return reqBlObsMedicamento;
    }

    public void setReqBlObsMedicamento(String reqBlObsMedicamento) {
        this.reqBlObsMedicamento = reqBlObsMedicamento;
    }

    public String getReqBlObservacao() {
        return reqBlObservacao;
    }

    public void setReqBlObservacao(String reqBlObservacao) {
        this.reqBlObservacao = reqBlObservacao;
    }

    public Character getReqChAgendado() {
        return reqChAgendado;
    }

    public void setReqChAgendado(Character reqChAgendado) {
        this.reqChAgendado = reqChAgendado;
    }

    public Character getReqChAtendido() {
        return reqChAtendido;
    }

    public void setReqChAtendido(Character reqChAtendido) {
        this.reqChAtendido = reqChAtendido;
    }

    public Character getReqChChamado() {
        return reqChChamado;
    }

    public void setReqChChamado(Character reqChChamado) {
        this.reqChChamado = reqChChamado;
    }

    public Character getReqChEnviado() {
        return reqChEnviado;
    }

    public void setReqChEnviado(Character reqChEnviado) {
        this.reqChEnviado = reqChEnviado;
    }

    public Character getReqChEspecial() {
        return reqChEspecial;
    }

    public void setReqChEspecial(Character reqChEspecial) {
        this.reqChEspecial = reqChEspecial;
    }

    public Character getReqChEtiqueta() {
        return reqChEtiqueta;
    }

    public void setReqChEtiqueta(Character reqChEtiqueta) {
        this.reqChEtiqueta = reqChEtiqueta;
    }

    public Character getReqChGestante() {
        return reqChGestante;
    }

    public void setReqChGestante(Character reqChGestante) {
        this.reqChGestante = reqChGestante;
    }

    public Character getReqChNovo() {
        return reqChNovo;
    }

    public void setReqChNovo(Character reqChNovo) {
        this.reqChNovo = reqChNovo;
    }

    public Character getReqChOcorrencia() {
        return reqChOcorrencia;
    }

    public void setReqChOcorrencia(Character reqChOcorrencia) {
        this.reqChOcorrencia = reqChOcorrencia;
    }

    public Character getReqChPrecadastro() {
        return reqChPrecadastro;
    }

    public void setReqChPrecadastro(Character reqChPrecadastro) {
        this.reqChPrecadastro = reqChPrecadastro;
    }

    public Character getReqChRN() {
        return reqChRN;
    }

    public void setReqChRN(Character reqChRN) {
        this.reqChRN = reqChRN;
    }

    public Character getReqChUrgente() {
        return reqChUrgente;
    }

    public void setReqChUrgente(Character reqChUrgente) {
        this.reqChUrgente = reqChUrgente;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

 

    public Date getReqDtAssinatura() {
        return reqDtAssinatura;
    }

    public void setReqDtAssinatura(Date reqDtAssinatura) {
        this.reqDtAssinatura = reqDtAssinatura;
    }

    public Date getReqDtCadastro() {
        return reqDtCadastro;
    }

    public void setReqDtCadastro(Date reqDtCadastro) {
        this.reqDtCadastro = reqDtCadastro;
    }

    public Date getReqDtColeta() {
        return reqDtColeta;
    }

    public void setReqDtColeta(Date reqDtColeta) {
        this.reqDtColeta = reqDtColeta;
    }

    public Date getReqDtEtiqueta() {
        return reqDtEtiqueta;
    }

    public void setReqDtEtiqueta(Date reqDtEtiqueta) {
        this.reqDtEtiqueta = reqDtEtiqueta;
    }

    public Date getReqDtFatura() {
        return reqDtFatura;
    }

    public void setReqDtFatura(Date reqDtFatura) {
        this.reqDtFatura = reqDtFatura;
    }

    public Date getReqDtImpressao() {
        return reqDtImpressao;
    }

    public void setReqDtImpressao(Date reqDtImpressao) {
        this.reqDtImpressao = reqDtImpressao;
    }

    public Date getReqDtTriagem() {
        return reqDtTriagem;
    }

    public void setReqDtTriagem(Date reqDtTriagem) {
        this.reqDtTriagem = reqDtTriagem;
    }

    public Date getReqDtValidadeCart() {
        return reqDtValidadeCart;
    }

    public void setReqDtValidadeCart(Date reqDtValidadeCart) {
        this.reqDtValidadeCart = reqDtValidadeCart;
    }

    public Date getReqHrCadastro() {
        return reqHrCadastro;
    }

    public void setReqHrCadastro(Date reqHrCadastro) {
        this.reqHrCadastro = reqHrCadastro;
    }

 
    public Date getReqHrColeta() {
        return reqHrColeta;
    }

    public void setReqHrColeta(Date reqHrColeta) {
        this.reqHrColeta = reqHrColeta;
    }

    public Date getReqHrEtiqueta() {
        return reqHrEtiqueta;
    }

    public void setReqHrEtiqueta(Date reqHrEtiqueta) {
        this.reqHrEtiqueta = reqHrEtiqueta;
    }

    public Long getReqInCodigo() {
        return reqInCodigo;
    }

    public void setReqInCodigo(Long reqInCodigo) {
        this.reqInCodigo = reqInCodigo;
    }

    public Integer getReqInEnvioLis() {
        return reqInEnvioLis;
    }

    public void setReqInEnvioLis(Integer reqInEnvioLis) {
        this.reqInEnvioLis = reqInEnvioLis;
    }

    public Integer getReqInViasImpressas() {
        return reqInViasImpressas;
    }

    public void setReqInViasImpressas(Integer reqInViasImpressas) {
        this.reqInViasImpressas = reqInViasImpressas;
    }

    public String getReqStAltura() {
        return reqStAltura;
    }

    public void setReqStAltura(String reqStAltura) {
        this.reqStAltura = reqStAltura;
    }

    public String getReqStCodBenef() {
        return reqStCodBenef;
    }

    public void setReqStCodBenef(String reqStCodBenef) {
        this.reqStCodBenef = reqStCodBenef;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    public String getReqStCodigoAlt() {
        return reqStCodigoAlt;
    }

    public void setReqStCodigoAlt(String reqStCodigoAlt) {
        this.reqStCodigoAlt = reqStCodigoAlt;
    }

    public String getReqStCodigoLis() {
        return reqStCodigoLis;
    }

    public void setReqStCodigoLis(String reqStCodigoLis) {
        this.reqStCodigoLis = reqStCodigoLis;
    }

    public String getReqStCodigoTeste() {
        return reqStCodigoTeste;
    }

    public void setReqStCodigoTeste(String reqStCodigoTeste) {
        this.reqStCodigoTeste = reqStCodigoTeste;
    }

    public String getReqStDUM() {
        return reqStDUM;
    }

    public void setReqStDUM(String reqStDUM) {
        this.reqStDUM = reqStDUM;
    }

    public String getReqStGuia() {
        return reqStGuia;
    }

    public void setReqStGuia(String reqStGuia) {
        this.reqStGuia = reqStGuia;
    }

    public String getReqStLeito() {
        return reqStLeito;
    }

    public void setReqStLeito(String reqStLeito) {
        this.reqStLeito = reqStLeito;
    }

    public String getReqStMatricula() {
        return reqStMatricula;
    }

    public void setReqStMatricula(String reqStMatricula) {
        this.reqStMatricula = reqStMatricula;
    }

    public String getReqStPeso() {
        return reqStPeso;
    }

    public void setReqStPeso(String reqStPeso) {
        this.reqStPeso = reqStPeso;
    }

    public String getReqStQuarto() {
        return reqStQuarto;
    }

    public void setReqStQuarto(String reqStQuarto) {
        this.reqStQuarto = reqStQuarto;
    }

    public String getSolStCodigo() {
        return solStCodigo;
    }

    public void setSolStCodigo(String solStCodigo) {
        this.solStCodigo = solStCodigo;
    }

    public String getUsuStCodigoEtiqueta() {
        return usuStCodigoEtiqueta;
    }

    public void setUsuStCodigoEtiqueta(String usuStCodigoEtiqueta) {
        this.usuStCodigoEtiqueta = usuStCodigoEtiqueta;
    }

    public String getSolStEstado() {
        return solStEstado;
    }

    public void setSolStEstado(String solStEstado) {
        this.solStEstado = solStEstado;
    }

    

    public Long getReqInFlag() {
        return reqInFlag;
    }

    public void setReqInFlag(Long reqInFlag) {
        this.reqInFlag = reqInFlag;
    }

    public Date getReqHrChamado() {
        return reqHrChamado;
    }

    public void setReqHrChamado(Date reqHrChamado) {
        this.reqHrChamado = reqHrChamado;
    }

    public Long getAgpInCodigo() {
        return agpInCodigo;
    }

    public void setAgpInCodigo(Long agpInCodigo) {
        this.agpInCodigo = agpInCodigo;
    }

    public Character getReqChRecebidoparticular() {
        return reqChRecebidoparticular;
    }

    public void setReqChRecebidoparticular(Character reqChRecebidoparticular) {
        this.reqChRecebidoparticular = reqChRecebidoparticular;
    }

    public Long getRpaInCodigo() {
        return rpaInCodigo;
    }

    public void setRpaInCodigo(Long rpaInCodigo) {
        this.rpaInCodigo = rpaInCodigo;
    }

    public Character getReqChRestricao() {
        return reqChRestricao;
    }

    public void setReqChRestricao(Character reqChRestricao) {
        this.reqChRestricao = reqChRestricao;
    }

    public Character getReqChImagem() {
        return reqChImagem;
    }

    public void setReqChImagem(Character reqChImagem) {
        this.reqChImagem = reqChImagem;
    }

    public Character getReqChCd() {
        return reqChCd;
    }

    public void setReqChCd(Character reqChCd) {
        this.reqChCd = reqChCd;
    }

    public Character getReqChLaudorecebido() {
        return reqChLaudorecebido;
    }

    public void setReqChLaudorecebido(Character reqChLaudorecebido) {
        this.reqChLaudorecebido = reqChLaudorecebido;
    }

    public Long getVcaInCodigo() {
        return vcaInCodigo;
    }

    public void setVcaInCodigo(Long vcaInCodigo) {
        this.vcaInCodigo = vcaInCodigo;
    }

    public Date getReqDtLastupdate() {
        return reqDtLastupdate;
    }

    public void setReqDtLastupdate(Date reqDtLastupdate) {
        this.reqDtLastupdate = reqDtLastupdate;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabRequisicao other = (LabRequisicao) obj;
        if (this.reqInCodigo != other.reqInCodigo && (this.reqInCodigo == null || !this.reqInCodigo.equals(other.reqInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.reqInCodigo != null ? this.reqInCodigo.hashCode() : 0);
        return hash;
    }


    public static final Comparator NAME_COMPARATOR_A_Z = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getRegStCodigo();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getRegStCodigo();
            }

            if(string1 != null && string2 != null){
                return string1.compareTo(string2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator NAME_COMPARATOR_Z_A = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getRegStCodigo();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getRegStCodigo();
            }

            if(string1 != null && string2 != null){
                return string2.compareTo(string1);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator ID_UNIDADE_COMPARATOR_A_Z = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getUniStCodigo();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getUniStCodigo();
            }

            if(string1 != null && string2 != null){
                return string1.compareTo(string2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator ID_UNIDADE_COMPARATOR_Z_A = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getUniStCodigo();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getUniStCodigo();
            }

            if(string1 != null && string2 != null){
                return string2.compareTo(string1);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator DT_CADASTRO_COMPARATOR_0_1 = new Comparator() {
            Date data1;
            Date data2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                data1 = ((LabRequisicao)relObject).getReqDtCadastro();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                data2 = ((LabRequisicao)anotherRelObjec).getReqDtCadastro();
            }

            if(data1 != null && data2 != null){
                return data1.compareTo(data2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator DT_CADASTRO_COMPARATOR_1_0 = new Comparator() {
            Date data1;
            Date data2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                data1 = ((LabRequisicao)relObject).getReqDtCadastro();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                data2 = ((LabRequisicao)anotherRelObjec).getReqDtCadastro();
            }

            if(data1 != null && data2 != null){
                return data2.compareTo(data1);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator GUIA_COMPARATOR_0_1 = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getReqStGuia();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getReqStGuia();
            }

            if(string1 != null && string2 != null){
                return string1.compareTo(string2);
            }else{
                return 0;
            }
        }
     };
    public static final Comparator GUIA_COMPARATOR_1_0 = new Comparator() {
            String string1;
            String string2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRequisicao) {
                string1 = ((LabRequisicao)relObject).getReqStGuia();
            }

            if (anotherRelObjec instanceof LabRequisicao) {
                string2 = ((LabRequisicao)anotherRelObjec).getReqStGuia();
            }

            if(string1 != null && string2 != null){
                return string2.compareTo(string1);
            }else{
                return 0;
            }
        }
     };    
    
    @Override
    public int compareTo(Object o) {
        Long l1 = 0l;
        Long l2 = 1l;
        
        if(this.reqInCodigo != null){
            l1 = this.reqInCodigo;
        }
        if (o instanceof LabRequisicao) {
                l2 = ((LabRequisicao)o).getReqInCodigo();
        }
        
            
            if(l1 != null && l2 != null){
                return l1.compareTo(l2);
            }else{
                return 0;
            }
        
    }

    @Override
    public String toString() {
        return "LabRequisicao{" + "reqInCodigo=" + reqInCodigo + ", reqStCodigo=" + reqStCodigo + ", oriStCodigo=" + oriStCodigo + ", uniStCodigo=" + uniStCodigo + ", conStCodigo=" + conStCodigo + ", regStCodigo=" + regStCodigo + ", pacInCodigo=" + pacInCodigo + ", cidStCodigo=" + cidStCodigo + ", solStEstado=" + solStEstado + ", proStCodigo=" + proStCodigo + ", solStCodigo=" + solStCodigo + ", reqDtCadastro=" + reqDtCadastro + ", reqHrCadastro=" + reqHrCadastro + ", reqStGuia=" + reqStGuia + ", reqStMatricula=" + reqStMatricula + ", reqDtValidadeCart=" + reqDtValidadeCart + ", reqStQuarto=" + reqStQuarto + ", reqStLeito=" + reqStLeito + ", reqChPrecadastro=" + reqChPrecadastro + ", reqStDUM=" + reqStDUM + ", colStCodigo=" + colStCodigo + ", locStCodigo=" + locStCodigo + ", legStCodigo=" + legStCodigo + ", reqInFlag=" + reqInFlag + ", reqChEtiqueta=" + reqChEtiqueta + ", reqStPeso=" + reqStPeso + ", reqStAltura=" + reqStAltura + ", reqDtFatura=" + reqDtFatura + ", reqDtEtiqueta=" + reqDtEtiqueta + ", reqHrEtiqueta=" + reqHrEtiqueta + ", usuStCodigoEtiqueta=" + usuStCodigoEtiqueta + ", reqBlObsMedicamento=" + reqBlObsMedicamento + ", reqBlObsHD=" + reqBlObsHD + ", reqBlObservacao=" + reqBlObservacao + ", reqStCodigoAlt=" + reqStCodigoAlt + ", reqChEnviado=" + reqChEnviado + ", legStCodigoFat=" + legStCodigoFat + ", reqChUrgente=" + reqChUrgente + ", reqChNovo=" + reqChNovo + ", reqDtAssinatura=" + reqDtAssinatura + ", reqDtTriagem=" + reqDtTriagem + ", reqChRN=" + reqChRN + ", reqInViasImpressas=" + reqInViasImpressas + ", reqChAgendado=" + reqChAgendado + ", reqStCodigoTeste=" + reqStCodigoTeste + ", reqDtColeta=" + reqDtColeta + ", reqHrColeta=" + reqHrColeta + ", reqDtImpressao=" + reqDtImpressao + ", reqChOcorrencia=" + reqChOcorrencia + ", reqChGestante=" + reqChGestante + ", reqChEspecial=" + reqChEspecial + ", reqStCodigoLis=" + reqStCodigoLis + ", reqInEnvioLis=" + reqInEnvioLis + ", aloInCodigo=" + aloInCodigo + ", reqChAtendido=" + reqChAtendido + ", reqChChamado=" + reqChChamado + ", reqHrChamado=" + reqHrChamado + ", reqHrAtendido=" + reqHrAtendido + ", agpInCodigo=" + agpInCodigo + ", reqStCodBenef=" + reqStCodBenef + ", reqChRecebidoparticular=" + reqChRecebidoparticular + ", rpaInCodigo=" + rpaInCodigo + ", reqStLocalColeta=" + reqStLocalColeta + ", reqChRestricao=" + reqChRestricao + ", reqChImagem=" + reqChImagem + ", reqChCd=" + reqChCd + ", reqChLaudorecebido=" + reqChLaudorecebido + ", mreInCodigo=" + mreInCodigo + ", reqChImage=" + reqChImage + ", vcaInCodigo=" + vcaInCodigo + ", reqDtLastupdate=" + reqDtLastupdate + ", reqBlInfoAux=" + reqBlInfoAux + ", listLabDetalheRequisicao=" + listLabDetalheRequisicao + ", salvoNoDb=" + salvoNoDb + ", strDbName=" + strDbName + '}';
    }

}
