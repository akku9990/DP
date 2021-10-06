package DP_KnapSack;

import java.util.Scanner;

public class CountOfSubsetSum {
    public static int CountSubsetSum(int arr[],int sum,int n){
        int [][] t=new int[n+1][sum+1];
        for(int i=0;i<t.length;i++) // Initialisation
            for(int j=0;j<t[0].length;j++){
                if(i==0)t[i][j]=0;
                if(j==0)t[i][j]=1;
            }
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                else
                    t[i][j]=t[i-1][j];

            }
        }
        return t[n][sum];
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner( System.in);
        int n=scn.nextInt();
        int []arr= new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=scn.nextInt();
        int sum=scn.nextInt();
        System.out.println(CountSubsetSum(arr,sum,n));

    }
}
