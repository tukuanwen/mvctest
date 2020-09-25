package com.spi.demo;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemo {

    public static void main(String[] args) {


        ServiceLoader<SpiInterface> serviceLoader = ServiceLoader.load(SpiInterface.class);
        Iterator<SpiInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){

            SpiInterface spiInterface = iterator.next();
            spiInterface.say();
        }

    }
}
