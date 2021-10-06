package DP_KnapSack;

import java.util.Scanner;

public class CountNoOfSubsetWithGivenDiff {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int [n];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
            sum+=arr[i];
        }
        int d=scn.nextInt();
        System.out.println(countSubset(arr,n,d,sum));
    }
    public static int countSubset(int []arr,int n,int d,int sum){
        int sum1=(d+sum)/2;
        int [][]t=new  int[n+1][sum1+1];
        
        for(int i=1;i<t.length;i++)
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
                else
                    t[i][j]=t[i-1][j];
            }
        return t[n][sum1];
    }
}
