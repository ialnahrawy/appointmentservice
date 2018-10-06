package com.nahrawy.his.appointment.web.rest.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Testing {

	public Testing() {
       
	}

	static void method2() throws IOException {

		byte[] bytes = readSmallBinaryFile(FILE_NAME);
		log("Small - size of file read in:" + bytes.length);
		int[] intV = new int[bytes.length];
		byte[] byte2nd = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			intV[i] = bytes[i];
			byte2nd[i] = (byte) intV[i];
		}

writeSmallBinaryFile(byte2nd, OUTPUT_FILE_NAME);
			  }


			  final static String FILE_NAME = "C:\\10.jpg";
			  final static String OUTPUT_FILE_NAME = "C:\\output4.jpg";
			  
			  static byte[] readSmallBinaryFile(String aFileName) throws IOException {
			    Path path = Paths.get(aFileName);
			    return Files.readAllBytes(path);
			  }
			  
			  static void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
			    Path path = Paths.get(aFileName);
			    Files.write(path, aBytes); //creates, overwrites
			  }
			  
	
			  private static void log(Object aMsg){
			    System.out.println(String.valueOf(aMsg));
			  }
			  
	
	public static void main(String[] args) throws IOException {
		method2();
		
//		 
//		 try {
//			 byte inputAski = 101;
//				String content = new String(Files.readAllBytes(Paths.get("C://10.jpg")));
//				byte[] b = content.getBytes(StandardCharsets.US_ASCII);
//				String Assici = "";
//				String asciStrig = "";
//
//				//Get the file reference
//				Path path = Paths.get("c:/output2.txt");
//				 
//				//Use try-with-resource to get auto-closeable writer instance
//				BufferedWriter writer = Files.newBufferedWriter(path);
//StringBuilder sb = new StringBuilder();
//				for (int i = 0; i < b.length; i++) {
//					if(inputAski ==  b[i] ){
//						
//						sb.append(i + ",");
//					}
//					
//					//writer.write(String.valueOf( b[i]));
//				}
//
//				System.out.println(sb.toString());
//				//System.out.println(asciStrig);
//				
//				
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		 
//
////		try {
////			
////		
////		Character identifier2=null;
////		Character identifier = Character.toUpperCase(identifier2);
////		System.out.println(identifier);
////		} catch (Exception e) {
////			System.out.println("Error while extracting the document for input data: ");
////			 e.printStackTrace();
////		}
//
////		String target = "uu:FOOBar";
////		target = target.replaceAll("(?i)"+":fOo", "233");
////		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm a z");
////
////		System.out.println(dt1.format(new Date(1505986041794l)));
////		System.out.println(dt1.format(new Date()));

	}
	
	static boolean method() {
		int retuning=0;
		try {
			retuning = 111;
			if(retuning == 111){
				throw new Exception();
			}
			return true;

		} catch (Exception e) {
			retuning = 2;
			return false;
		} finally {
			System.out.println("heeeeeeeeeee  " + retuning);
		}

	}
	

}
