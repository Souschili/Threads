package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //создаем спискоту
        List<MyThread> prepList=prepareObjects();

        //запускаем все обьекты в дочерних потоках
        start(prepList);

        //таймер на 3 сек
        Timer time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                stop(prepList); //останавливаем таймер
                time.cancel(); //вырубаем его
            }
        },10);
    }


    //метод создает список и задает приоритеты
   static public List<MyThread> prepareObjects()
    {
        ArrayList<MyThread> myList=new ArrayList<MyThread>();
        for (int i=1;i<=10;i+=2)
        {
            //приоритеты раздаются равными i т.к 1-самый высокий ,а 10 -самый низкий
            MyThread t=new MyThread();
            t.setPriority(i);
            myList.add(t);
        }

        int i=1;
        //для теста выводим элементы и их приоритеты -->удалить
        for(MyThread e:myList)
        {
            System.out.println("Приоритет у потока "+i+" равен =  "+e.getPriority());
            i++;
        }


        //удалить --->
        System.out.println("Размер списка : "+myList.size());
        return myList;

    }

    //запуск в дочерних потоках
    static public void start( List<MyThread> obj)
    {
        for (MyThread elem:obj)
        {
            elem.start();
        }
    }

    //остановка всех дочерних потоков
    static public void stop(List<MyThread> obj)
    {
        int i=1;
        for(MyThread elem: obj)
        {
            elem.stopThread();
            System.out.println("В потоке номер "+i+" значение счетчика равно :"+elem.getCount()+" приоритет потока= "+elem.getPriority());
            i++;
        }

    }
}


