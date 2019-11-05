#include<bits/stdc++.h>

using namespace std;
int main(){

	int window_size,sent,ack,seq_no;

	cout << "Enter the number of bits in Sequence no : ";
	cin >> seq_no;

	window_size = (int)pow(2,seq_no);
	sent = 0;

	while(1){

		for(int i = 0 ; i < window_size ; i++){

			cout << "Frame "<<(sent++) << "has been transmitted "<<endl;
			if(sent == window_size){
				break;
			}


		}
		
		cout << "Enter the last acknowledged Frame : ";
		cin >> ack;
		
		if(ack != window_size - 1)
			cout << "Frame "<<ack + 1<<" has been timeout "<<endl;
		
		if(ack == window_size - 1){
			cout << "All frames have been Acknowledged :) "<<endl;
			break;
		}
		else{
			sent = ack + 1;
		}

	}



	return 0;
}
