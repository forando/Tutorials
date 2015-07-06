package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public class Response{
    private int responseParam;
    ResponseListener listener;

    public Response(ResponseListener listener) {
        this.responseParam = -1;
        this.listener = listener;
    }


    public int getResponseParam(){
        return responseParam;
    }
    public void setResponseParam(int val){
        responseParam = val;
    }

    public void sendResponse(){
        listener.onResponse(responseParam);
    }
}
