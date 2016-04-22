/**************************************************************************
*                                                                         *
*     Program Filename:  bubblesort.java                                  *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 16, 2014                               *
*     Purpose         :  To demonstrate Bubble Sort                       *
*     Input from      :  Keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class bubblesort
{
   public static void main(String[] args)
   {
      Scanner        Keyboard = new Scanner(System.in);
      Random         Generator = new Random();
      int            N, i, j, temp;
      int[]          A;

      System.out.print("Please enter the size of the sort array: ");
      N= Keyboard.nextInt();

      A = new int[N];

      for (i = 0; i < N; i++)
         A[i] = Generator.nextInt(10000000);
      // end for

      for (i = N-1; i >= 0; i--)
         for (j = 1; j <= i; j++)
            if (A[j-1] > A[j])
            {
               temp   = A[j];
               A[j]   = A[j-1];
               A[j-1] = temp;
            }
            // end if
         // end for
      // end for

      for (i = 0; i < 100; i++)
         System.out.println(A[i]);
      // end for
   }
   // end function main
}
// end class bubblesort
