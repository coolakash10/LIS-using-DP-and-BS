# LIS-using-DP-and-BS
Longest Increasing Subsequence using Dynamic Approach and Binary Search

There are two approach to find longest increasing subsequence

              1. Dynamic Approach
              2. Binary Search
              
1. Dynamic Approach : Find longest subsequence at each index 
              
              condition : if(a[i]>a[j] && dp[i]<dp[j]+1): dp[i]=dp[j]+1;
              
              Time Complexity  : 0(n*(n-1)) = 0(n^2)
              Space Complexity : 0(2*n)     = 0(n)
             
2. Binary Search : update longest subsequece index
              
              condition :1. if(a[i]<a[p[0]]):
                         2. else if(a[i]>a[p[length]]):
                         3. else find ceil(binarySearch(a,p,a[i]))
              
              Time Complexity  : 0(n*logn) = 0(nlogn)
              Space Complexity : 0(3*n)     = 0(n)
