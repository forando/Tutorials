/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package builder.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by forando on 05.07.15.
 */
public class Verdict {

    private List<String> verdictParts = new ArrayList<String>();

    public void addVerdictpart(String part){
        verdictParts.add(part);
    }

    public void announce(){
        System.out.println("Приговор:");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < verdictParts.size(); i++) {
            if (i + 1 == verdictParts.size()){
                builder.append("-> ");
            }
            builder.append(verdictParts.get(i));
            builder.append(" ");
        }

        System.out.println(builder.toString());
    }
}
