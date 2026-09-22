package websearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebSearchModel {
    private final File sourceFile;
    private final List<ObserverFilterPair> observers = new ArrayList<>();

    // Classe auxiliar para associar o observador ao seu filtro
    private static class ObserverFilterPair {
        final QueryObserver observer;
        final QueryFilter filter;

        ObserverFilterPair(QueryObserver observer, QueryFilter filter) {
            this.observer = observer;
            this.filter = filter;
        }
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    /**
     * Registra um observador associado a uma estratégia de filtro.
     */
    public void addQueryObserver(QueryObserver observer, QueryFilter filter) {
        observers.add(new ObserverFilterPair(observer, filter));
    }

    /**
     * Simula a busca lendo o arquivo de dados linha por linha.
     */
    public void executeSearch() {
        try (Scanner scanner = new Scanner(sourceFile)) {
            while (scanner.hasNextLine()) {
                String query = scanner.nextLine();
                notifyObservers(query);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica o filtro antes de notificar cada observador.
     */
    private void notifyObservers(String query) {
        for (ObserverFilterPair pair : observers) {
            // Aplicação da estratégia: o modelo não sabe a regra concreta do filtro
            if (pair.filter.matches(query)) {
                pair.observer.queryFound(query);
            }
        }
    }
}