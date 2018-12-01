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
@Table(name = "ELEITOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleitor.findAll", query = "SELECT e FROM Eleitor e")
    , @NamedQuery(name = "Eleitor.findByTituloeleitor", query = "SELECT e FROM Eleitor e WHERE e.tituloeleitor = :tituloeleitor")
    , @NamedQuery(name = "Eleitor.findByNome", query = "SELECT e FROM Eleitor e WHERE e.nome = :nome")
    , @NamedQuery(name = "Eleitor.findByCpf", query = "SELECT e FROM Eleitor e WHERE e.cpf = :cpf")
    , @NamedQuery(name = "Eleitor.findBySenha", query = "SELECT e FROM Eleitor e WHERE e.senha = :senha")
    , @NamedQuery(name = "Eleitor.findByStep", query = "SELECT e FROM Eleitor e WHERE e.step = :step")})
public class Eleitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TITULOELEITOR")
    private Integer tituloeleitor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "STEP")
    private Integer step;

    public Eleitor() {
    }

    public Eleitor(Integer tituloeleitor) {
        this.tituloeleitor = tituloeleitor;
    }

    public Eleitor(Integer tituloeleitor, String nome, String cpf, String senha) {
        this.tituloeleitor = tituloeleitor;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Integer getTituloeleitor() {
        return tituloeleitor;
    }

    public void setTituloeleitor(Integer tituloeleitor) {
        this.tituloeleitor = tituloeleitor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tituloeleitor != null ? tituloeleitor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleitor)) {
            return false;
        }
        Eleitor other = (Eleitor) object;
        if ((this.tituloeleitor == null && other.tituloeleitor != null) || (this.tituloeleitor != null && !this.tituloeleitor.equals(other.tituloeleitor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Eleitor[ tituloeleitor=" + tituloeleitor + " ]";
    }

}
