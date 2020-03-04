package es.indra.autotestes.automation_project.utils;

import org.openqa.selenium.By;

public enum Atores {

    ACESSOR_DE_PROTOCOLO(1, Gerencias.GET, "user", "pw", By.xpath("asd")),
    AUDITOR_FISCAL(6, Gerencias.GET, "user", "pw", By.xpath("asd")),
    GERENTE_EXECUTIVO(8, Gerencias.GET, "user", "pw", By.xpath("asd")),
    GERENTE_OPERACIONAL(3, Gerencias.GET, "user", "pw", By.xpath("asd")),
    INTERESSADO(2, Gerencias.GET, "user", "pw", By.xpath("asd")),
    PARECERISTA(7, Gerencias.GET, "user", "pw", By.xpath("asd")),
    SECRETARIO_EXECUTIVO(4, Gerencias.GET, "user", "pw", By.xpath("asd")),
    SECRETARIO_RECEITA(5, Gerencias.GET, "user", "pw", By.xpath("asd"));

    private Integer id;
    private Gerencias setor;
    private String userName;
    private String password;
    private By path;

    Atores(Integer id, Gerencias setor, String userName, String password, By path) {
        this.id = id;
        this.setor = setor;
        this.userName = userName;
        this.password = password;
        this.path = path;
    }

    public Atores user(Gerencias setor, String name, String password, By path) {
        this.setSetor(setor);
        this.setUserName(name);
        this.setPassword(password);
        this.setPath(path);
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gerencias getSetor() {
        return setor;
    }

    public void setSetor(Gerencias setor) {
        this.setor = setor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public By getPath() {
        return path;
    }

    public void setPath(By path) {
        this.path = path;
    }
}
