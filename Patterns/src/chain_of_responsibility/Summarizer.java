/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package chain_of_responsibility;

/**
 * Created by forando on 28.11.14.
 */
public class Summarizer implements Filter {
    @Override
    public void doFilter(int request, Response response, FilterChain chain) {
        System.out.println("Summarizer: Entering");
        if (request<10){
            int temp = response.getResponseParam();
            if (temp>-1){
                response.setResponseParam(temp+temp);
            }else{
                response.setResponseParam(request+request);
            }
            System.out.println("Summarizer: request < 10, responseParam = " + response.getResponseParam()
                    + ". Passing management to the next chain.");
            chain.doFilter(request, response);
            System.out.println("Summarizer: Exiting");
        }else{
            System.out.println("Summarizer: request > 10. Exiting");
        }
    }
}
