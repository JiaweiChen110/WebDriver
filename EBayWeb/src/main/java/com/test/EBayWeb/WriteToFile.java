package com.test.EBayWeb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public static void saveToTextFile(String toSave, String directory) {
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(directory,true);
			BufferedWriter bw = new BufferedWriter(myWriter);
			bw.write(toSave);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
