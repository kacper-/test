package comt.singelton;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singelton test");
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread write");
            Singelton.a = 2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            boolean change = false;
            long start = new Date().getTime() + 1000;
            while(start > new Date().getTime()) {
                if(Singelton.a > 1) {
                    change = true;
                    break;
                }
            }
            if(change)
                System.out.println("Thread value change");
            else
                System.out.println("Thread no value change");
        }).start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Not Singelton test");
        NotSingelton ns = new NotSingelton();
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            System.out.println("Thread write");
            ns.a = 2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            boolean change = false;
            long start = new Date().getTime() + 1000;
            while(start > new Date().getTime()) {
                if(ns.a > 1) {
                    change = true;
                    break;
                }
            }
            if(change)
                System.out.println("Thread value change because of volatile keyword in NotSingelton");
            else
                System.out.println("Thread no value change");
        }).start();
    }
}
