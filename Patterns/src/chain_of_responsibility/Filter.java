package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public interface Filter {
    void doFilter(int request, Response response, FilterChain chain);
}
