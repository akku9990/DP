package DP_KnapSack;

import java.util.Scanner;

public class EqualSumPartition {
    public static void main(String[] args) {
        

    }
    public static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2==1)return 0;
        int sum1=sum/2;
        int [][]t=new int[N+1][sum1+1];
        for(int i=0;i<t.length;i++)
            for(int j=0;j<t[0].length;j++){
                if(i==0)t[i][j]=0;
                if(j==0)t[i][j]=1;
            }
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j)
                    t[i][j]=max(t[i-1][j-arr[i-1]]  ,t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[N][sum1];

    }
    public  static  int max(int a,int b){
        return a>b?a:b;
    }
}
