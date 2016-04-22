/**************************************************************************
*                                                                         *
*     Program Filename:  lockers.java                                     *
*     Author          :  John B. Student                                  *
*     Date Written    :  August 26, 2014                                  *
*     Purpose         :  To solve the "1000 Lockers" Problem              *
*     Input from      :  None                                             *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/

public class lockers
{
   public static void main(String[] args)
   {
      int     i, k;
      int[]   Lockers = new int[1001];

      for (i = 1; i <= 1000; i++)
         Lockers[i] = 1;
      // end for

      for (k = 2; k <= 1000; k++)
      {
         for (i = k; i <= 1000; i = i+k)
         {
            if (Lockers[i] == 0)
               Lockers[i] = 1;
            else
               Lockers[i] = 0;
            // end if
         }
         // end for
      }
      // end for

      for (k = 1; k <= 1000; k++)
         if (Lockers[k] == 1)
            System.out.println(k);
         // end if
      // end for
   }
   // end function main
}
// end class lockers
