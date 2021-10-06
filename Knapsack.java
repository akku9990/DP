package DP_KnapSack;

import java.util.Scanner;

public class Knapsack {
    public  static int knapsack(int wt[],int val[], int W,int n){
        int [][]t=new int[n+1][W+1];
        for(int i=0;i<t.length;i++)
            for(int j=0;j<t[0].length;j++)
                if(i==0 || j==0)t[i][j]=0;
        for(int i=1;i<t.length;i++)
            for(int j=1;j<t[0].length;j++){
                if(wt[i-1]<=j)
                    t[i][j]=max((val[i-1]+t[i-1][j-wt[i-1]]), t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];

            }
        return t[n][W];
    }
    
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Size of Array");
        int n=scn.nextInt();
        int []wt=new int[n];
        int []val= new int[n];
        System.out.println("Enter weight with corresponding value");
        for(int i=0;i<n;i++){
            wt[i]=scn.nextInt();
            val[i]=scn.nextInt();
        }
        System.out.println("Capacity of bag (knapsack)");
        int W=scn.nextInt();

        System.out.println("Max profit");
        System.out.println(knapsack(wt,val,W,n));


    }
}
