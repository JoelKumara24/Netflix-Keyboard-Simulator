/*  ==========================================================================
 **   Author: Joel Shameera Kumara 20963675
 **  Purpose: Implementation of directed graph
 **     Date: 06/10/22
 **Self-Cite: An older version of this code was previously submitted for Prac 6
 **  ==========================================================================
 */

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DSAGraph {

    //Private Class DSAGraphVertex
    private class DSAGraphVertex {
        private String label;
        private DSALinkedList links;
        private boolean visited;


        /** Constructor **/
        /*  --------------------------------------------------------------
         ** Constructor: Alternate
         **      Import: inValue (String)
         **      Export: Memory adress of new DSAGraphVertex
         **   Assertion: Sets label to the toString() of given value, the
         **              value to the given parameter, set links
         */
        private DSAGraphVertex(String inlabel) {
            label = inlabel;
            links = new DSALinkedList();
            visited = false;
        }

        /*  --------------------------------------------------------------
         **   Method: getLabel()
         **      Import: none
         **      Export: label (String)
         **   Assertion: Returns label
         */
        private String getLabel() {
            return label;
        }

        /*  --------------------------------------------------------------
         **   Method: getAdjacent()
         **      Import: none
         **      Export: links (DSALinkedList)
         **   Assertion: Returns links
         */
        private DSALinkedList getAdjacent() {
            return links;
        }

        /*  --------------------------------------------------------------
         **   Method: getVisited()
         **      Import: none
         **      Export: visited (Boolean)
         **   Assertion: Returns visited
         */
        private boolean getVisited() {
            return visited;
        }

        /*  --------------------------------------------------------------
         **   Method: toString()
         **      Import: none
         **      Export: label (String)
         **   Assertion: Returns links
         */

        public String toString() {
            return label;
        }

//        public boolean equals(DSAGraphVertex inVertex) {
//            return (label.equals(inVertex.getLabel()));
//        }
        /*  --------------------------------------------------------------
         **   Method: addEdge()
         **      Import: DSAGraphVertex invertex
         **      Export:  none
         **   Assertion: add invertex to the links
         */

        private void addEdge(DSAGraphVertex inVertex) {
            links.insertLast(inVertex);
        }

        /*  --------------------------------------------------------------
         **   Method: setVisited()
         **      Import: none
         **      Export: none
         **   Assertion: set visited to true
         */

        private void setVisited() {
            visited = true;
        }

        /*  --------------------------------------------------------------
         **   Method: clearVisited()
         **      Import: none
         **      Export: none
         **   Assertion: set visited to false
         */

        private void clearVisited() {
            visited = false;
        }
    }

    private DSALinkedList vertices;
    private String passPath;
    private int moves;
    private final DSAstack shortestPath;
    private final DSALinkedList collectPath;
    private String [] allPC;
    private int [] allPCcount;
    private int [] pSUm;
    private final DSAstack path;     // the current path
    private int Min;
    private int typeLength;
    private int lengthCheck;
    private int Pcount;
    private int TotMin;


    /** Constructor **/
    /*  --------------------------------------------------------------
     ** Constructor: Alternate
     **      Import: none
     **      Export: Memory adress of new DSAGraph
     **   Assertion: set vertices as alinked List, assign all arrays to a index num of 10,and set path and collectPath as new stacks
     */

    public DSAGraph() {
        vertices = new DSALinkedList();
        passPath = "";
        allPC = new String[10];

        allPCcount = new int[10];

        pSUm = new int[10];

        path   = new DSAstack();

        collectPath   = new DSALinkedList();


        shortestPath =  new DSAstack();

    }

    /*  --------------------------------------------------------------
     **   Method: getMin()
     **      Import: none
     **      Export: Min(int)
     **   Assertion: returns Min
     */
    public int getMin()
    {
        return Min;
    }

    /*  --------------------------------------------------------------
     **   Method: getTotMin()
     **      Import: none
     **      Export: TotMin(int)
     **   Assertion: returns TotMin
     */
    public int getTotMin(){ return TotMin;}

    /*  --------------------------------------------------------------
     **   Method: getpSum()
     **      Import: none
     **      Export: pSum(int[])
     **   Assertion: returns pSum
     */
    public int[] getpSUm(){ return pSUm;}

    /*  --------------------------------------------------------------
     **   Method: getPassPath()
     **      Import: none
     **      Export: passPath(String)
     **   Assertion: returns passPath
     */
    public String getPassPath()
    {
        return passPath;
    }

    /*  --------------------------------------------------------------
     **   Method: getCPath()
     **      Import: none
     **      Export: collectPath(DSALinkedList)
     **   Assertion: returns collectPath
     */

    public DSALinkedList getCpath(){ return  collectPath;}


    /*  --------------------------------------------------------------
     **   Method: hasVertex()
     **      Import: inlabel (String)
     **      Export: found( boolean)
     **   Assertion: returns found = true if vertex is in the graph and false if not
     */
    public boolean hasVertex(String inLabel)
    {

        boolean found = false;

        for (Object o : vertices) {

            if (((DSAGraphVertex) o).getLabel().equals(inLabel)) {
                found = true;
            }
        }


        return found;
    }

     /*  --------------------------------------------------------------
     **      Method: hasVertex()
     **      Import: inVertex (DSAGraphVertex)
     **      Export: found( boolean)
     **   Assertion: returns found = true if vertex is in the graph and false if not
     */
    public boolean hasVertex( DSAGraphVertex inVertex )
    {
        boolean found = false;

        for( Object o : vertices )
        {
            if( ( (DSAGraphVertex)o ).equals( inVertex ) )
            {
                found = true;
            }
        }

        return found;
    }
    /*  --------------------------------------------------------------
     **   Method: getVertex()
     **      Import: inlabel (String)
     **      Export: DSAGraphVertex vertex
     **   Assertion: retuns the vertex of the given label
     */
    public DSAGraphVertex getVertex( String inLabel )
    {
        DSAGraphVertex vertex = null;

        if( !hasVertex( inLabel ) )
        {
            System.out.println( "Vertex " + inLabel + " not found" );
        }else {

            for (Object o : vertices) {

                if (((DSAGraphVertex) o).getLabel().equals(inLabel)) {
                    vertex = (DSAGraphVertex) o;
                }
            }


        }
        return vertex;
    }

    /*  --------------------------------------------------------------
     **   Method: getAllPC()
     **      Import: none
     **      Export: String[] allPC
     **   Assertion: retuns allPC
     */
    public String[] getAllPC(){ return allPC;}

    /*  --------------------------------------------------------------
     **   Method: getAllPCcount()
     **      Import: none
     **      Export: int[] allPCcount
     **   Assertion: retuns allPCcount
     */
    public int[] getAllPCcount(){ return allPCcount;}

    /*  --------------------------------------------------------------
     **   Method: movesCount()
     **      Import: none
     **      Export: int moves
     **   Assertion: retuns moves
     */

    public int movesCount()
    {
        return moves;
    }

    /*  --------------------------------------------------------------
     **   Method: getVertexCount()
     **      Import: none
     **      Export: int count
     **   Assertion: retuns count
     */
    public int getVertexCount()
    {
        int count = 0;

        for( Object o : vertices )
        {
            count++;
        }

        return count;
    }
    /*  --------------------------------------------------------------
     **   Method: getAdjacent()
     **      Import: String inLabel
     **      Export: DSALinkedList getVertex( inLabel ).getAdjacent()
     **   Assertion: retuns adjacent vertex of the given string variables vertex.
     */

    public DSALinkedList getAdjacent( String inLabel )
    {
        return getVertex( inLabel ).getAdjacent();
    }

    /*  --------------------------------------------------------------
     **   Method: isAdjacent()
     **      Import: String label1,label2
     **      Export: boolean adjacent
     **   Assertion: retuns true if adjacent false if not
     */
    public boolean isAdjacentS( String label1, String label2 )
    {
        DSAGraphVertex vertex1, vertex2;

        vertex1 = getVertex( label1 );
        vertex2 = getVertex( label2 );

        return isAdjacent(vertex1,vertex2);
    }

    /*  --------------------------------------------------------------
     **   Method: isAdjacent()
     **      Import: DSAGraphVertex vertex1, DSAGraphVertex vertex2
     **      Export: boolean adjacent
     **   Assertion: retuns true if adjacent false if not
     */

    public boolean isAdjacent( DSAGraphVertex vertex1, DSAGraphVertex vertex2 )
    {
        boolean adjacent = false;

        for( Object o : ( vertex1.getAdjacent() ) )
        {
            if( ((DSAGraphVertex)o).equals( vertex2 ) )
            {
                adjacent = true;
            }
        }

        return adjacent;
    }

    /*  --------------------------------------------------------------
     **   Method: getEdgeCount()
     **      Import: none
     **      Export: int count
     **   Assertion: retuns count
     */

    public int getEdgeCount()
    {
        int count = 0;

        for( Object o : vertices )
        {
            for( Object o2 : ( (DSAGraphVertex)o ).getAdjacent() )
            {
                count++;
            }
        }

        return  count  ;
    }

    /*  --------------------------------------------------------------
     **   Method: setTotMin()
     **      Import: int Tot
     **      Export: none
     **   Assertion: assign Tot to TotMin
     */
    public void setTotMin(int Tot){
        TotMin = Tot;
    }
    /*  --------------------------------------------------------------
     **   Method: PsumArr()
     **      Import: int[] pArr
     **      Export: none
     **   Assertion: assign pArr to pSum
     */
    public void PsumArr(int[] pArr)
    {
        pSUm = pArr;
    }

    /*  --------------------------------------------------------------
     **   Method: setPassPath()
     **      Import: String pass
     **      Export: none
     **   Assertion: assign pass to passPath
     */
    public void setPassPath(String pass)
    {
        passPath = pass;
    }
    /*  --------------------------------------------------------------
     **   Method: setLengthCheck()
     **      Import: none
     **      Export: none
     **   Assertion: set lengthCheck to 0
     */

    public void setLengthCheck()
    {
        lengthCheck=0;
    }

    /*  --------------------------------------------------------------
     **   Method: passLength()
     **      Import: int lenngth
     **      Export: none
     **   Assertion: assigning length to typelength
     */
    public void passLength(int length)
    {
        typeLength = length;
    }

    /*  --------------------------------------------------------------
     **   Method: addEdge()
     **      Import: String label1, String label2
     **      Export: none
     **   Assertion: adding Edges to graph
     */
    public void addEdge(String label1, String label2)
    {
        addEdge( getVertex( label1 ), getVertex( label2 ) );
    }

    public void addEdge( DSAGraphVertex vertex1, DSAGraphVertex vertex2 )
    {
        if( isAdjacent( vertex1, vertex2 ) )
        {
            System.out.println( "Verticies " + vertex1 + " and " + vertex2 + " are already connected" );
        }
        else {
            vertex1.addEdge( vertex2 );
        }


        //vertex2.addEdge( vertex1 );
    }

    /*  --------------------------------------------------------------
     **   Method: addVertex()
     **      Import: String label1
     **      Export: none
     **   Assertion: adding vertex to the graph
     */
    public void addVertex(String inLabel)
    {
        if (hasVertex(inLabel))
        {
            throw new IllegalArgumentException("Vertex " + inLabel +
                    " already exists in graph");
        }

        vertices.insertLast(new DSAGraphVertex(inLabel));

    }

    /*  --------------------------------------------------------------
     **   Method: displayAsList()
     **      Import: none
     **      Export: none
     **   Assertion: printing graph as a list
     */

    public void displayAsList()
    {
        for( Object o : vertices )
        {
            System.out.print( ((DSAGraphVertex)o).getLabel() + " |" );
            for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
            {
                System.out.print( "  " + ((DSAGraphVertex)o2).getLabel() );
            }
            System.out.println();
        }
    }

    /*  --------------------------------------------------------------
     **   Method: displayAsMatrix()
     **      Import: none
     **      Export: none
     **   Assertion: printing graph as a Matrix
     */
    public void displayAsMatrix()
    {
        int numofVertices = getVertexCount();   //getting number of vertices
        String[] arr = new String[ numofVertices ];   //String array to get all the vertices
        boolean[][] matrix = new boolean[ numofVertices ][ numofVertices ];  //boolean array to set true or false

        int num = 0;




        //inserting labels of vertices in to the array
        for( Object o : vertices )
        {
            DSAGraphVertex vertex = (DSAGraphVertex)o;
            arr[num] = vertex.getLabel();
            num++;
        }

        //setting true or false in to the boolean array
        for( int i = 0; i < numofVertices; i++ )
        {
            for( int j = 0; j < numofVertices; j++ )
            {
                //setting true if vertices are adjacent
                if( isAdjacent( getVertex(arr[i]), getVertex(arr[j]) ) )
                {
                    matrix[i][j] = true;
                }
                //false if not
                else
                {
                    matrix[i][j] = false;
                }
            }
        }

        //printing the Matrix
        System.out.print( " " );
        //printing the vertices row
        for( int i = 0;i<numofVertices;i++ )
        {
            System.out.print( " | " + arr[i] );
        }

        for( int i = 0; i < numofVertices; i++ )
        {
            //printing the vertices column
            System.out.print( "\n" + arr[i] );
            for( int j = 0; j < numofVertices; j++ )
            {
                //print 1 if the boolean value is true
                if(matrix[i][j])
                {
                    System.out.print( " | " + 1 );
                }
                //print 0 if the boolean value is false
                else
                {
                    System.out.print( " | " + 0 );
                }
            }
        }
        System.out.println();
    }



    /*  --------------------------------------------------------------
     **   Method: clearVisited()
     **      Import: none
     **      Export: none
     **   Assertion: setting all visited to false
     */

    private void clearVisited()
    {
        for( Object o : vertices )
        {
            ( (DSAGraphVertex)o ).clearVisited();
        }
    }

    /*  --------------------------------------------------------------
     **   Method: loadFile(String filename)
     **      Import: none
     **      Export: none
     **   Assertion: loading the txt file in to the graph as vertices and edges
     */

    public void loadfile(String filename) throws IOException {
        Scanner sc = new Scanner(System.in); //scanner method to get user input
        BufferedReader br = new BufferedReader(new FileReader(filename)); //buffered reader object to read the csv file
        String label1, label2;
        String currrentLine;
        int row = 0;
        String[] arr;

        while((currrentLine = br.readLine()) != null)
        {
            arr = currrentLine.split(" ");

            for(int i=0;i<arr.length;i++)
            {
                //if the array index is not in the graph add Vertex
                if( !hasVertex( arr[i] ) )
                {
                    addVertex( arr[i] );
                }
            }
            //then add edges
            for(int i=1;i<arr.length;i++)
            {
                addEdge(arr[row],arr[i]);
            }
        }
        br.close();
    }

    /*  --------------------------------------------------------------
     **   Method: godfs()
     **      Import: String v,String t
     **      Export: none
     **   Assertion: passing all the necessary values to dfs to find paths
     */

    public void godfs(String v,String t)
    {

        Pcount = 0;

        moves = 0;
        Min = 0;
        clearVisited();
        dfs(getVertex(v),getVertex(t));
        lengthCheck++;

    }
    /*  --------------------------------------------------------------
     **   Method: dfs()
     **      Import: DSAGraphVertex v, DSAGraphVertex t
     **      Export: none
     **   Assertion: Generating all possible paths and passing filtered shortest paths to findPath()
     */
    public void dfs( DSAGraphVertex v, DSAGraphVertex t) {

        // add v to current path
        DSAGraphVertex subVertex;
        path.push(v);
        v.setVisited();
        int count = 0;

        //getting count to filter the paths
        for( Object o : path )
        {
            count++;
        }

        // found path from s to t
        if (v == t) {
            //if the nodes in the path is less than 11 then it passes the path to findpath()
            if(count<11)
            {
                findPath();
                Pcount++;
            }

            moves = 0;

        }


        // consider all neighbors that would continue path with repeating a node
        else {
            for (Object w : v.getAdjacent()) {
                subVertex = (DSAGraphVertex) w;
                //recursion for the dfs for all adjacent nodes
                if (!subVertex.getVisited()){
                    dfs((DSAGraphVertex) w, t);
                }

            }
        }

        // done exploring from v, so remove from path
        path.pop();
        v.clearVisited();




    }

    /*  --------------------------------------------------------------
     **   Method: findPath()
     **      Import: none
     **      Export: none
     **   Assertion: pushing the shortest path to the shortestStack and printing all possible paths
     */
    public void findPath() {

        String pCol = "";
        String pCol2 = "";

        moves = 0;
        DSAstack reverse = new DSAstack();

        //pushing path to reverse stack
        for (Object v : path)
        {

            reverse.push(v);
            moves++;

        }

        //finding shortest path
        if(Min==0)
        {
            Min = moves;

            for (Object v : path)
            {
                shortestPath.push(v);
            }

        }
        //pushing shortest path in to the shortestPath stack
        else if(moves<Min)
        {
            while (!shortestPath.isEmpty())
            {
                shortestPath.pop();
            }

            for (Object v : path)
            {
                shortestPath.push(v);
            }
            Min = moves;


        }

        //if the filtered possible paths are less than 10
        if(Pcount<10)
        {
            //to stop the printing of the node twice
            //collecting path to a string
            int Ocount = moves;
            pCol = String.valueOf(reverse.top());
            reverse.pop();
            while (!reverse.isEmpty())
            {
                pCol += ("-" + String.valueOf(reverse.pop()));

            }
            //breaking down string to char values
            char[] ch = new char[pCol.length()];
            for (int i = 0; i < pCol.length(); i++) {
                ch[i] = pCol.charAt(i);
            }

            //removing last node char from the string if not the last path
            if(!(lengthCheck==typeLength-2))
            {
                ch[pCol.length()-1] = '-';
            }

            for (int i = 0; i < pCol.length(); i++) {
                 pCol2  = pCol2+String.valueOf(ch[i]);
            }
            allPC [Pcount]= pCol2;
            allPCcount[Pcount] = Ocount;



        }

    }

    /*  --------------------------------------------------------------
     **   Method: printShortest()
     **      Import: none
     **      Export: none
     **   Assertion: inserting the shortest path in to collectPath List
     */

    public void printShortest()
    {

        for (Object v : shortestPath)
        {

            collectPath.insertLast(v);

        }



        while (!shortestPath.isEmpty())
        {
            shortestPath.pop();
        }


    }

    /*  --------------------------------------------------------------
     **   Method: printCPath()
     **      Import: none
     **      Export: none
     **   Assertion: removing all elements from the collectPath list
     */

    public void printCPath()
    {

        while (!collectPath.isEmpty())
        {
            collectPath.removeFirst();
        }
    }

    /*  --------------------------------------------------------------
     **   Method: removeVertex()
     **      Import: String inLabel
     **      Export: none
     **   Assertion: wrapper method for the removeVertex()
     */


    public void removeVertex( String inLabel )
    {
        removeVertex( getVertex( inLabel ) );
    }

    /*  --------------------------------------------------------------
     **   Method: removeVertex()
     **      Import: DSAGraphVertex inVertex
     **      Export: none
     **   Assertion: removing the inVertex from the graph
     */
    public void removeVertex( DSAGraphVertex inVertex )
    {
        if( !hasVertex( inVertex ) )
        {
            System.out.println( "Vertex does not exist in the graph" );
        }
        else {
            for (Object o : vertices) {
                for (Object o2 : ((DSAGraphVertex) o).getAdjacent()) {
                    //if the vertex is found deleting all adjacents
                    if (inVertex == o2) {
                        removeEdge((DSAGraphVertex) o, (DSAGraphVertex) o2);
                    }
                }

            }

            //deleting node
            vertices.removeNode(inVertex);
        }
    }

    /*  --------------------------------------------------------------
     **   Method: removeEdge()
     **      Import: String inLabel1,inLabel2
     **      Export: none
     **   Assertion: wrapper method for the removeEdge()
     */
    public void removeEdge( String inLabel1, String inLabel2 )
    {
        removeEdge( getVertex( inLabel1 ), getVertex( inLabel2 ) );
    }

    /*  --------------------------------------------------------------
     **   Method: removeEdge()
     **      Import: DSAGraphVertex inVertex1,inVertex2
     **      Export: none
     **   Assertion: removing the edge from the graph
     */

    public void removeEdge( DSAGraphVertex inVertex1, DSAGraphVertex inVertex2 )
    {
        if( !isAdjacent( inVertex1, inVertex2 ) )
        {
            System.out.println( "Vertices " + inVertex1.label + " and " + inVertex2.label + " are not adjacent" );
        }else {

            inVertex1.links.removeNode(inVertex2);
        }

    }

    /*  --------------------------------------------------------------
     **   Method: RemoveAll()
     **      Import: none
     **      Export: none
     **   Assertion: removing all the vertices from the graph
     */
    public void RemoveAll()
    {
        for( Object o : vertices )
        {
            for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
            {

                {
                    removeEdge((DSAGraphVertex) o,(DSAGraphVertex) o2);
                }
            }
            vertices.removeNode( o );

        }
    }
    /*  --------------------------------------------------------------
     **   Method: writeFile()
     **      Import: none
     **      Export: none
     **   Assertion: write in to a file
     */
    public void writeFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the filename to write the Keyboard:");
        String filename = sc.nextLine();
        FileOutputStream filestrm = new FileOutputStream(filename);
        PrintWriter pw = new PrintWriter(filestrm);


        //writing keyboard in to a file
        for( Object o : vertices )
        {

            pw.print( ((DSAGraphVertex)o).getLabel() );
            for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
            {

                pw.print( " " + ((DSAGraphVertex)o2).getLabel() );
            }
            pw.println();
        }
        pw.close();

    }

    /*  --------------------------------------------------------------
     **   Method: updateNode()
     **      Import: String label1, String label2
     **      Export: none
     **   Assertion: wrapper method for updateNode
     */

    public void updateNode (String label1, String label2)
    {
        addVertex(label2);
        updateNode( getVertex( label1 ), getVertex( label2 ) );
    }

    /*  --------------------------------------------------------------
     **   Method: updateNode()
     **      Import:  DSAGraphVertex inVertex,DSAGraphVertex Uvertex
     **      Export: none
     **   Assertion: updating node with the given label while keeping all the links
     */
    public void updateNode( DSAGraphVertex inVertex,DSAGraphVertex Uvertex)
    {

        for( Object o : vertices )
        {
            if(o.equals(inVertex)) { //if found make all the previous nodes links to the new node
                for (Object o2 : ((DSAGraphVertex) o).getAdjacent()) {

                    {
                        addEdge(Uvertex, (DSAGraphVertex) o2);
                    }
                }
            }


        }
        //then remove the prev node
        removeVertex(inVertex);
    }





}
