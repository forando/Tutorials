package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public interface Filter {
    public void doFilter(int request, Response response, FilterChain chain);
}
