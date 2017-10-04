package com.sau.corejava.collections;

/*
EnumMap is a map which key must be an Enum. 
Key of EnumMap cannot be different Enum it must a single enum. 
Null is not allowed as key. 
EnumMap maintains natural ordering of elements
*/

import java.util.EnumMap;
public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<TestEnum, String> enumMap = new EnumMap<TestEnum, String>(TestEnum.class);
        enumMap.put(TestEnum.A, "AAA");
        enumMap.put(TestEnum.B, "BBB");
        enumMap.put(TestEnum.C, "CCC");
        enumMap.put(TestEnum.D, "DDD");
        //iterate over key
        System.out.println("---iterate over key---");
        for(TestEnum e: enumMap.keySet()){
            System.out.println(e +" "+ e.getCode() );
        }
       //iterate over value
        System.out.println("---iterate over value---");
        for(String s: enumMap.values()){
            System.out.println(s);
        }
    }
}
enum TestEnum {
    A(1), B(2), C(3), D(4);
    private int code;
    private TestEnum(int c) {
        code = c;
    }
    public int getCode() {
        return code;
    }
}
