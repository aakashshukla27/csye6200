package edu.neu.csye6200.agency;

public class TestSingleton {
    private static TestSingleton single_instance = null;
    public String s;
    private TestSingleton(){
        s = "Hello i am a string part of singleton class.";
    }

    public static TestSingleton getInstance(){
        if(single_instance == null){
            single_instance = new TestSingleton();
        }
        return single_instance;
    }
}
