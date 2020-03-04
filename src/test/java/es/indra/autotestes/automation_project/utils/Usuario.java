package es.indra.autotestes.automation_project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Usuario {

    public static final String ACESSOR_DE_PROTOCOLO;
    public static final String INTERESSADO;
    public static final String GERENTE_EXECUTIVO;
    public static final String GERENTE_OPERACIONAL;
    public static final String SECRETARIO_EXECUTIVO;
    public static final String SECRETARIO_RECEITA;
    public static final String AUDITOR_FISCAL;
    public static final String PARECERISTA;

    static {
        ACESSOR_DE_PROTOCOLO = get("acessor.de.protocolo");
        INTERESSADO = get("interessado");
        GERENTE_EXECUTIVO = get("gerente.executivo");
        GERENTE_OPERACIONAL = get("gerente.operacional");
        SECRETARIO_EXECUTIVO = get("secretario.executivo");
        SECRETARIO_RECEITA = get("secretario.receita");
        AUDITOR_FISCAL = get("auditor.fiscal");
        PARECERISTA = get("parecerista");
    }

    private Usuario() {
    }

    private static String get(String name) {

        Properties properties = new Properties();
        String value = null;

        try {
            FileInputStream file = new FileInputStream(Dados.DATA_FILE);
            properties.load(file);
            value = properties.getProperty(name);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return value;
    }

}
