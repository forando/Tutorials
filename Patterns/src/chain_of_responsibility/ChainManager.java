package chain_of_responsibility;

import org.omg.CORBA.ExceptionList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by forando on 28.11.14.
 */
public class ChainManager implements FilterChain {

    private List<Filter>filterList;
    private int filterSize;
    private int i;

    public ChainManager(){
        filterSize = 0;
        i = 0;
        filterList = new ArrayList<Filter>();
    }

    public void registerFilter(Filter filter){
        filterList.add(filter);
        ++filterSize;
    }

    public void unregisterFilter(Filter filter) throws Exception{
        try{
            filterList.remove(filter);
            --filterSize;
        }catch (Exception ex){
            throw new Exception("The filter is not registered.");
        }
    }

    /*public int startChain(int param, Response response){
        doFilter(param, response);
        return response;
    }*/

    @Override
    public void doFilter(int request, Response response) {
        ++i;
        int index = i - 1;
        if (index<filterSize) {
            Filter filter = filterList.get(index);
            filter.doFilter(request, response, this);
        }
    }
}
