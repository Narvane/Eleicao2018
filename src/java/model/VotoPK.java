package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class VotoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCARGO")
    private int idcargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCANDIDATO")
    private int numcandidato;

    public VotoPK() {
    }

    public VotoPK(int idcargo, int numcandidato) {
        this.idcargo = idcargo;
        this.numcandidato = numcandidato;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public int getNumcandidato() {
        return numcandidato;
    }

    public void setNumcandidato(int numcandidato) {
        this.numcandidato = numcandidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcargo;
        hash += (int) numcandidato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotoPK)) {
            return false;
        }
        VotoPK other = (VotoPK) object;
        if (this.idcargo != other.idcargo) {
            return false;
        }
        if (this.numcandidato != other.numcandidato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VotoPK[ idcargo=" + idcargo + ", numcandidato=" + numcandidato + " ]";
    }

}
