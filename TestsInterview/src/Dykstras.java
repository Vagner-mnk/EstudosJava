

	
	/* package whatever; // don't place package name! */

import java.util.Scanner; 

/* Name of the class has to be "Main" only if the class is public. */
class Dykstras {

	static Scanner scan; 

	public static void main (String[] args) throws java.lang.Exception
	{
	
		// declare 

		int [][] matrix = new int [8][8]; 
		int [] distance = new int [8]; int [] pred = new int [8]; int [] visited = new int [8]; 
		int min = 9999 ; int nextnode = 0 ; 

	scan = new Scanner(System.in);





	// input

	for ( int i = 0 ; i< 8 ; i++)
	{
			pred [i] = 0 ; 
			visited[i] = 0 ; 

		 for ( int j = 0 ; j< 8 ; j++)

		 	{ 
		 		matrix[i][j] = scan.nextInt(); 
		 		if (matrix[i][j] ==0 )matrix[i][j] = 9999; 
		 	}
	}






			//dj's algo 

visited[0] = 1; 
distance = matrix[0]; 
distance[0]=0; 


for ( int c= 0 ; c<8;c++)//all ndes
{ 
min = 9999; 


for ( int i = 0 ; i< 8 ; i++) // updat distances 
{
	if ( min > distance [i] && visited[i] !=1 )// if reachable and never visited 
	{ 
		nextnode=i; 
		min = distance[i]; 
	}
}


visited[nextnode] =1; 

for ( int i =0 ; i < 8 ; i++)
{
	if ( visited[i]!=1){

		if ( min + matrix[nextnode][i] < distance[i])
		{
			distance[i] = min + matrix[nextnode][i]; 
			pred[i] = nextnode; 
		}
	}
}



}




// output 

for ( int i = 0 ; i< 8 ; i++)
{ 

System.out.print("|" + distance[i]); 

}System.out.print("|"); 





int j; 
for ( int i = 0; i < 8 ; i++)
	{ 
if ( i!=0){


			String s = numtocharez(i); 
			System.out.print("Path = "+ s); 

			j=i; 
			do { 
				j = pred[j]; s= numtocharez(j);
				System.out.print(" <- " + s); 
			}while ( j!=0);

	} 
System.out.println(); 

}










	}


public static String numtocharez(int i){return i < 25 && i > -1 ? String.valueOf((char)(i+65)) : null ;}
}


