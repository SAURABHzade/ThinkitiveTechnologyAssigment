package com.nt.mainLogic;

public class MinimumTimeTaken {
	static boolean isDone(int time, int K,int container[], int n)
	{
	// cnt is count of current
	// assignees required for container
	int cnt = 1;

	// time assigned to current assignee
	int curr_time = 0;

	for (int i = 0; i < n;)
	{
	// If time assigned to current assignee
	// exceeds max, increment count of assignees.
	if (curr_time + container[i] > time) {
	curr_time = 0;
	cnt++;
	}

	// Else add time of container to current
	// time and move to next container
	else
	{
	curr_time += container[i];
	i++;
	}
	}

	// Returns true if count
	// is smaller than k
	return (cnt <= K);
	}
		public static int getMaxVolume(int total,int container[]) {
			int max=container[0];
			for(int i=1;i<total;i++) {
				if(max<container[i]) {
					max=container[i];
				}//if
			}//for
			return max;
		}//getMaxVolume
	public static int findMinimumTime(int tcon,int tperson,int container[]) {
		         int end = 0, start = 0;
		        for (int i = 0; i < tcon;i++)
		            end=end+ container[i];
		         int ans=end;           //initializes the total volume and time 
		         
		          int maxvolumn=getMaxVolume(tcon,container);
		          while (start <= end)
		          {
		              int mid = (start + end) / 2;
		       
		              // If it is possible to finish container filling in mid time
		              if (mid >= maxvolumn && isDone(mid, tperson, container, tcon))
		              {
		                  // Update answer
		                  ans = Math.min(ans, mid);
		                   
		                  end = mid - 1;
		              }
		   
		              else
		                  start = mid + 1;
		          }
		       
		          return  ans;
		    
	}//findMinimumTime

}//class
