package org.practice.algorithms;

import java.io.*;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeSortedFiles {


	private static final PriorityQueue<ReadBuffer> queue = new PriorityQueue<ReadBuffer>((a, b) -> a.number - b.number);

	public static void mergeSortedFiles(String directoryPath) {
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();
		for(File file : files) {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file));
				try {
					String line = reader.readLine();
					if(Objects.nonNull(line)){
						queue.add(new ReadBuffer(Integer.valueOf(line), reader));
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		String outputFilePath = "C:\\Dev\\outputfile";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(outputFilePath) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(!queue.isEmpty()) {
			ReadBuffer breader = queue.poll();
			writer.println(breader.number);
			try {
				String line = breader.reader.readLine();
				if(Objects.nonNull(line)) {
					queue.add(new ReadBuffer(Integer.parseInt(line), breader.reader)) ;	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.close();
	}
	
	public static int readLineFromFile(BufferedReader reader) throws IOException{
			return Integer.valueOf(reader.readLine());
	}

	public static void main(String[] args) {
		mergeSortedFiles("C:\\Dev\\sorted_files");
	}
	
	static class ReadBuffer{
		int number;
		BufferedReader reader;
		public ReadBuffer(int number, BufferedReader reader) {
			this.number = number;
			this.reader = reader;
		}
	}

}
