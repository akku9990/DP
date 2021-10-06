package DP_KnapSack;

import java.util.ArrayList;
import java.util.Scanner;

class MinSubsetSumDifference {
    public static void main(String[] args) {
        Scanner scn=new Scanner( System.in);
        int n=scn.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=scn.nextInt();
        System.out.println(minDifference(arr,n));
    }
    public static int minDifference(int []arr,int n){
        int sum=0;
        for(int i=0;i<arr.length;i++)sum+=arr[i];
        boolean [][]t=subsetSum(arr,n,sum);
        ArrayList<Integer> l1=new ArrayList<>();
        for(int i=t.length-1;i<t.length;i++)
            for(int j=0;j<(t[0].length+1)/2;j++){
                if(t[i][j]==true)
                    l1.add(j);
            }
        int mn=Integer.MAX_VALUE;
        for(int i=0;i<l1.size();i++){
            mn=Integer.min(mn,sum-2*l1.get(i));
        }
        return mn;
    }
    public  static boolean[][] subsetSum(int []arr, int n, int sum){
        boolean [][]t=new boolean[n+1][sum+1];
        for(int i=0;i<t.length;i++)
            for(int j=0;j<t[0].length;j++){
                if(i==0)t[i][j]=false;
                if(j==0)t[i][j]=true;
            }
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else
                   t[i][j]=t[i-1][j];
            }
        }
        return t;
    }
}