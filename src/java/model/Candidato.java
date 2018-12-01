package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CANDIDATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByNumcandidato", query = "SELECT c FROM Candidato c WHERE c.numcandidato = :numcandidato")
    , @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Candidato.findByVice", query = "SELECT c FROM Candidato c WHERE c.vice = :vice")
    , @NamedQuery(name = "Candidato.findByPartido", query = "SELECT c FROM Candidato c WHERE c.partido = :partido")
    , @NamedQuery(name = "Candidato.findBySlogan", query = "SELECT c FROM Candidato c WHERE c.slogan = :slogan")
    , @NamedQuery(name = "Candidato.findByVotos", query = "SELECT c FROM Candidato c WHERE c.votos = :votos")
    , @NamedQuery(name = "Candidato.findByImagem", query = "SELECT c FROM Candidato c WHERE c.imagem = :imagem")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCANDIDATO")
    private Integer numcandidato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "VICE")
    private String vice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PARTIDO")
    private String partido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "SLOGAN")
    private String slogan;
    @Column(name = "VOTOS")
    private Integer votos;
    @Size(max = 80)
    @Column(name = "IMAGEM")
    private String imagem;

    public Candidato() {
    }

    public Candidato(Integer numcandidato) {
        this.numcandidato = numcandidato;
    }

    public Candidato(Integer numcandidato, String nome, String vice, String partido, String slogan) {
        this.numcandidato = numcandidato;
        this.nome = nome;
        this.vice = vice;
        this.partido = partido;
        this.slogan = slogan;
    }

    public Integer getNumcandidato() {
        return numcandidato;
    }

    public void setNumcandidato(Integer numcandidato) {
        this.numcandidato = numcandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVice() {
        return vice;
    }

    public void setVice(String vice) {
        this.vice = vice;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcandidato != null ? numcandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.numcandidato == null && other.numcandidato != null) || (this.numcandidato != null && !this.numcandidato.equals(other.numcandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Candidato[ numcandidato=" + numcandidato + " ]";
    }

}
