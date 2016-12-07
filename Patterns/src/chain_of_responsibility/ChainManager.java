/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by forando on 28.11.14.
 */
public class ChainManager implements FilterChain {

    private List<Filter> receivers;
    private int receiverIndex;

    public ChainManager(){
        receiverIndex = 0;
        receivers = new ArrayList<Filter>();
    }

    public void registerFilter(Filter filter){
        receivers.add(filter);
    }

    public void unregisterFilter(Filter filter) throws Exception{
        try{
            receivers.remove(filter);
        }catch (Exception ex){
            throw new Exception("The filter is not registered.");
        }
    }

    @Override
    public void doFilter(int request, Response response) {
        if (receiverIndex<receivers.size()) {
            Filter filter = receivers.get(receiverIndex);
            ++receiverIndex;
            filter.doFilter(request, response, this);
        }
    }
}
