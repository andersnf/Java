/**************************************************************************
*                                                                         *
*     Program Filename:  duck.java                                        *
*     Author          :  John B. Student                                  *
*     Date Written    :  August 26, 2014                                  *
*     Purpose         :  To solve the "Duck-Goose-Goose" problem          *
*     Input from      :  None                                             *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/

public class duck
{
   public static void main(String[] args)
   {
      Queue<Integer> Q = new Queue<Integer>();
      int i, j;

      for (i = 1; i <= 1000; i++)
      {
         for (j = 1; j <= i; j++)
            Q.Enqueue(j);
         // end for

         while (Q.LengthQueue() > 1)
         {
            j = Q.Dequeue();
            Q.Enqueue(j);

            if (Q.LengthQueue() > 1)
               j = Q.Dequeue();
            // end if

            if (Q.LengthQueue() > 1)
               j = Q.Dequeue();
            // end if
         }
         // end while

         j = Q.Dequeue();

         if (i == j)
            System.out.println(j);
         // end if
      }
      // end for
   }
   // end function main
}
// end class duck
