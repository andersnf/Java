public class List<ListItem>
{
   private class ListNode
   {
      ListNode   Rlink;
      Comparable Content;
      ListNode   Llink;
   }
   // end class ListNode

   private char Dir;
   private ListNode Head, Cursor, SearchPtr;
   private Stack<ListNode> Ancestors = new Stack<ListNode>();

   public List()
   {
      Head = new ListNode();
      Head.Llink  = null;
      Head.Rlink = null;
      Cursor = Head;
   }
   // end constructor

   public void MakeList()
   {
      Head.Rlink = null;
      return;
   }
   // end public method MakeList

   public boolean EmptyList()
   {
      if (Head.Rlink == null)
         return true;
      else
         return false;
      // end if
   }
   // end public method EmptyList

   public int LengthList()
   {
      return NodeCount(Head.Rlink);
   }
   // end public method LengthList

   private int NodeCount(ListNode T)
   {
      if (T == null)
         return 0;
      // end if

      int LeftCount=0, RightCount=0;

      if (T.Llink != null)
         LeftCount = NodeCount(T.Llink);
      // end if

      if (T.Rlink != null)
         RightCount = NodeCount(T.Rlink);
      // end if

      return LeftCount+RightCount+1;
   }
   // end private method NodeCount

   public void ResetList()
   {
      if (Head.Rlink == null)
      {
         System.out.println("Reset Error: List is Empty!");
         System.exit(0);
      }
      // end if

      Cursor = Head;
      Ancestors.MakeEmpty();
   }
   // end public method ResetList

   public boolean EndOfList()
   {
      return (Cursor.Rlink == null && Ancestors.IsEmpty());
   }
   // end public methos EndOfList

   public ListItem GetList()
   {
      if (Cursor.Rlink != null)
      {
         Cursor = Cursor.Rlink;
         while (Cursor.Llink != null)
         {
            Ancestors.PushStack(Cursor);
            Cursor = Cursor.Llink;
         }
         // end while
      }
      else if (!Ancestors.IsEmpty())
         Cursor = Ancestors.PopStack();
      else
      {
         System.out.println("Error: Attempt to traverse beyond end of list!");
         System.exit(0);
      }
      // end if
      return (ListItem) Cursor.Content;
   }
   // end public method GetList

   private boolean FindList(ListItem LI)
   {
      ListNode P;
      boolean  found;
      Comparable X = (Comparable) LI;

      SearchPtr = Head;
      P = SearchPtr.Rlink;
      Dir = 'R';
      found = false;

      while (P != null && !found)
      {
         if (X.compareTo(P.Content) < 0)
         {
            SearchPtr = P;
            P = P.Llink;
            Dir = 'L';
         }
         else if (X.compareTo(P.Content) > 0)
         {
            SearchPtr = P;
            P = P.Rlink;
            Dir = 'R';
         }
         else
            found = true;
         // end if
      }

      return found;
   }
   // end private method FindList

   public ListItem SearchList(ListItem LI)
   {
      if (FindList(LI) && Dir == 'L')
         return (ListItem) SearchPtr.Llink.Content;
      else if (FindList(LI) && Dir == 'R')
         return (ListItem) SearchPtr.Rlink.Content;
      else
         return null;
      // end if
   }
   // end public method SearchTree

   public void InsertList(ListItem LI)
   {
      ListNode P;

      if (FindList(LI))
      {
         System.out.println("Insert Error: Duplicate Key Field!");
         System.exit(0);
      }
      else
      {
         P = new ListNode();
         P.Content = (Comparable) LI;
         P.Llink = null;
         P.Rlink = null;
         if (Dir == 'L')
            SearchPtr.Llink = P;
         else
            SearchPtr.Rlink = P;
         // end if
      }
      // end if
   }
   // end public method InsertList

   public void UpdateList(ListItem LI)
   {
      if (!FindList(LI))
      {
         System.out.println("Update Error: Record Not Found!");
         System.exit(0);
      }
      // end if

      if (Dir == 'L')
         SearchPtr.Llink.Content = (Comparable) LI;
      else
         SearchPtr.Rlink.Content = (Comparable) LI;
      // end if
   }
   // end public method UpdateList

   public void DeleteList(ListItem LI)
   {
      if (!FindList(LI))
      {
         System.out.println("Delete Error: Record Not Found!");
         System.exit(0);
      }
      // end if

      if (Dir == 'L')
         SearchPtr.Llink = DeleteRoot(SearchPtr.Llink);
      else
         SearchPtr.Rlink = DeleteRoot(SearchPtr.Rlink);
      // end if
   }
   // end public method DeleteList

   private ListNode DeleteRoot(ListNode P)
   {
      ListNode Q, R;

      Q = P;
      if (P.Llink == null)
         P = P.Rlink;
      else if (P.Rlink == null)
         P = P.Llink;
      else if (P.Llink.Rlink == null)
      {
         P.Llink.Rlink = P.Rlink;
         P = P.Llink;
      }
      else
      {
         R = P.Llink;
         Q = R.Rlink;
         while (Q.Rlink != null)
         {
            R = Q;
            Q = Q.Rlink;
         }
         // end while
         P.Content = Q.Content;
         R.Rlink = Q.Llink;
      }
      // end if

      return P;
   }
   // end private method DeleteRoot
}
// end class List
