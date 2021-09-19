// ARTURO VILLALOBOS 
// UIN: 827088236
// CSCE 314 - 700
// PROFESSOR SHAWN LUPOLI
// Project 1 square lists


package squarelist;
public class SLL
{
    Node head; 
    int size_ = 0; 
    
    public class Node 
    {
        Integer data;
        Node next;
        
        Node(int d)
        { 
            data = d; 
        }
    }// end of node

    //=============================================================================
    public void set(int pos, Integer data)
    {
        Node curNode = this.head;
        for(int i =0; i< size_; i++)
        {
            if(pos == i )
            {
                curNode.data = data;
                return;
            }

            curNode = curNode.next;
        }
    }

    //=============================================================================
    public void insert(Integer data) // inserts at the end
    {
        Node newNode = new Node(data);
        newNode.next = null;

        if(this.head == null)
        {
            this.head = newNode;
            size_ +=1;
        }
        else
        {
            Node lastNode = this.head;
            while(lastNode.next != null)
            {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            size_+=1;
        }
    }// end of insert

    //=============================================================================
    public void insertAt(Integer data, int pos)
    {
        if( pos > size_ )
        {
            //this is the case where 
            //people try to insert in a not valid place
            //but also not at the end
            System.out.println("OUT OF BOUNDS"); 
            return;
        }
        if( pos == size_ )//position is at the end
        {
            this.insert(data);
            return;
        }
        if(pos == 0)//insert first
        {
            Node newNode = new Node(data);
            Node curNode = this.head;
            newNode.next = curNode;
            this.head = newNode;
            size_+=1;
            return;
        }
        if( pos < size_ )
        {
            Node newNode = new Node(data);
            Node curNode = this.head;
            for(int i = 0; i < pos-1 ; i++)
            {
                curNode = curNode.next;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
            size_+=1;
            return;
        }
    }// end of insertAt()

    //=============================================================================
    public int removeFirst()
    {
        int value = this.head.data;
        this.head = head.next;
        size_-=1;
        return value;
    }//end of removeFirst

    //=============================================================================
    public int removeAt(int pos)
    {
        if(pos == 0)
        {
            return this.removeFirst();
        }

        if( pos >= size_)
        {
            return -1;
        }

        if( size_-1 == pos)//if pos is at the tail
        {
            Node curNode = this.head;
            while(curNode.next.next != null)
            {
                curNode = curNode.next;
            }
            
            int value = curNode.next.data;
            curNode.next = null;
            size_-=1;
            return value;
        }

        Node curNode = this.head;
        for(int i = 0; i < pos-1 ; i++)
        {
            curNode = curNode.next;
        }
        int value = curNode.next.data;
        curNode.next = curNode.next.next;
        size_-=1;
        return value;
    }

    //=============================================================================
    public int indexOf(Integer data)
    {
        Node curNode = this.head;
        for(int i =0; i< size_; i++)
        {
            if(data == curNode.data )
            {
                return i;
            }

            curNode = curNode.next;
        }
        return -1;
    }

    //=============================================================================
    public static void printList(SLL list)
    {
        Node currNode = list.head;
        
        while (currNode != null) 
        {
            System.out.print(currNode.data + " \n");
            currNode = currNode.next;
        }
        System.out.print("\n");
    }// print list

    //=============================================================================
    public int getSize()
    {
        return size_;
    }// end of getSize()

    //=============================================================================
    public void setSize(int newSize)
    {
        this.size_ = newSize;
    }// end of getSize()

    //=============================================================================
    public Integer getValueAt(int pos)
    {
        Node curNode = this.head;
        for(int i = 0; i < pos ; i++)
        {
            curNode = curNode.next;
        }
        int value = curNode.data;
        return value;
    }

    //=============================================================================
    public Node getHeadNode()
    {
        return this.head;
    }

    //=============================================================================
    public void setTailNode(Node additionNode)
    {
        Node lastNode = this.head;
        while(lastNode.next != null)
        {
            lastNode = lastNode.next;
        }
        lastNode.next = additionNode;
    }

    //=============================================================================
    public void setHead(Node newHead)
    {
        this.head = newHead;
    }
    
 
    
    
    // public static void main(String[] args)
    // {
    //     /* Start with the empty list. */
    //     SLL list = new SLL();
    //     list.insert(1);
    //     list.insert(2);
    //     list.insert(3);
    //     list.insert(4);
    //     list.insert(5);
    //     list.insert(6);
    //     list.insert(7);
    //     list.insert(8);
    //     list.insertAt(9,2);
    //     list.insertAt(10, 9);
    //     // Print the LinkedList
    //     printList(list);

    //     int val1 = list.removeFirst();
    //     System.out.println("This is the value after removing the first node: " + val1 + "\n");
    //     printList(list);

    //     int val2 = list.removeAt(5);
    //     System.out.println("This is the value after removing the fifth node: " + val2 + "\n");
    //     printList(list);

    //     int val3 = list.getValueAt(0);
    //     System.out.println("This is the value of the oth node: " + val3 + "\n");

    //     list.set(0,45);
    //     System.out.println("SETTING 0TH NODE TO 45:");
    //     printList(list);


    // }// end of main 

}// end of class SLL