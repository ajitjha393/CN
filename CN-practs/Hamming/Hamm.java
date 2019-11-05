// import java.io.*;
import java.util.*;

class Hamm{

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		// Console c = System.console();
		int i=0,j=0,count1=0,count2=0,count4=0,count8=0;

		int data[] = new int[7];
		int hc[] = new int[11];
		int rd[] = new int [11];

		System.out.println("Enter Data bits : ");
		for(i = 0 ; i < 7 ; i++){
			// data[i] = Integer.parseInt(c.readLine());
			data[i] = sc.nextInt();
		}

		//start of loop
		for(i = 10 ; i >= 0 ; i--){
			if(i!=0 && i != 1 && i != 3 && i != 7){
				hc[i] = data[j++];
			}
		}
		// end of loop

		//start of loop

		for(i=0;i<11;i++){

			if(i%2 == 0){
				if(hc[i] == 1) count1++;
			

			}
			if(i==1 || i==2 || i==5 || i==6 || i==9 || i==10){
				if(hc[i]==1) count2++;
			}

			if(i>=3 && i<=6){
				if(hc[i]==1) count4++;
			}

			if(i>=7 && i<=10){
				if(hc[i]==1) count8++;
			}


		}

		hc[0] = setBit(count1);
		hc[1] = setBit(count2);
		hc[3] = setBit(count4);
		hc[7] = setBit(count8);

		System.out.println("Hamming Code : ");

		for(i = 10 ; i >= 0 ;i--){
			System.out.print(hc[i] + " ");
		}


		// Error Detection

		System.out.println("Enter the received data:");
		for(i = 0 ; i < 11 ; i++){
			// rd[i] = Integer.parseInt(c.readLine());
			rd[i] = sc.nextInt();
		}

		// initialize start i = 10

		i = 10;

		for(j = 0 ; j < 11 ; j++){

			if(rd[j] != hc[i--]){
				System.out.println("Error is at position " + (i + 2));
			}
		}


	}

	public static int setBit(int c){
		if(c%2 == 0) return 0;
		else return 1;
	}

}