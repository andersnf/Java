public class List<ListItem> 
{
   private class ListNode
   {
      Comparable  Content;
      ListNode    Link;
   }
   // end class ListNode

   private ListNode Head, Cursor, SearchPtr;

   public List()
   {
      Head      = new ListNode();
      Head.Link = Head;
      Cursor    = Head;
   }
   // end constructor

   public void MakeList()
   {
      Head.Link = Head;
      Cursor    = Head;
   }
   // end public method MakeList

   public boolean EmptyList()
   {
      if (Head == Head.Link)
         return true;
      else
         return false;
      // end if
   }
   // end public method EmptyList

   public void ResetList()
   {
      if (Head == Head.Link)
      {
         System.out.println("Reset Error: List is empty!");
         System.exit(0);
      }
      else
         Cursor = Head.Link;
      // end if
   }
   // end public method ResetList

   public ListItem GetList()
   {
      ListItem LI;
      LI = (ListItem) Cursor.Content;
      Cursor = Cursor.Link;
      return LI;
   }
   // end public method GetList

   public boolean EndOfList()
   {
      if (Cursor == Head)
         return true;
      else
         return false;
      // end if
   }
   // end public method EndOfList

   public void InsertList(ListItem LI)
   {
      ListNode P;

      if (FindList(LI))
      {
         System.out.println("Insert Error!");
         System.exit(0);
      }
      else
      {
         P = new ListNode();
         P.Content = (Comparable) LI;
         P.Link = SearchPtr.Link;
         SearchPtr.Link = P;
      }
      // end if
   }
   // end public method InsertList

   public void DeleteList(ListItem LI)
   {
      ListNode P;

      if (!FindList(LI))
      {
         System.out.println("Delete Error!");
         System.exit(0);
      }
      else
      {
         P = SearchPtr.Link;
         SearchPtr.Link = P.Link;
      }
      // end if
   }
   // end public method DeleteList

   public void UpdateList(ListItem LI)
   {
      if (!FindList(LI))
      {
         System.out.println("Update Error!");
         System.exit(0);
      }
      else
      {
         SearchPtr = SearchPtr.Link;
         SearchPtr.Content = (Comparable) LI;
      }
      // end if
   }
   // end public method UpdateList

   public ListItem SearchList(ListItem LI)
   {
      if (FindList(LI))
         return (ListItem) SearchPtr.Link.Content;
      else
         return null;
      // end if
   }
   // end public method SearchList

   public int LengthList()
   {
      ListNode P;
      int Counter=0;

      P = Head;
      while (P.Link != Head)
      {
         Counter++;
         P = P.Link;
      }
      // end while
      return Counter;
   }
   // end public method LengthList

   private boolean FindList(ListItem LI)
   {
      ListNode LookAheadPtr;
      Comparable X = (Comparable) LI;

      SearchPtr = Head;
      LookAheadPtr = SearchPtr.Link;

      while (LookAheadPtr != Head && X.compareTo(LookAheadPtr.Content) > 0)
      {
         SearchPtr = SearchPtr.Link;
         LookAheadPtr = LookAheadPtr.Link;
      }
      // end while

      if (LookAheadPtr != Head && X.compareTo(LookAheadPtr.Content) == 0)
         return true;
      else
         return false;
      // end if
   }
   // end private method FindList
}
// end class List
