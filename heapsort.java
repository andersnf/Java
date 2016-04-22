/**************************************************************************
*                                                                         *
*     Program Filename:  heapsort.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 11, 2014                               *
*     Purpose         :  To demonstrate HeapSort                          *
*     Input from      :  None                                             *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Random;

public class heapsort
{
   public static void main(String[] args)
   {
      Integer[]      A = new Integer[30];
      int            i;
      Integer        X;
      PriorityQueue  P = new PriorityQueue(30);
      Random         Generator = new Random();

      for (i = 0; i < 30; i++)
         A[i] = Generator.nextInt(1000);
      // end for

      for (i = 0; i < 30; i++)
      {
         X = A[i];
         P.Insert(X);
      }
      // end for

      for (i = 29; i >= 0; i--)
         A[i] = (Integer) P.Remove();
      // end for

      for (i = 0; i < 30; i++)
         System.out.println(A[i]);
      // end for
   }
   // end function main
}
// end class heapsort
