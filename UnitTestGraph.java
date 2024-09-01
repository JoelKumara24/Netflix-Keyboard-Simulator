import java.io.IOException;

public class UnitTestGraph
{
    public static void main(String[] args) throws IOException {

        DSAGraph graph = new DSAGraph();
        System.out.println("Inserting to file to graph.");
        System.out.println("=====Testing addVertex=====");
        graph.loadfile("prac6_2.al");
        System.out.println( "Adjacency list: " );
        graph.displayAsList();
        System.out.println();
        System.out.println( "\nExpected adjacency list:\n" +
                "A  |  B  D  E\n" +
                "B  |  A  C  E\n" +
                "D  |  A  C\n" +
                "E  |  A  B  C\n" +
                "C  |  B  D  E\n" );
        System.out.println();
        System.out.println( "\nAdjacency matrix: " );
        graph.displayAsMatrix();
        System.out.println();
        System.out.println("\nExpected adjacency matrix:\n" +
                "  | A | B | D | E | C\n" +
                "A | 0 | 1 | 1 | 1 | 0\n" +
                "B | 1 | 0 | 0 | 1 | 1\n" +
                "D | 1 | 0 | 0 | 0 | 1\n" +
                "E | 1 | 1 | 0 | 0 | 1\n" +
                "C | 0 | 1 | 1 | 1 | 0");
        System.out.println();
        System.out.println("=====Testing has vertex=====");
        System.out.println( "Testing for vertex A: " + graph.hasVertex( "A" )
                + " (Expected: true)" );
        System.out.println( "Testing for vertex Z: " + graph.hasVertex( "Z" )
                + " (Expected: false)" );
        System.out.println("=====Testing getVertexCount=====");
        System.out.println( "Vertex count: " + graph.getVertexCount() +
                " (Expected: 5)" );
        System.out.println("=====Testing getEdgeCount=====");
        System.out.println( "Edge count: " + graph.getEdgeCount() +
                " (Expected: 14)" );
        System.out.println("=====Testing getLabel=====");
        System.out.println( "Testing for vertex A:" );
        System.out.println( "Found with label " + graph.getVertex( "A" ) +
                " (Expected: A)" );

        System.out.println( "\nTesting for vertex not in graph:" );
        graph.getVertex( "Z" );
        System.out.println("=====Testing getAdjacent=====");
        System.out.println( "Testing for vertex E:" );
        System.out.println();

        for( Object o : graph.getAdjacent("E") )
        {
            System.out.print( o + "  " );
        }
        System.out.println();
        System.out.print("Expected: A  B  C");
        System.out.println();
        System.out.println("=====Testing isAdjacent=====");
        System.out.println();
        System.out.println("Testing for vertex A and B");
        if(graph.isAdjacentS("A","B"))
        {
            System.out.println("  True");
        }
        else
        {
            System.out.println("  False");
        }
        System.out.println("Expected: True");
        System.out.println("Testing for vertex B and D");
        if(!graph.isAdjacentS("B","D"))
        {
            System.out.println("  False");
        }
        else
        {
            System.out.println("  True");
        }
        System.out.println("Expected: False");

        System.out.println("=====Testing addVertex=====");
        System.out.println("Checking if the vertex to be added is already in the graph:");
        System.out.println( "Testing for vertex Z: " + graph.hasVertex( "Z" )
                + " (Expected: false)" );
        System.out.println();
        System.out.println("Adding Z to the graph:");
        graph.addVertex("Z");
        System.out.println( "Testing for vertex Z: " + graph.hasVertex( "Z" )
                + " (Expected: true)" );
        System.out.println();

        System.out.println("=====Testing addEdge=====");

        System.out.println("Testing if vertex B and D are already connected");
        if(!graph.isAdjacentS("B","D"))
        {
            System.out.println("  False");
        }
        else
        {
            System.out.println("  True");
        }
        System.out.println("Expected: False");

        System.out.println("Adding Edge B and D ");
        graph.addEdge("B","D");
        System.out.println();
        System.out.println("Testing if vertex B and D are connected after:");
        if(graph.isAdjacentS("B","D"))
        {
            System.out.println("  True");
        }
        else
        {
            System.out.println("  False");
        }
        System.out.println("Expected: True");
        System.out.println();
        System.out.println("=====Testing removeVertex=====");
        System.out.println("Testing if Z in the graph:");
        System.out.println( "Testing for vertex Z: " + graph.hasVertex( "Z" )
                + " (Expected: true)" );
        System.out.println("Removing Z from the graph:");
        graph.removeVertex("Z");
        System.out.println( "Testing for vertex Z: " + graph.hasVertex( "Z" )
                + " (Expected: False)" );

        System.out.println();

        System.out.println("=====Testing removeEdge=====");

        System.out.println("Testing if vertex B and D areconnected");
        if(graph.isAdjacentS("B","D"))
        {
            System.out.println("  True");
        }
        else
        {
            System.out.println("  False");
        }
        System.out.println("Expected: True");

        System.out.println("Removing Edge B and D ");
        graph.removeEdge("B","D");
        System.out.println();
        System.out.println("Testing if vertex B and D are removed after:");
        if(graph.isAdjacentS("B","D"))
        {
            System.out.println("  True");
        }
        else
        {
            System.out.println("  False");
        }
        System.out.println("Expected: False");
        System.out.println();

        System.out.println("=====Testing updateNode=====");
        System.out.println("Check if the to be Updated node is in the graph:(A)");
        System.out.println();
        graph.displayAsList();
        System.out.println();
        System.out.println("Updating node (A) to (AA)");
        graph.updateNode("A","AA");
        System.out.println("Checking if the node is updated:");
        graph.displayAsList();
        System.out.println();
        System.out.println("=====Testing printing Paths=====");
        System.out.println("Testing for the word 'BED'");
        String name= "BED";
        allPaths(graph,name);
        System.out.println("\n EXPECTED \n" +
                "\nThe shortest path of the Entered String :B-E-E-C-D\n" +
                "Total Moves of the Shortest Path:5"
        );

    }

    public static String[] allPaths(DSAGraph G,String bfs)
    {


        G.setLengthCheck();
        DSALinkedList ShortestP ;
        DSALinkedList ShortesstStr ;
        String pathStr = "";

        char[] ch = new char[bfs.length()];
        for (int i = 0; i < bfs.length(); i++) {
            ch[i] = bfs.charAt(i);
        }
        G.passLength(bfs.length());
        int[] pCount = new int[10];
        int[] pSum = new int[10];
        String[] lil = new String[10];
        String[] pass = new String[10];
        pass[0] = "";
        String[][] every = new String[10][ch.length];
        int[][] allC = new int[10][ch.length];

        int i = 0;
        int j = 0;
        int totMoves = 0;
        for(i=0;i < ch.length-1;i++)
        {
            G.godfs(String.valueOf(ch[i]),String.valueOf(ch[i+1]));
            int moves = G.getMin();
//            System.out.println();
//            System.out.print( "The shortest path from "+ch[i]+" to "+ch[i+1]+" :" );
            G.printShortest();
            pCount = G.getAllPCcount();
            lil = G.getAllPC();
            for(j=0;j<10;j++)
            {
                every[j][i] = lil[j];
            }

            for(j=0;j<10;j++)
            {
                allC[j][i] = pCount[j];
            }

            totMoves = totMoves + moves;

        }




        for(i=0;i<10;i++)
        {
            for(j=0;j<ch.length-1;j++)
            {
                pSum[i] = pSum[i]+allC[i][j];
            }
        }
//        System.out.println("INT ARRAY SUM:");
//        for(i=0;i<10;i++)
//        {
//            System.out.println(pSum[i]);
//        }
        for (i=0;i<10;i++)
        {
            pass[i] = "";
        }
        System.out.println("Other Possible Paths:");
        System.out.println();
        for(i=0;i<10;i++)
        {
            for(j=0;j<ch.length-1;j++)
            {

                pass[i] = pass[i]+every[i][j];
                System.out.print(every[i][j]);
            }
            System.out.println("---> Moves Count:"+pSum[i]);
            System.out.println();
        }
        System.out.println();
        System.out.print( "The shortest path of the Entered String :" );
//        ShortestP = G.getCpath();
//
//
//        System.out.print(ShortestP.peekFirst());
//        ShortestP.removeFirst();
//        while (!ShortestP.isEmpty())
//        {
//            System.out.print("-" + ShortestP.removeFirst());
//        }

        ShortesstStr = G.getCpath();
        pathStr = String.valueOf(ShortesstStr.peekFirst());
        ShortesstStr.removeFirst();
        while (!ShortesstStr.isEmpty())
        {
            pathStr += ("-" + ShortesstStr.removeFirst());
        }
        System.out.println(pathStr);
        G.setPassPath(pathStr);



        System.out.println( "Total Moves of the Shortest Path:"+totMoves );
        G.setTotMin(totMoves);
        G.PsumArr(pSum);
        G.printCPath();


//        System.out.println("CHECK PASS");
//        for (i=0;i<10;i++)
//        {
//            System.out.print(pass[i]);
//            System.out.println();
//        }
        return pass;

////
//        System.out.println( "Total Moves:"+totMoves );
//        System.out.print("Enter source:");
//        String src = sc.nextLine();
//        System.out.print("Enter destination:");
//        String dst = sc.nextLine();
//        G.godfs(src,dst);
//        System.out.println("# paths = " + G.numberOfPaths());
//        System.out.println();
//        System.out.println();
//        System.out.println("Shortest path between "+src+" and "+dst+":");
//        G.printShortest();
    }
}
