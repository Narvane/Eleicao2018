package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "VOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v")
    , @NamedQuery(name = "Voto.findByIdcargo", query = "SELECT v FROM Voto v WHERE v.votoPK.idcargo = :idcargo")
    , @NamedQuery(name = "Voto.findByNumcandidato", query = "SELECT v FROM Voto v WHERE v.votoPK.numcandidato = :numcandidato")})
public class Voto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotoPK votoPK;

    public Voto() {
    }

    public Voto(VotoPK votoPK) {
        this.votoPK = votoPK;
    }

    public Voto(int idcargo, int numcandidato) {
        this.votoPK = new VotoPK(idcargo, numcandidato);
    }

    public VotoPK getVotoPK() {
        return votoPK;
    }

    public void setVotoPK(VotoPK votoPK) {
        this.votoPK = votoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votoPK != null ? votoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.votoPK == null && other.votoPK != null) || (this.votoPK != null && !this.votoPK.equals(other.votoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Voto[ votoPK=" + votoPK + " ]";
    }

}
