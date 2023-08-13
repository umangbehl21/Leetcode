package BinarySearchQuestions;

public class BookAllocation {
     //Function to find minimum number of pages.
     public static int findPages(int[]A,int N,int M)
     {
         if(M > A.length) //if number of books are less and number of students are more then we cannot allocate books to all students 
         {
             return -1;
         }
         int low = Integer.MIN_VALUE;
           for(int i = 0;i<A.length;i++)
           {
             if(A[i] > low)
             {
                 low = A[i];
             }
           }
         int sum = 0;
         for(int i = 0;i<A.length;i++)
         {
             sum+=A[i];
         }
         int high = sum;
         while(low <= high)
         {
             int mid = (low + high)/2;
             if( Can_CurrentCapacity_Allocate_AllBooks_To_M_students(A, mid) <= M) //if using current capacity to allocate pages to students result in using less or equal student than actual m students given then decrease capacity so that less pages are allocate to one student and number of students to allocate books to increases
             {
                 high = mid - 1;
             }
             else 
             {
                 low = mid + 1;
             }
         }
         return low;
     }
     public static int Can_CurrentCapacity_Allocate_AllBooks_To_M_students(int A[],int capacity)
     {
         int totalStu = 1; //students count used while alloting books it is intitially 1 because capacity is greater than greatest element in the array so if condition will run surely as A[i] if it is greatest element then even it is less than the capacity 
         long TotalPages = 0;
         for(int i = 0;i<A.length;i++)
         {
             if(TotalPages + A[i] <= capacity) //if totalpages + current pages is less than capacity a student can be allocated with then add in totalpages 
             {
                 TotalPages += A[i];
                 
             }
             else //else if totalpages increases capacity then allocate the pages to next student thats why increase total student and initialise totalpages to the pages current student is holding 
             {
                 TotalPages = A[i];
                 totalStu++;
             }
         }
         return totalStu;
         
     }
     
}
