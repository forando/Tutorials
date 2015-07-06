package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public interface FilterChain {
    public void doFilter(int request, Response response);
}
