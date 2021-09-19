// ARTURO VILLALOBOS 
// UIN: 827088236
// CSCE 314 - 700
// PROFESSOR SHAWN LUPOLI
// Project 1 square lists

// CONDITION 1
//Every inner list has ≤ 2 √n items.

//CONDITION 2
//There are no adjacent short inner lists, where short is defined as having ≤ √n/2 items.

//CONDITION 3
//if Condition 2 holds, then the top-level list cannot have more than 4√n items.


//-----CONSOLIDATION-----
// 1.) 
//   Traverse the top-level list.
// 2.)
//  Whenever an empty inner list is encountered, removethat inner list.
// 3.)
//  Whenever two adjacent short inner lists are encountered, (≤ √n/2)
//  merge them into a single inner list.(See Figures 2 and 3.)
// 4.)
//  Whenever an inner list is found to have more than2 √n items, 
//  split them into twolists of equal length. (See Figure 4.)


package squarelist;

import java.util.LinkedList;
import java.util.Random;
import java.lang.Math;

public class SquareList
{
    LinkedList<SLL> upper_list = new LinkedList<SLL>(); 
    int total_size_ = 0;
    int inner_list_upper_limit = (int) (2* Math.sqrt(total_size_));
    int inner_list_lower_limit = (int) ( Math.sqrt(total_size_)/2 );

    public SquareList() {}
    //=========================================================================

    //=========================================================================
    public Integer remove(int pos)
    {
        if(pos < 0)
        {
            return null;
        }
        if(pos > this.total_size_)
        {
            return null;
        }
        if(pos == 0)
        {
            return this.removeFirst();
            
        }

        int val = 0;
        for(int i = 0; i < this.upper_list.size() ; i++)
        {
            if(pos < this.upper_list.get(i).getSize())
            {
                val = this.upper_list.get(i).removeAt(pos);
                this.total_size_-=1;
                this.cal_limits();
                this.consolidate();
                return val;
            }
            pos = pos - this.upper_list.get(i).getSize();

        }
        return null;
    }

    //=========================================================================
    public Integer removeFirst ()
    {
        if(this.total_size_ == 0)
        {
            return null;
        }
        Integer value = this.upper_list.getFirst().removeFirst();
        this.total_size_-=1;
        this.consolidate();
        return value;
    }

    //=========================================================================
    public void set(int pos, Integer data)
    {
        if(pos < 0)
        {
            return;
        }
        if(pos >= this.total_size_)
        {
            return;
        }
        
        for(int i = 0; i < this.upper_list.size() ; i++)
        {
            
            if(pos < this.upper_list.get(i).getSize())
            {
                this.upper_list.get(i).set(pos, data);
                return;
            }
            pos = pos - this.upper_list.get(i).getSize();

        }
        return;
    }

    //=========================================================================
    public Integer get(int pos)
    {
        if(pos < 0)
        {
            return null;
        }
        if(pos >= this.total_size_)
        {
            return null;
        }
        Integer value;
        //int temp_total = 0;
        for(int i = 0; i < this.upper_list.size() ; i++)
        {
            
            if(pos < this.upper_list.get(i).getSize())
            {
                value = this.upper_list.get(i).getValueAt(pos);
                return value;
            }
            pos = pos - this.upper_list.get(i).getSize();

        }
        return null;
    }

    //=========================================================================
    public void add(int pos, Integer data)
    {
        if(pos < 0)
        {
            return;
        }
        if(pos > this.total_size_)
        {
            return;
        }
        if(pos == this.total_size_)
        {
            this.addLast(data);//adds one by itself
            return;
        }
        if(pos == 0)
        {
            this.addFirst(data);//adds one by itself
            return;
        }

        //int temp_total = 0;
        for(int i = 0; i < this.upper_list.size() ; i++)
        {
            //temp_total += this.upper_list.get(i).getSize();
            if(pos <= this.upper_list.get(i).getSize())
            {
                this.upper_list.get(i).insertAt(data,pos);
                this.total_size_+=1;
                this.consolidate();
                return;
            }
            pos = pos - this.upper_list.get(i).getSize();

        }
    }

    //=========================================================================
    public void addFirst(Integer data)
    {
        if(this.total_size_ == 0)
        {
            SLL temp_singly = new SLL();
            temp_singly.insertAt(data,0);
            this.upper_list.addFirst(temp_singly);
            this.total_size_+=1;
            this.cal_limits();
            return;
        }
        if(this.total_size_ == 1 )
        {
            this.upper_list.getFirst().insertAt(data,0);
            this.total_size_+=1;
            this.cal_limits();
            return;
        }
        if(this.total_size_ > 1 )
        {
            this.upper_list.getFirst().insertAt(data,0);
            this.total_size_+=1;
            this.cal_limits();
            this.consolidate();
            return;
        }
    }

    //=========================================================================
    public void addLast(Integer data)
    {
        if(this.total_size_ == 0)// same as add first in this case
        {
            SLL temp_singly = new SLL();
            temp_singly.insertAt(data,0);
            this.upper_list.addFirst(temp_singly);
            this.total_size_+=1;
            this.cal_limits();
            return;
        }
        if(this.total_size_ == 1 )//inserts the elemnt to the last SSL at the end
        {
            this.upper_list.getLast().insert(data);
            this.total_size_+=1;
            this.cal_limits();
            return;
        }
        if(this.total_size_ > 1 )
        {
            this.upper_list.getLast().insert(data);
            this.total_size_+=1;
            this.cal_limits();
            this.consolidate();
            return;
        }
    }

    //=========================================================================
    public static void printSL(SquareList SQlist)
    {
        for (int i = 0; i < SQlist.upper_list.size(); i++)
        {
            System.out.println("\n\nInner List: " + i + "::has a size of:: " + SQlist.upper_list.get(i).getSize());
            SLL.printList(SQlist.upper_list.get(i));
        }
        System.out.println("\tTOTAL ELEMENTS IN SquareList ::: " + SQlist.size() + "\n\n");
        //System.out.println("\n");
    }// print list

    //=========================================================================
    public void consolidate()
    {
        for (int i = 0; i < this.upper_list.size(); i++)
        {
            if(this.upper_list.get(i).getSize() > this.inner_list_upper_limit )
            {
                //SPLT
                this.split(this.upper_list.get(i),i);
                //System.out.println("\t===SUCCESS===\n\tUPPER LIST SPlIT\n");
                
            }//SPLIT
            if(this.upper_list.get(i).getSize() <= this.inner_list_lower_limit )
            {
                //MERGE
                
                try
                {
                    if(this.upper_list.get(i+1).getSize() <= this.inner_list_lower_limit )
                    {
                        this.merge(this.upper_list.get(i), this.upper_list.get(i+1),i);
                    }
                    //System.out.println("\t===SUCCESS===\n\tUPPER LIST MERGED\n");
                    
                }
                catch(Exception e)
                {
                    //System.out.println("===ERROR===\nUPPER LIST TOO SHORT FOR MERGING.\n");
                }
                
            }//MERGE
            if(this.upper_list.get(i).getSize() == 0)
            {
                this.upper_list.remove(i);
            }

        }//TRAVERSAL LOOP
    }

    //=========================================================================
    public void merge(SLL leftList, SLL rightList, int pos)
    {
        int newSize = leftList.getSize() + rightList.getSize();
        SLL newList = new SLL();
        newList.setHead(leftList.getHeadNode()) ;
        newList.setTailNode(rightList.getHeadNode());
        newList.setSize(newSize);
        this.upper_list.set(pos,newList);
        this.upper_list.remove(pos+1);
        return;
    }

    //=========================================================================
    public void split(SLL list, int pos)
    {
        
        int newRightSize = list.getSize()/2;
        int newLeftSize = list.getSize() - newRightSize;
        SLL leftList = new SLL();
        SLL rightList = new SLL();

        
        for(int i =0; i < newLeftSize ; i++)
        {
            leftList.insert(list.getValueAt(i));
        }

        for(int i = newLeftSize; i < list.getSize() ; i++)
        {
            rightList.insert(list.getValueAt(i));
        } 

        this.upper_list.set(pos,leftList);
        this.upper_list.add(pos+1,rightList);
    }

    //=========================================================================
    public void cal_limits()
    {
        this.inner_list_lower_limit = (int) ( Math.sqrt(this.total_size_)/2 );
        this.inner_list_upper_limit = (int) (2* Math.sqrt(this.total_size_));
    }

    //=========================================================================
    public int size()
    {
        return total_size_;
    }

    //=========================================================================
    public int indexOf(Integer data)
    {
        int indexval = 0;   
        int temp_total = 0;
        for(int i = 0; i < this.upper_list.size() ; i++)
        {

            temp_total += this.upper_list.get(i).getSize();
            if(this.upper_list.get(i).indexOf(data) != -1 )
            {
                indexval = this.upper_list.get(i).indexOf(data);
                return indexval + (temp_total-this.upper_list.get(i).getSize());
            }
        }
        return -1;
    }

    //=========================================================================
    public void dump()
    {
        printSL(this);
    }




    //=========================================================================
    // public static void main(String[] args)
	// {
	// 	SquareList list = new SquareList();

    //     Random rand = new Random(); //instance of random class
    //     int upperbound = 25;
    //     //generate random values from 0-24
    //     //int int_random = rand.nextInt(upperbound); 

    //     for(int i  = 0 ; i < 10; i++)
    //     {
    //         // int int_random = rand.nextInt(upperbound); 
    //         // if(i % 2 ==0)
    //         // {
    //         //     list.addFirst(int_random);
    //         //     printSL(list);
    //         // }
    //         // else
    //         // {
    //         //     list.addLast(int_random);
    //         //     printSL(list);
    //         // }
    //         list.addFirst(i);
    //         //printSL(list);
    //     }
        
    //     //System.out.println("First value: " + list.removeFirst());
    //     //printSL(list);
    //     list.add(5,666);
    //     //printSL(list);

    //     //System.out.println("lastth value: " + list.get(list.size()-1) + "\n");
    //     //printSL(list);

    //     //System.out.println("Setting pos 4 to value: 1515\n");
    //     list.set(8,4);
    //     //printSL(list);

    //     //System.out.println("Index of value 0: "+ list.indexOf(0));

    //     Integer valremoved = list.remove(list.size()-1);
    //     //printSL(list);
    //     //System.out.println("Valiue removed at the end is : " + valremoved);
    //     valremoved = list.remove(list.size()-1);
    //     //printSL(list);
    //     list.dump();


	// }//end main

}//end class 

