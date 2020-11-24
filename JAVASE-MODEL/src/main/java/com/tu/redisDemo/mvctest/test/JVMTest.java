package com.tu.redisDemo.mvctest.test;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class JVMTest {

    public static OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();

    public static void main(String[] args) {

//获取CPU
        double cpuLoad = operatingSystemMXBean.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        //获取内存
        double totalvirtualMemory = operatingSystemMXBean.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = operatingSystemMXBean.getFreePhysicalMemorySize();
        double value = freePhysicalMemorySize/totalvirtualMemory;
        int percentMemoryLoad = (int) ((1-value)*100);

        System.out.println("cpu ：" + percentCpuLoad);
        System.out.println("总内存：" + totalvirtualMemory);
        System.out.println("空闲内存：" + freePhysicalMemorySize);
        System.out.println("percentMemoryLoad：" + percentMemoryLoad);

    }
}
