/*********************************************************************************************************************
     **
     **  LCS using Dynamic Programming and Binary Search
     **  
     **  Input in the form of array
     **  Output is Longest Increasing SubSequence
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main
{

    
    static int longestIncreasingSubsequenceDP(int[] a) 
    {
        int dp[]=new int[a.length];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[i]>a[j] && dp[i]<(dp[j]+1))
                {
                    dp[i]=dp[j]+1;
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;

    }
    
    static int longestIncreasingSubsequenceBS(int[] a) 
    {
        int n=a.length;
        int p[]=new int[n];
        int q[]=new int[n];
        Arrays.fill(q,-1);
        p[0]=0;
        int length=0;
        for(int i=1;i<n;i++)
        {

            if(a[i]<a[p[0]])
            {
                p[0]=i;
            }
            else if(a[i]>a[p[length]])
            {
                length++;
                p[length]=i;
                q[p[length]]=p[length-1];
            }
            else
            {
                int search=binarySearch(a,p,length,a[i]);
                search=Math.abs(search);
                p[search]=i;
                q[p[search]]=p[search-1];
            }
        }
        System.out.print("Longest Increasing Subsequence is :");
        int index=p[length];
        while(index!=-1)
        {
            System.out.print(" "+a[index]);
            index=q[index];
        }
        System.out.println("");
        return length+1;
    }
    
    public static int binarySearch(int []a,int []p,int end,int s)
    {
        int start = 0;
        int middle;
        int len = end;
        
        while(start <= end)
        {
            middle = (start + end)/2;
            if(middle < len && a[p[middle]] < s && s <= a[p[middle+1]])
                return middle+1;
            else if(a[p[middle]] < s)
                start = middle+1;
            else
                end = middle-1;   
        }
        return -1;
    }

    public static void main(String[] args)
    {

        int[]a={ 2 , 4 , 3 , 7 , 4 , 5 };     

        //LCS using DP
        int result = longestIncreasingSubsequenceDP(a);
        System.out.println("Length of Longest Increasing Subsequencem Using DP : "+result);
        
        //LCS using BS
        result = longestIncreasingSubsequenceBS(a);
        System.out.println("Length of Longest Increasing Subsequencem Using BS : "+result);
        
    }
}
