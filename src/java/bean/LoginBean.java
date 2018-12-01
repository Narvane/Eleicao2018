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
public class LoginBean implements Serializable{
    
    EleitorService es = new EleitorService();

    private Integer titEleitor;
    private String senha;
    private String cfSenha;
    private String cpf;
    private String nome;
    
    private Boolean estaLogado = false;
    
    public static Eleitor eleitor = new Eleitor();

    public LoginBean() {
    }
    
    
    public String logar() {
        int buscaTitulo = es.buscarEleitor(titEleitor, senha).getTituloeleitor();
        String buscaSenha = es.buscarEleitor(titEleitor, senha).getSenha();

        if (titEleitor != null && senha != null && titEleitor== buscaTitulo && senha.equals(buscaSenha)) {
            estaLogado = true;
            eleitor.setCpf(es.buscarEleitor(titEleitor, senha).getCpf());
            eleitor.setNome(es.buscarEleitor(titEleitor, senha).getNome());
            eleitor.setSenha(es.buscarEleitor(titEleitor, senha).getSenha());
            eleitor.setTituloeleitor(es.buscarEleitor(titEleitor, senha).getTituloeleitor());
            eleitor.setStep(es.buscarEleitor(titEleitor, senha).getStep());
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
    }
    public void cadastrar(){
        if((senha == null ? cfSenha == null : senha.equals(cfSenha)) && titEleitor != null && nome != null && cpf != null && cfSenha != null && senha != null){
            Eleitor e = new Eleitor();
            e.setNome(nome);
            e.setSenha(senha);
            e.setTituloeleitor(titEleitor);
            e.setCpf(cpf);
            e.setStep(0);
            es.cadastrarEleitor(e);
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
    
}
