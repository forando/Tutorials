package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public class NotZeroChecker implements Filter {
    @Override
    public void doFilter(int request, Response response, FilterChain chain) {
        System.out.println("Multiplier: Entering");
        if (request>0){
            System.out.println("Multiplier: request > 0. Passing management to the next chain.");
            chain.doFilter(request, response);
            System.out.println("Multiplier: Exiting");
        }else if(request==0){
            response.setResponseParam(request);
            System.out.println("Multiplier: request = 0, responseParam = " + response.getResponseParam());
            System.out.println("Multiplier: Exiting");
        }else{
            System.out.println("Multiplier: Exiting");
        }
    }
}
