import java.io.*;

public class Main_2417_정수제곱근 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long Q = (long)(Math.sqrt(N));
		
		System.out.println(Q);
		System.out.println((long)Math.pow(Q, 2));
		
		while(true) {
			if((long)(Math.pow(Q, 2)) >= N) {
				break;
			}
			
			Q++;
		}
		
		System.out.println(Q);
		
	} // end of main
} // end of class
