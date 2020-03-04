package es.indra.autotestes.automation_project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe utilitária com os dados necessários para a execução dos testes.
 *
 * @author victor.teixeira@receita.pb.gov.br
 * @author vhsilvat@indracompany.com
 */
public class Dados {

    public static final String DATA_FILE = "src/test/resources/data.properties";
    public static final String URL_LOGIN;
    public static final String URL_INBOX;
    public static final String URL_PEDIDO_ISENCAO;
    public static final String EFISCO_HOM_LOGIN;
    public static final String EFISCO_HOM_INBOX;
    public static final String EFISCO_HOM_PEDIDO;
    public static final String PDF_TESTE;
    public static final String CPF;
    public static final String CNPJ_NAO_CONTRIBUINTE;
    public static final String CNPJ_CONTRIBUINTE_SEM_DTE;
    public static final String CNPJ_CONTRIBUINTE_COM_DTE;
    public static final String IE_CONTRIBUINTE_SEM_DTE;
    public static final String IE_CONTRIBUINTE_COM_DTE;

    static {
        URL_LOGIN = get("efisco.des.login");
        URL_INBOX = get("efisco.des.inbox");
        URL_PEDIDO_ISENCAO = get("efisco.des.pedido");

        EFISCO_HOM_LOGIN = get("efisco.hom.login");
        EFISCO_HOM_INBOX = get("efisco.hom.inbox");
        EFISCO_HOM_PEDIDO = get("efisco.hom.pedido");

        PDF_TESTE = get("pdf.teste");

        CPF = get("cpf");
        CNPJ_NAO_CONTRIBUINTE = get("cnpj.nao.contribuinte");
        CNPJ_CONTRIBUINTE_SEM_DTE = get("cnpj.contribuinte.sem.dte");
        CNPJ_CONTRIBUINTE_COM_DTE = get("cnpj.contribuinte.com.dte");
        IE_CONTRIBUINTE_SEM_DTE = get("ie.contribuinte.sem.dte");
        IE_CONTRIBUINTE_COM_DTE = get("ie.contribuinte.com.dte");
    }

    private Dados() {
    }

    private static String get(String name) {

        Properties properties = new Properties();
        String value = null;

        try {
            FileInputStream file = new FileInputStream(DATA_FILE);
            properties.load(file);
            value = properties.getProperty(name);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return value;
    }
}
