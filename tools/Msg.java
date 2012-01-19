package tools;

import java.util.ArrayList;


public class Msg {

	public Msg() {
	}
	
	public static void puts( String msg) {
		System.out.println(msg);
	}

	public static void puts(char c) {
		System.out.print(c);
	}

	public static void putsLine() {
		System.out.println();
	}
	
	public static void putsAll(ArrayList<String> msgs) {
		for ( String msg : msgs) {
			puts(msg);
		}
	}
	
	public static String puts_i_times(String msg, int i) {
		String res = "";
		for ( int k=1; k<=i; k++) {
			res += '\t'; 
		}
		return res;
	}

}
