public class Stack2<StackItem>
{
   private class StackNode
   {
      StackItem Content;
      StackNode Link;
   }
   // end class StackNode

   private StackNode Top;

   public Stack2()
   {
      Top = null;
   }
   // end constructor
   
   public void PushStack(StackItem SI)
   {
      StackNode Temp;

      Temp = Top;
      Top = new StackNode();
      Top.Content = SI;
      Top.Link = Temp;
      return;
   }
   // end public method PushStack

   public StackItem PopStack()
   {
      StackItem SI;

      if (Top == null)
      {
         System.out.println("Stack Underflow!");
         System.exit(0);
      }
      // end if

      SI   = Top.Content;
      Top  = Top.Link;

      return SI;
   }
   // end public method PopStack

   public void MakeEmpty()
   {
      Top = null;
      return;
   }
   // end public method MakeEmpty

   public boolean IsEmpty()
   {
      if (Top == null)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsEmpty
}
// end class Stack2
