/**************************************************************************
*                                                                         *
*     Program Filename:  heapsort2.java                                   *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 16, 2014                               *
*     Purpose         :  To demonstrate Heap Sort                         *
*     Input from      :  Keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class heapsort2
{
   public static void main(String[] args)
   {
      Scanner        Keyboard = new Scanner(System.in);
      Random         Generator = new Random();
      int            N, i;
      Integer[]      A;
      Integer        X;
      PriorityQueue  P;

      System.out.print("Please enter the size of the sort array: ");
      N = Keyboard.nextInt();

      A = new Integer[N];
      P = new PriorityQueue(N);

      for (i = 0; i < N; i++)
         A[i] = Generator.nextInt(10000000);
      // end for

      for (i = 0; i < N; i++)
      {
         X = A[i];
         P.Insert(X);
      }
      // end for

      for (i = N-1; i >= 0; i--)
         A[i] = (Integer) P.Remove();
      // end for

      for (i = 0; i < 100; i++)
         System.out.println(A[i]);
      // end for
   }
   // end function main
}
// end class heapsort2
