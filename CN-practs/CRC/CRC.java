import java.util.*;

class CRC{

	static int i,j,k,m,n,msb;
		static int g[] , d[] , z[] ,r[];


	public static void main(String args[]){


		Scanner sc = new Scanner(System.in);

		System.out.print("Enter no of data bits : ");
		n = sc.nextInt();
		
		System.out.print("Enter no of generator bits : ");
		m = sc.nextInt();

		g = new int[m];
		d = new int[n+m];
		z = new int[m];
		r = new int[n+m];

		System.out.println("Enter data bits");

		for(i = 0 ; i < n ; i++){
			d[i] = sc.nextInt();
		}

		System.out.print("Enter generator bits : ");

		for(i = 0 ; i < m ; i++){
			g[i] = sc.nextInt();
		}

		//Appending m -1 zeroes

		for(i = 0 ; i < m-1 ; i++){
			d[n+i] = 0;
		}

		Mod2();


		System.out.print("Appended bits :  ");
		for(i = n ; i < n+m-1 ; i++){
			d[i] = r[i];
			System.out.print(d[i]);
		}

		System.out.print("\nTransmitted data is : ");
		for(i = 0 ; i < n+m-1 ; i++){
			System.out.print(d[i]);
		}
		System.out.println();

//--------------------------------------------------------

		// RECEIVER SIDE
		System.out.println("Enter Received data : ");
		for(i = 0 ; i < n+m -1 ;i++){
			d[i] = sc.nextInt();
		}

		Mod2();

	int flag = 0;
		
		for(i = n ; i < n+m-1 ; i++){
			
			if(r[i] != 0)
				flag = 1;
			System.out.print(r[i]);
		}

		if(flag == 1){
			System.out.println("\nData is rejected :( ");
		}
		else 
			System.out.println("\nData is accepted :) ");





	}

	public static int xor(int x , int y){

		if(x == y){
			return 0;
		}
		else return 1;
	}


	public static void Mod2(){

		//Takes first m digit for xor

		for(i = 0 ; i < m ; i++){
			r[i] = d[i];
		}

		//Z array is for xor with 0
		for(i = 0 ; i < m ;i++){
			z[i] = 0;
		}



		for(i = 0 ; i < n ;i++){

			k = 0;
			msb = r[i];
			for(j = i ; j < m+i ; j++){

				if(msb == 0){
					r[j] = xor(r[j],z[k]);
				}
				else{
					r[j] = xor(r[j],g[k]);

				}

				k++;
			}
			r[m+i] = d[m+i];
		}




	}


}