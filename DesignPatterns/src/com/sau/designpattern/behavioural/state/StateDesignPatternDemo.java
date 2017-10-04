package com.sau.designpattern.behavioural.state;

/*
Let us take an example scenario using a mobile. With respect to alerts, 
a mobile can be in different states. For example, 
vibration and silent. Based on this alert state, 
behavior of the mobile changes when an alert is to be done. 
Which is a suitable scenario for state design pattern.

*/
public class StateDesignPatternDemo {
	public static void main(String[] args) {
		AlertStateContext stateContext = new AlertStateContext();
		stateContext.alert();
		stateContext.alert();
		stateContext.setState(new Silent());
		stateContext.alert();
		stateContext.alert();
		stateContext.alert();
	}
}