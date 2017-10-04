package com.sau.corejava.ComparableComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortFruitObject{
 
	public static void main(String args[]){
 
		Fruit[] fruits = new Fruit[4];
		//ArrayList fruitList = new ArrayList();
 
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",80); 
		Fruit apple = new Fruit("Apple", "Apple description",100); 
		Fruit orange = new Fruit("Orange", "Orange description",70); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 
 
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
		
		/*
		fruitList.add(pineappale);
		fruitList.add(apple);
		fruitList.add(orange);
		fruitList.add(banana);
		*/
		
		Arrays.sort(fruits);
		//Collections.sort(fruitList);
		
 
		int i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
		
		System.out.println("\n");
		
		Arrays.sort(fruits, Fruit.FruitNameComparator);
		//Collections.sort(fruitList, Fruit.FruitNameComparator);
	
		i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
		
 
	}	
}