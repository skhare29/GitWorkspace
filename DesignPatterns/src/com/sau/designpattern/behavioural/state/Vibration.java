package com.sau.designpattern.behavioural.state;

public class Vibration implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		 System.out.println("vibration...");
	}

}