package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public class Main implements ResponseListener {
    public static void main(String[] args) {
        /*
        Change this parameter to see different results.
         */
        int param = 6;

        new Main(param);
    }

    public Main(int param){
        ChainManager manager = new ChainManager();

        NotZeroChecker filter1 = new NotZeroChecker();
        manager.registerFilter(filter1);
        Powerizer filter2 = new Powerizer();
        manager.registerFilter(filter2);
        Summarizer filter3 = new Summarizer();
        manager.registerFilter(filter3);

        Response response = new Response(this);

        manager.doFilter(param, response);
        response.sendResponse();
    }

    @Override
    public void onResponse(int param) {
        System.out.println("RESPONSE: param = " + param);
    }
}
