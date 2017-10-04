package com.sau.designpattern.behavioural.state;

public class Silent implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		System.out.println("silent...");
	}

}
