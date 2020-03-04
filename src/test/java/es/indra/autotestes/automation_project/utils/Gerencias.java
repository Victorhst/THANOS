package es.indra.autotestes.automation_project.utils;

import org.openqa.selenium.By;

public enum Gerencias {

    GET(1, "", By.xpath("")),
    ASSGET(2, "", By.xpath("")),
    GOBF(3, "", By.xpath("")),
    GOIOT(4, "", By.xpath("")),
    GORC(5, "", By.xpath(""));

    private Integer id;
    private String name;
    private By path;

    Gerencias(Integer id, String name, By path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getPath() {
        return path;
    }

    public void setPath(By path) {
        this.path = path;
    }
}
