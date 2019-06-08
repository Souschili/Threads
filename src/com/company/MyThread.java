package com.company;

public class MyThread extends Thread{

    private int count=0;  // счетчик

    public void run()
    {
        for(long i=0;i<999999999;i++)
        {
            count++;
        }
    }

    // возврашаем счетчик
    public int getCount()
    {
        //возврат счетчика
        return this.count;
    }

    public void stopThread()
    {
        Thread.interrupted();
        System.out.println("Поток остановлен");
    }
}
