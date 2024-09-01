/*  ==========================================================================
 **   Author: Joel Shameera Kumara 20963675
 **  Purpose: Implementation of Stack
 **     Date: 06/10/22
 **Self-Cite: An older version of this code was previously submitted for Prac 4
 **  ==========================================================================
 */
import java.util.*;

public class DSAstack implements Iterable
{

    private DSALinkedList stack;

    /** Constructor **/
    /*  --------------------------------------------------------------
     ** Constructor: Alternate
     **      Import: none
     **      Export: Memory adress of new DSAstack
     **   Assertion: creates new DSALinkedList variable
     */
    public DSAstack()
    {
        stack = new DSALinkedList();
    }


    /*  --------------------------------------------------------------
     **      Method: top()
     **      Import: none
     **      Export: stack.peekFirst (DSALinkedList)
     **   Assertion: Returns top value
     */
    public Object top()
    {
        if( isEmpty() )
        {
            throw new IllegalArgumentException( "Stack is empty" );
        }

        return stack.peekFirst();
    }

    /*  --------------------------------------------------------------
     **      Method: getCount()
     **      Import: none
     **      Export: count (int)
     **   Assertion: Returns count
     */
    public int getCount()
    {
        int count = 0;

        for( Object o : this )
        {
            count++;
        }

        return count;
    }
    /*  --------------------------------------------------------------
     **      Method: isEmpty()
     **      Import: none
     **      Export: boolean
     **   Assertion: return boolean true or false
     */

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    /*  --------------------------------------------------------------
     **      Method: push()
     **      Import: Object inObject
     **      Export: none
     **   Assertion: insert value to Object
     */
    public void push( Object inObject )
    {
        stack.insertFirst( inObject );
    }


    /*  --------------------------------------------------------------
     **      Method: pop()
     **      Import: none
     **      Export: none
     **   Assertion: delete value to Object
     */
    public Object pop()
    {
        return stack.removeFirst();
    }

    /*  --------------------------------------------------------------
     **      Method: iterator()
     **      Import: none
     **      Export: iterator(Iterator)
     **   Assertion: iterator object
     */

    public Iterator iterator()
    {
        return stack.iterator();
    }
}
