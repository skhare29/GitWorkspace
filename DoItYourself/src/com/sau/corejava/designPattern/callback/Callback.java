package com.sau.corejava.designPattern.callback;

public class Callback {

	public static void main(String[] argv) {
		MyObject myObj = new MyObject();
		final String str = "Test Successfull";

		myObj.getHelp(new HelpCallback() {
			public void call(int result) {
				System.out.println("Help Callback: " + result + " " + str);
			}
		});
	}
}

class MyObject {
	int a = 2;
	public void getHelp(HelpCallback callback) {
		callback.call(a);
	}
}

abstract class HelpCallback {
	abstract public void call(int result);
}
