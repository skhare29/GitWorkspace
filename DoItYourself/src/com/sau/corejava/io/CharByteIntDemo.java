package com.sau.corejava.io;

import java.nio.charset.Charset;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CharByteIntDemo {
	static String str = "Saurabh€";
	static byte[] b = str.getBytes();
	static char c = '\u20ac';
	
	public static void main(String[] args) {
		
			System.out.println(Charset.defaultCharset());

		
		for(int i = 0; i < b.length ; i++){
			System.out.println((char)b[i]);
		}
		
		System.out.println(b);
		
		System.out.print((byte) c + " ");
		System.out.print((int) c + " ");
		System.out.println(c);
		
		
		
//		for (byte i = -128 ; i < 127 ; i++){
//			System.out.print((char) i +  " ");
//		
//		}
		
		byte bb = -87;
		
		System.out.println((char)bb);
		
	}

}
