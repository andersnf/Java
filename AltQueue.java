public class Queue<QueueItem>
{
   private Object[] Array;
   private int Front, Rear, QueueMax;

   public Queue(int Capacity)
   {
      Array    = new Object[Capacity+1];
      QueueMax = Capacity;
      Front    = 0;
      Rear     = 0;
      return;
   }
   // end constructor

   public Queue()
   {
      Array    = new Object[1001];
      QueueMax = 1000;
      Front    = 0;
      Rear     = 0;
      return;
   }
   // end constructor

   public void Enqueue(QueueItem QI)
   {
      Array[Rear] = QI;

      if (Rear == QueueMax)
         Rear = 0;
      else
         Rear++;
      // end if

      if (Front == Rear)
      {
         System.out.println("Queue Overflow");
         System.exit(0);
      }
      // end if
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

      QI = (QueueItem) Array[Front];
      if (Front == QueueMax)
         Front = 0;
      else
         Front++;
      // end if

      return QI;
   }
   // end public method Dequeue

   public void MakeEmpty()
   {
      Front = 0;
      Rear  = 0;
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

   public boolean IsFull()
   {
      int F=Front, R=Rear+1;

      if (R == QueueMax+1)
         R = 0;
      // end if

      if (F == R)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsFull

   public int LengthQueue()
   {
      if (Front <= Rear)
         return Rear - Front;
      else
         return QueueMax - Front + Rear + 1;
      // end if
   }
   // end public method LengthQueue
}
// end class Queue
