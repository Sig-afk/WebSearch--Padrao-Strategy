package websearch;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("Hamlet.txt");
        WebSearchModel model = new WebSearchModel(file);

        // O Snooper se registra no modelo configurando os dois filtros
        new Snooper(model);

        // Executa a leitura e simulação
        model.executeSearch();
    }
}