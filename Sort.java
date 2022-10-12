import java.util.Scanner;
import java.util.Arrays;
public class Sort{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int[] arr1=new int[n/3];
		int[] arr2=new int[n/3];
		int[] arr3=new int[(n/3)+(n%3)];

		int i=0;

		while(i<n/3){
			arr1[i]=sc.nextInt();
			arr2[i]=sc.nextInt();
			arr3[i++]=sc.nextInt();
		}
		while(i<((n/3)+(n%3)))
			arr3[i++]=sc.nextInt();

		//Arrays before sorting
		System.out.println("\nBefore Sorting : ");
		System.out.println("arr1 : "+Arrays.toString(arr1));
		System.out.println("arr2 : "+Arrays.toString(arr2));
		System.out.println("arr3 : "+Arrays.toString(arr3));
		
		//Sorting the arrays individually
		sort(arr1);
		sort(arr2);
		sort(arr3);

		//Arrays after sorting
		System.out.println("\nAfter Sorting : ");
		System.out.println("arr1 : "+Arrays.toString(arr1));
		System.out.println("arr2 : "+Arrays.toString(arr2));
		System.out.println("arr3 : "+Arrays.toString(arr3));
		

		int p1=0,p2=0,p3=0,j=0;

		int[] arr=new int[n];

		//sorting by comparing with other arrays
		while(p1<n/3 && p2<n/3 && p3<((n/3)+(n%3))){
			if(arr1[p1]<=arr2[p2] && arr1[p1]<=arr3[p3])
				arr[j++]=arr1[p1++];
			else if(arr2[p2]<=arr1[p1] && arr2[p2]<=arr3[p3])
				arr[j++]=arr2[p2++];
			else
				arr[j++]=arr3[p3++];
		}

		//elements in one array will be sorted in the previous iteration. Now sorting by comparing the remaining two arrays
		while(p1<n/3 && p2<n/3){
			if(arr1[p1]<=arr2[p2])
				arr[j++]=arr1[p1++];
			else
				arr[j++]=arr2[p2++];
		}

		while(p1<n/3 && p3<((n/3)+(n%3))){
			if(arr1[p1]<=arr3[p3])
				arr[j++]=arr1[p1];
			else
				arr[j++]=arr3[p3++];
		}

		while(p2<n/3 && p3<((n/3)+(n%3))){
			if(arr2[p2]<=arr3[p3])
				arr[j++]=arr2[p2++];
			else
				arr[j++]=arr3[p3++];
		}

		//elements in two arrays are sorted. Now adding the remaing sorted values from the final array
		while(p1<n/3)
			arr[j++]=arr1[p1++];

		while(p2<n/3)
			arr[j++]=arr2[p2++];

		while(p3<(n/3)+(n%3))
			arr[j++]=arr3[p3++];

		System.out.println("\nFinal Array : ");
		System.out.println(Arrays.toString(arr));


	}

	public static void sort(int arr[]){
		int n=arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1])
					arr[j]=arr[j]+arr[j+1]-(arr[j+1]=arr[j]);
			}
		}
	}
}