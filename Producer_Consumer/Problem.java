// queue class acts as mediator and allows other classes to communicate with each other
class Queue
{
    int x;
    boolean valueInX=false;   // any name is possible

    synchronized void put(int j)   // any name can be given to method
    {
        try{
            if(valueInX==true)
            {
                wait();    // it will lead to exceptions so we handled it.
            }

            else{
                x=j;    // assign value of j into x
                System.out.println("I have produced the data into x " + x);
                valueInX=true;
                notify();
            }

        }
        catch(Exception e)
        {
            System.out.println("Some problem is there");

        }
           
    }

    synchronized void get()
    {
        try{
            if(valueInX==false)
            {
                wait();  // it moves the program into waiting stage
            }
            else{
                System.out.println("I have consumed the data x " + x);
                valueInX=false;
                notify();  // it gets the program out of waiting stage
            }

        }
        catch(Exception e)
        {
            System.out.println("Some problem is there");

        }
        
    }

}

class Producer extends Thread
{
    Queue q;     // object of type queue

    Producer(Queue b)   // constructor creation with parameter of queue type
    {
        q=b;
    }

  public void run()
  {
    int i=1;
    while(true)    // making infinite loop as required 
    {
        q.put(i++);
    }
  }

}

class Consumer extends Thread
{
    Queue q;

    Consumer(Queue a)
    {
        q=a;
    }

    public void run()
    {
        while(true)
        {
            q.get();
        }
       
    }
}

public class Problem
{
    public static void main(String[] args) 
    {
         Queue q=new Queue();

         Producer p=new Producer(q);
         Consumer c=new Consumer(q);

         p.start();
         c.start();
    }
    
}