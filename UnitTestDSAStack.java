public class UnitTestDSAStack
{
    public static void main(String[] args)
    {
         testStack();
    }
    public static void testStack()
    {
        DSAstack stack = new DSAstack();
        System.out.println("Pushing numbers from 1-5 to the Stack");

        //Populating Stack
        for( int i = 0; i < 5; i++ )
        {
            stack.push( i );
        }

        // Pop/Top Test
        System.out.println( "Testing pop and top" );
        String outStr = new String();
        if(stack.top().equals(4))
        {
            System.out.println("Returned 4,Expected 4,Top Works. ");
        }
        else {
            System.out.println("Top Does Not Work.");
        }
        if( stack.getCount() == 5 )
        {
            outStr += "Count works";
        }
        else
        {
            outStr += "Count doesn't work";
        }
        outStr += " (Expected " + 5 + ", actual " + stack.getCount() + ") ";

        stack.pop();
        if( stack.getCount() == 4 )
        {
            outStr += "Pop works";
        }
        else
        {
            outStr += "Pop doesn't work";
        }
        outStr += " (Expected " + 4 + ", actual " + stack.getCount() + ") ";
        System.out.println( outStr  );

        // Empty Test
        System.out.println( "Testing emptiness" );
        while( !stack.isEmpty() )
        {
            System.out.println( "Popping value " + stack.getCount() );
            stack.pop();
        }
        System.out.println( "It's empty" );

        System.out.println( "Attempting to remove further" );
        try
        {
            stack.pop();
            System.out.println( "No exception thrown :(" );
        }
        catch( Exception e )
        {
            System.out.println( "Exception was thrown" );
        }

        System.out.println( "All tests completed" );
    }
}
