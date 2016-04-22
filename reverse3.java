/**************************************************************************
*                                                                         *
*     Program Filename:  reverse3.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  August 21, 2014                                  *
*     Purpose         :  To demonstrate the Stack Interface               *
*     Input from      :  none                                             *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/

public class reverse3
{
   public static void main(String[] args)
   {
      Stack2<Integer> S = new Stack2<Integer>();
      int SI, i;

      S.MakeEmpty();

      for (i = 0; i < 10; i++)
      {
         S.PushStack(i);
      }
      // end for

      while(!S.IsEmpty())
      {
         SI = S.PopStack();
         System.out.println(SI);
      }
      // end while
   }
   // end function main
}
// end class reverse3


