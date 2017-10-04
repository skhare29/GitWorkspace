package com.sau.corejava.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import javax.annotation.processing.Filer;

public class TestingIO {

	public static void main(String[] args) {
		try {
			System.out.println(Charset.defaultCharset());
			//File file = new File("C:/MyFiles/Projects/LearnYourself/DoItYourself/StudyNotes.txt");
			File file = new File("bin/StudyNotes1.txt");
			//InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"windows-1252");
			FileReader fr = new FileReader(file);
			System.out.println(fr.getEncoding()); 
			BufferedReader br = new BufferedReader(fr);
//			String str;
//			while((str = br.readLine()) != null ){
//				System.out.println(str);
//			}
			
			int i;
			while((i = br.read()) != -1 ){
				System.out.print((byte)i + "\t");
				System.out.print((char)i + "\t");
				System.out.println(i );
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
