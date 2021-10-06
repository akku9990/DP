package DP_KnapSack;

import java.util.Scanner;

public class SubsetSum {
    public static boolean subsetSum(int arr[],int sum,int n){
        boolean [][] t=new boolean[n+1][sum+1];
        for(int i=0;i<t.length;i++) // Initialisation
            for(int j=0;j<t[0].length;j++){
                if(i==0)t[i][j]=false;
                if(j==0)t[i][j]=true;
            }
        
        return t[n][sum];
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner( System.in);
        int n=scn.nextInt();
        int []arr= new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=scn.nextInt();
        int sum=scn.nextInt();
        System.out.println(subsetSum(arr,sum,n));

    }
}
