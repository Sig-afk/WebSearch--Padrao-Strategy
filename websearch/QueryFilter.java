/**
 * Interface Strategy para filtragem de consultas na Web.
 */
public interface QueryFilter {
    /**
     * Avalia se a consulta atende ao critério do filtro.
     * 
     * @param query A linha/consulta pesquisada
     * @return true se o observador deve ser notificado; false caso contrário.
     */
    boolean matches(String query);
}