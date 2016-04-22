public class Queue<QueueItem>
{
   private class QueueNode
   {
      QueueItem Content;
      QueueNode Link;
   }
   // end class QueueNode

   private QueueNode Front, Rear;

   public Queue()
   {
      Front = new QueueNode();
      Rear  = Front;
      Front.Link = null;
   }
   // end constructor

   public void Enqueue(QueueItem QI)
   {
      QueueNode Temp;

      Temp = Rear;
      Rear = new QueueNode();
      Rear.Content = QI;
      Rear.Link = null;
      Temp.Link = Rear;
      return;
   }
   // end public method Enqueue

   public QueueItem Dequeue()
   {
      QueueItem QI;

      if (Front == Rear)
      {
         System.out.println("Queue Underflow!");
         System.exit(0);
      }
      // end if

      Front = Front.Link;
      QI = Front.Content;
      return QI;
   }
   // end public method Dequeue

   public void MakeEmpty()
   {
      Front.Link = null;
      Rear = Front;
      return;
   }
   // end public method MakeEmpty

   public boolean IsEmpty()
   {
      if (Front == Rear)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsEmpty

   public int LengthQueue()
   {
      QueueNode Temp;
      int Count;

      Count = 0;
      Temp = Front;

      while (Temp.Link != null)
      {
         Count++;
         Temp = Temp.Link;
      }
      // end while

      return Count;
   }
   // end public method LengthQueue

   public void SwitchEnds()
   {
      QueueNode P;
      QueueItem Temp;

      P = Front.Link;
      if (P == null || P == Rear)
         return;
      // end if

      Temp         = P.Content;
      P.Content    = Rear.Content;
      Rear.Content = Temp;

      return;
   }
   // end public method SwitchEnds

   public void Equalize(Queue<QueueItem> Q)
   {
      QueueNode   Temp;
      int         Length1, Length2, NumberLeftInLongerQueue;

      Length1 = this.LengthQueue();
      Length2 = Q.LengthQueue();

      if (Length1 < Length2)
      {
         Q.Equalize(this);
         return;
      }
      // end if

      if (Length1 - Length2 <= 1)
         return;
      // end if

      NumberLeftInLongerQueue = Length1 - (Length1 - Length2)/2;
      Temp = Rear;
      Rear = Front;
      for (int i = 1; i <= NumberLeftInLongerQueue; i++)
         Rear = Rear.Link;
      // end for
      Q.Rear.Link = Rear.Link;
      Q.Rear = Temp;
      Rear.Link = null;

      return;
   }
   // end public method Equalize
}
// end class Queue
