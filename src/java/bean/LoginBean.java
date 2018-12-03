package bean;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Eleitor;
import negocio.EleitorService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    EleitorService es = new EleitorService();

    private Integer titEleitor;
    private String senha;
    private String cfSenha;
    private String cpf;
    private String nome;

    private Boolean estaLogado = false;


    private String feedbackColor = "red";
    private String feedbackLogin = "";
    private String feedbackCadastro = "";

    public LoginBean() {
    }

    public String logar() {
        try {
            if (titEleitor != null && senha != null) {
                estaLogado = true;
                HomeBean.getEleitor().setCpf(es.buscarEleitor(titEleitor, senha).getCpf());
                HomeBean.getEleitor().setNome(es.buscarEleitor(titEleitor, senha).getNome());
                HomeBean.getEleitor().setSenha(es.buscarEleitor(titEleitor, senha).getSenha());
                HomeBean.getEleitor().setTituloeleitor(es.buscarEleitor(titEleitor, senha).getTituloeleitor());
                HomeBean.getEleitor().setStep(es.buscarEleitor(titEleitor, senha).getStep());
                Logger.getLogger(getClass().getName()).info("Usuario logado com sucesso!");
                return "/seguranca/home.xhtml?faces-redirect=true";

            } else {
                estaLogado = false;
                this.senha = "";
                Logger.getLogger(getClass().getName()).info("Falha no login!");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Login", "Usuario e/ou senha invalidos.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/index";
            }
        } catch (Exception e) {
            feedbackLogin = "Usuário/senha incorreta!";
            return "/index";
        }
    }

    public void cadastrar() {
        Eleitor e = new Eleitor();
        e.setNome(nome);
        e.setSenha(senha);
        e.setTituloeleitor(titEleitor);
        e.setCpf(cpf);
        e.setStep(0);
        if (es.cadastrarEleitor(e)) {
            feedbackCadastro = "Cadastrado com sucesso!";
            feedbackColor = "green";
        } else {
            System.out.println("PIOIOIJFOUASHIFJAS");
            feedbackCadastro = "Algo de errado não está certo!";
        }

    }

    public Integer getTitEleitor() {
        return titEleitor;
    }

    public void setTitEleitor(Integer titEleitor) {
        this.titEleitor = titEleitor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getEstaLogado() {
        return estaLogado;
    }

    public void setEstaLogado(Boolean estaLogado) {
        this.estaLogado = estaLogado;
    }

    public String getCfSenha() {
        return cfSenha;
    }

    public void setCfSenha(String cfSenha) {
        this.cfSenha = cfSenha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFeedbackLogin() {
        return feedbackLogin;
    }

    public void setFeedbackLogin(String feedbackLogin) {
        this.feedbackLogin = feedbackLogin;
    }

    public String getFeedbackCadastro() {
        return feedbackCadastro;
    }

    public void setFeedbackCadastro(String feedbackCadastro) {
        this.feedbackCadastro = feedbackCadastro;
    }

    public String getFeedbackColor() {
        return feedbackColor;
    }

    public void setFeedbackColor(String feedbackColor) {
        this.feedbackColor = feedbackColor;
    }

}
