/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public class Powerizer implements Filter {
    @Override
    public void doFilter(int request, Response response, FilterChain chain) {
        System.out.println("Powerizer: Entering");
        if (request>1){
            int temp = response.getResponseParam();
            if (temp>-1){
                response.setResponseParam(temp * temp);
            }else{
                response.setResponseParam(request * request);
            }
            System.out.println("Powerizer: request > 1, responseParam = " + response.getResponseParam()
                    + ". Passing management to the next chain.");
            chain.doFilter(request, response);
            System.out.println("Powerizer: Exiting");
        }else{
            response.setResponseParam(request);
            System.out.println("Powerizer: request <= 1, responseParam = " + response.getResponseParam());
            System.out.println("Powerizer: Exiting");
        }
    }
}
