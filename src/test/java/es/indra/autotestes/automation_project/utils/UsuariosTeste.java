package es.indra.autotestes.automation_project.utils;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UsuariosTeste {

    private static final Map<Gerencias, List<Atores>> setorAtorMap = new TreeMap<>();
    private static List<Atores> gerentesExecutivos = new ArrayList<>();
    private static List<Atores> gerentesOperacionais = new ArrayList<>();
    private static List<Atores> secretariosExecutivos = new ArrayList<>();
    private static List<Atores> secretariosReceita = new ArrayList<>();
    private static List<Atores> auditoresFiscais = new ArrayList<>();
    private static List<Atores> pareceristas = new ArrayList<>();
    private static List<Atores> acessoresProtocolo = new ArrayList<>();

    static {
        acessoresProtocolo.add(
                Atores.ACESSOR_DE_PROTOCOLO.user(
                        Gerencias.GET, "forte", "asd02asd", By.xpath(
                                "")));

        pareceristas.add(
                Atores.PARECERISTA.user(
                        Gerencias.GET, "albano", "asd02asd", By.xpath(
                                "")));

        gerentesExecutivos.add(
                Atores.GERENTE_OPERACIONAL.user(
                        Gerencias.GET, "alexandr", "asd02asd", By.xpath(
                                "")));

        gerentesOperacionais.add(
                Atores.GERENTE_EXECUTIVO.user(
                        Gerencias.GOBF, "rozana", "asd02asd", By.xpath(
                                "")));
    }

    public void init() {
//        Map<Gerencias, List<Atores>> setorAtorMap = new TreeMap<>();
//        List<Atores> atores = new ArrayList<>();

        setorAtorMap.put(Gerencias.GET, gerentesExecutivos);
        setorAtorMap.put(Gerencias.GET, acessoresProtocolo);

    }

    public By getUserPath(Gerencias g, Atores a) {
        if (setorAtorMap.containsKey(g)) {
            return setorAtorMap.get(g).stream()
                    .filter(item -> item.getId() == a.getId() && item.getSetor().equals(g))
                    .findFirst()
                    .get().getPath();
        }
        return null;
    }
}
