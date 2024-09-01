/*  ==========================================================================
 **   Author: Joel Shameera Kumara 20963675
 **  Purpose: Implementation of Linked List
 **     Date: 06/10/22
 **Self-Cite: An older version of this code was previously submitted for Prac 4
 **  ==========================================================================
 */

import java.util.*;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{

    private class DSAListNode implements Serializable
    {

        private Object value;

        private DSAListNode prev, next;

        /** Constructor **/
        /*  --------------------------------------------------------------
         ** Constructor: Alternate
         **      Import: inValue (Object)
         **      Export: Memory adress of new DSAListNode
         **   Assertion: Assigns inValue to value ,null to prev and null to next
         */
        public DSAListNode( Object inValue )
        {
            value = inValue;
            prev = null;
            next = null;
        }

        /*  --------------------------------------------------------------
         **   Method: getValue()
         **      Import: none
         **      Export: value (Object)
         **   Assertion: Returns value
         */
        public Object getValue()
        {
            return value;
        }

        /*  --------------------------------------------------------------
         **   Method: getPrev()
         **      Import: none
         **      Export: prev (DSAListNode)
         **   Assertion: Returns prev
         */
        public DSAListNode getPrev()
        {
            return prev;
        }

        /*  --------------------------------------------------------------
         **   Method: getNext()
         **      Import: none
         **      Export: next (DSAListNode)
         **   Assertion: Returns next
         */
        public DSAListNode getNext()
        {
            return next;
        }

        /*  --------------------------------------------------------------
         **   Method: setValue()
         **      Import: Object inValue
         **      Export: none
         **   Assertion: assign inValue to value
         */

        public void setValue( Object inValue )
        {
            value = inValue;
        }

        /*  --------------------------------------------------------------
         **   Method: setPrev()
         **      Import: DSAListNode inListNode
         **      Export: none
         **   Assertion: assign inListNode to prev
         */
        public void setPrev( DSAListNode inListNode )
        {
            prev = inListNode;
        }

        /*  --------------------------------------------------------------
         **   Method: setNext()
         **      Import: DSAListNode inListNode
         **      Export: none
         **   Assertion: assign inListNode to next
         */
        public void setNext( DSAListNode inListNode )
        {
            next = inListNode;
        }
    }



    private class DSALinkedListIterator implements Iterator, Serializable
    {

        private DSAListNode iterNext;

        /** Constructor **/
        /*  --------------------------------------------------------------
         ** Constructor: Alternate
         **      Import: DSALinkedList linkedList
         **      Export: Memory adress of new DSAListIterator
         **   Assertion: Assigns list head to iterNext.
         */
        public DSALinkedListIterator( DSALinkedList linkedList )
        {
            iterNext = linkedList.head;
        }

        /*  --------------------------------------------------------------
         **   Method: hasNext()
         **      Import: none
         **      Export: boolean
         **   Assertion: returns true or false
         */

        public boolean hasNext()
        {
            return iterNext != null;
        }

        /*  --------------------------------------------------------------
         **   Method: Next()
         **      Import: none
         **      Export: value (Object)
         **   Assertion: returns true or false
         */
        public Object next()
        {
            Object value;

            if( iterNext == null )
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                //Get the value in the node
                iterNext = iterNext.getNext();
                //Ready for subsequent calls to next()
            }

            return value;
        }


        public void remove()
        {
            throw new UnsupportedOperationException( "Not supported" );
        }
    }



    private DSAListNode head, tail;

    private DSAListNode iterNext;

    /** Constructor **/
    /*  --------------------------------------------------------------
     ** Constructor: Alternate
     **      Import: DSALinkedList linkedList
     **      Export: Memory adress of new DSAListIterator
     **   Assertion: Assigns null to head, and null to tail
     */
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    /*  --------------------------------------------------------------
     **   Method: isEmpty()
     **      Import: none
     **      Export: empty (Boolean)
     **   Assertion: returns empty
     */
    public boolean isEmpty()
    {
        boolean empty = false;

        empty = head == null;

        return empty;
    }

    /*  --------------------------------------------------------------
     **   Method: getCount()
     **      Import: none
     **      Export: count (int)
     **   Assertion: returns count
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
     **   Method: peekFirst()
     **      Import: none
     **      Export: nodeValue (Object)
     **   Assertion: returns head
     */

    public Object peekFirst()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            nodeValue = head.getValue();
        }

        return nodeValue;
    }

    /*  --------------------------------------------------------------
     **   Method: peekLast()
     **      Import: none
     **      Export: nodeValue (Object)
     **   Assertion: returns tail
     */


    public Object peekLast()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    /*  --------------------------------------------------------------
     **   Method: insertFirst()
     **      Import: Object inValue
     **      Export: none
     **   Assertion: insert value to the list on top
     */
    public void insertFirst( Object inValue )
    {
        DSAListNode newNd = new DSAListNode( inValue );

        if( isEmpty() )
        {
            head = newNd;
            tail = newNd;
        }
        else
        {

            newNd.setNext( head );
            head.setPrev( newNd );
            head = newNd;
        }
    }

    /*  --------------------------------------------------------------
     **   Method: insertLast()
     **      Import: Object inValue
     **      Export: none
     **   Assertion: insert value to the list on bottom
     */
    public void insertLast( Object inValue )
    {
        DSAListNode newNd = new DSAListNode( inValue );

        if( isEmpty() )
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            tail.next = newNd;
            newNd.prev = tail;
            tail = newNd;
        }
    }

    /*  --------------------------------------------------------------
     **   Method: removeFirst()
     **      Import: none
     **      Export: none
     **   Assertion: delete value from the bottom of the list
     */
    public Object removeFirst()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if( head.getNext() == null )
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.next;
        }

        return nodeValue;
    }

    /*  --------------------------------------------------------------
     **   Method: removeLast()
     **      Import: none
     **      Export: none
     **   Assertion: delete value from the bottom of the list
     */

    public Object removeLast()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if( tail.getPrev() == null )
        {
            nodeValue = tail.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = tail.getValue();
            tail.prev.next = null;
            tail = tail.prev;
        }

        return nodeValue;
    }

    /*  --------------------------------------------------------------
     **   Method: removeNode()
     **      Import: Object inValue
     **      Export: none
     **   Assertion: delete node when node inserted
     */
    public void removeNode( Object inValue )
    {

        DSAListNode currNode;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            currNode = head;
            while( currNode != null )
            {
                if( !(currNode.value.equals( inValue )) )
                {
                    currNode = currNode.next;

                }
                else
                {
                    if( currNode.prev == null && currNode.next == null )
                    {
                        // 1-element list
                        head = null;
                        tail = null;
                    }
                    else if( currNode == head  )
                    {
                        removeFirst();

                    } else if (currNode == tail) {
                        removeLast();
                    } else
                    {
                        // Node to remove is not the head or the tail
                        currNode.prev.next = currNode.next;
                        currNode.next.prev = currNode.prev;
                    }

                    currNode = null;

                }
            }
        }

    }
    public Iterator iterator()
    {
        return new DSALinkedListIterator( this );
    }
}