package bean;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {

    private boolean candidatosPane = true;
    private boolean votarPane = false;
    private boolean apuracaoPane = false;

    private int step;

    public HomeBean() {
    }

    public void nextStep() {
        step++;
    }

    public void turnOnCandidatosPane() {
        candidatosPane = true;
        votarPane = false;
        apuracaoPane = false;
    }

    public void turnOnVotarPane() {
        candidatosPane = false;
        votarPane = true;
        apuracaoPane = false;
    }

    public void turnOnApuracaoPane() {
        candidatosPane = false;
        votarPane = false;
        apuracaoPane = true;
    }
    public boolean isVotarPane() {
        return votarPane;
    }

    public void setVotarPane(boolean votarPane) {
        this.votarPane = votarPane;
    }

    public boolean isApuracaoPane() {
        return apuracaoPane;
    }

    public void setApuracaoPane(boolean apuracaoPane) {
        this.apuracaoPane = apuracaoPane;
    }

    public boolean isCandidatosPane() {
        return candidatosPane;
    }

    public void setCandidatosPane(boolean candidatosPane) {
        this.candidatosPane = candidatosPane;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
