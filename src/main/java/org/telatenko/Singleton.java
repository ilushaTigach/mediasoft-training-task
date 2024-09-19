package org.telatenko;

public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void HelloSingleton(){
        System.out.println("Hello Singleton");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.HelloSingleton();
    }
}
