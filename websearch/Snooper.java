package websearch;

public class Snooper {
    private final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        // Observador 1: Filtra por 'friend' (case-insensitive)
        this.model.addQueryObserver(
                query -> System.out.println("Oh Yes! " + query),
                query -> query.toLowerCase().contains("friend"));

        // Observador 2: Filtra por comprimento maior que 60 caracteres
        this.model.addQueryObserver(
                query -> System.out.println("So long " + query),
                query -> query.length() > 60);
    }
}