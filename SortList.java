/**************************************************************************
*                                                                         *
*     Program Filename:  SortList.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 13, 2014                                *
*     Purpose         :  To sort a large file using the List class        *
*     Input from      :  unsorted.dat                                     *
*     Output to       :  sorted.dat                                       *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class SortList
{
   public static class ListItem implements Comparable<ListItem>
   {
      Integer Key;
      int     Count;

      public int compareTo(ListItem X)
      {
         return Key.compareTo(X.Key);
      }
      // end public method compareTo
   }
   // end class ListItem

   public static void main(String[] args) throws IOException
   {
      List<ListItem> L = new List<ListItem>();  
      ListItem LI, P;
      Scanner InFile = new Scanner(new File("unsorted.dat"));
      PrintWriter OutFile = new PrintWriter(new File("sorted.dat"));

      while (InFile.hasNext())
      {    
         LI = new ListItem();
         LI.Key = InFile.nextInt();
         P = L.SearchList(LI);  
         if (P == null)
         {
            LI.Count = 1;
            L.InsertList(LI);
         }
         else
         {
            LI = P;
            LI.Count++;
            L.UpdateList(LI);
         }
         // end if
      }
      // end while

      if (!L.EmptyList())
         L.ResetList();
      // end if


      while (!L.EndOfList())
      { 
         LI = L.GetList();
         for (int i = 1; i <= LI.Count; i++)
            OutFile.println(LI.Key);
         // end for
      }
      // end while

      InFile.close();
      OutFile.close();
   }
   // end main method
}
// end class SortList
