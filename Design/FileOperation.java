package com.comp.prog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("output.txt");
		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		String line = br.readLine();
		while (line != null) {
			pw.write(line);
			line = br.readLine();
		}
		pw.flush();
		br.close();
		pw.close();
	}

}
