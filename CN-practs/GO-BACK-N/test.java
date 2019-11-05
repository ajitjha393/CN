
import java.util.*;
class test
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no of bits in Seq no : ");
		int k =sc.nextInt();
		int n = (int)Math.pow(2,k);
		// Total cyclic frames
		int frame = (int)Math.pow(2,n);

		int transmit[] = new int[frame];
		int transmit_flag[] = new int[frame];
		int receive[] = new int[frame - 1];
		int index = 0 , count1 = 0 , count2 = 0;


		for(int c = 0 ; c < n ; c++){

			transmit[c] = c;
			transmit_flag[c] = 0; // Indicates bit to be sent
		}

		int inp = 1;

		do{

			System.out.println("\n1. Execute 2. Exit\n");
			inp = sc.nextInt();

			switch(inp){

				case 1:{

					count1 = 0; count2 = 0;
					System.out.println("\nFRAMES ALLOWED : \n");


					//Start of loop
					
					for(int c = index ; c < n ; c++){

						if(count1 != n-1){
							System.out.print(transmit[c] + " ");
							count1 += 1;
						}
					}
					//End of loop

					if(count1 != n-1){

						for(int d=0,l=1;l<=n-count1;d++,l++)
						{
							System.out.print(transmit[d]+" ");
							count1+=1;
						}

					}

					System.out.println("\nEnter the Transmitting Frame\n");
					for(int c=0;c<n-1;c++)
					{
						receive[c] = sc.nextInt();
					}


					for(int c=0;c<n-1;c++)
					{
						if ( receive[c] == transmit[index] )
						{
							transmit_flag[index] = 1;
							System.out.println(receive[c]+" is acknowledged\n");
							if(index == n-1 )
							{
								index=0;
							}
							else
							{
								index+=1;
							}

						}
						else
						{
							System.out.println(receive[c]+ " is not acknowledged");
							break; 
						}
					}

					for(int c=index;c<n;c++)
					{
						transmit_flag[c] = 0;
						count2+=1;
					}
					if( count2 != n )
					{
						for(int d=0,l=1;l<=n-count2;l++,d++)
						{
							transmit_flag[d] = 0;
						}
					}


					break;



				}

				case 2 : 
				{
					System.out.println("\nExit!!\n");
					break;
				}
				default:
				{
					System.out.println("\nInvalid input\n");
					break;
				}

			}


		}while(inp != 2);





	}
}