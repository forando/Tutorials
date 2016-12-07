/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package adapter;

import java.io.*;

/**
 * Created by forando on 29.11.14.
 */
public class Main {
    public static void main(String[] args) {

    }

    void explanation(){
        Plumber plumber = new Plumber();
        Chief chief = new ChiefAdapter(plumber);

        Object key = chief.makeDinner();
    }

    void realExampleFomJDK(){
        try {
            OutputStream stream = new FileOutputStream("/home/forando/Загрузки/test.txt");
            /*
            DataOutputStream является адаптором, который включает уже существующий объект
            (OutputStream) в новую структуру (DataOutput) позволяющую писать
            в файл значения класса Double
             */
            DataOutput dataOutput = new DataOutputStream(stream);

            dataOutput.writeDouble(42.42);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
