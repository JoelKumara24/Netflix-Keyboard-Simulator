/*  ==========================================================================
 **   Author: Joel Shameera Kumara 20963675
 **  Purpose: Implementation of keyMeUp
 **     Date: 06/10/22
 **  ==========================================================================
 */

import java.io.*;
import java.util.*;
public class keyMeUp
{

    /*  --------------------------------------------------------------
     **   Method: main()
     **      Import: none
     **      Export: none
     **   Assertion: work on the operations with the given command lines
     */

    public static void main(String[] args) throws IOException {

        if(args.length == 0)
        {
            System.out.println("Enter the necessary Command Line Arguments:'-i' or '-s <keyFile> <strFile> <pathFile>' ");
        }
        else if(args[0].equals("-i"))
        {
            //if user selects interactive mode
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            int menu = '0';
            String sToD = "";
            String[] getP = new String[10];
            DSAGraph graph = new DSAGraph();
            System.out.println("=====================**\nInitially we recommend the user to use the (1)Load File Option\n" +
                    " before going further in to the menu\n**====================");

            while (!exit) {
                System.out.print(
                        "=========== Interactive Menu ===========\n\n" +
                                "[1] Load File\n[2] Node Operations"
                                + "\n[3] Edge Operations\n" +
                                "[4] Display Graph\n[5] Display Graph Information\n" +
                                "[6] Enter string for finding path\n[7] Generate paths\n" +
                                "[8]  Display path(s) (ranked)\n[9] Save keyboard\n[10] Exit\n"
                );
                menu = sc.nextInt();
                switch (menu) {
                    case 1: {
                        graph.RemoveAll();
                        sc.nextLine();
                        System.out.println("Enter file Name:");
                        String filename = sc.nextLine();
                        loadFile(graph,filename);
                        break;
                    }
                    case 2: {
                        boolean exit1 = false;
                        int menu1 = '0';
                        while (!exit1)
                        {
                            System.out.println("Node Operations\n"+"[1] Find \n[2] Insert\n[3] Delete\n[4] Update\n[5] Exit");
                            menu1 = sc.nextInt();
                            sc.nextLine();
                            switch (menu1){
                                case 1:{
                                    System.out.println("Enter the Vertex you want to find:");
                                    String label = sc.nextLine();
                                    if(graph.hasVertex(label))
                                    {
                                        System.out.println(label+" Exists in the Graph.");
                                        System.out.println();
                                    }
                                    else {
                                        System.out.println(label+" is NOT found in the Graph.");
                                        System.out.println();
                                    }
                                    break;
                                }
                                case 2:{
                                    System.out.print("Enter the Vertex you want to Insert:");
                                    System.out.println();
                                    String label1 = sc.nextLine();
                                    graph.addVertex(label1);
                                    System.out.print("Do you want to check whether the Vertex is Inserted?[Y/N]");
                                    String label = sc.nextLine();
                                    if(label.equals("Y")||label.equals("y"))
                                    {
                                        graph.displayAsList();
                                    }
                                    break;
                                }
                                case 3:{
                                    System.out.println("Enter the Vertex you want to Delete:");
                                    String label2 = sc.nextLine();
                                    graph.removeVertex(label2);
                                    System.out.println("Do you want to check whether the Vertex is Deleted?[Y/N]");
                                    String label = sc.nextLine();
                                    if(label.equals("Y")||label.equals("y"))
                                    {
                                        graph.displayAsList();
                                    }
                                    break;
                                }
                                case 4:{
                                    System.out.println("Enter the Node you want to update");
                                    String label1 = sc.nextLine();
                                    System.out.println("Enter the label you want to update with");
                                    String label2 = sc.nextLine();
                                    graph.updateNode(label1,label2);

                                    System.out.println("Do you want to check whether the Vertex is Updated?[Y/N]");
                                    String label = sc.nextLine();
                                    if(label.equals("Y"))
                                    {
                                        graph.displayAsList();
                                    }

                                    break;
                                }
                                case 5:{
                                    exit1 = true;
                                    break;
                                }
                                default: {
                                    // Invalid menu selection
                                    System.out.println("Invalid menu option: Enter Valid option");
                                }
                            }
                        }

                        break;
                    }
                    case 3: {
                        boolean exit2 = false;
                        int menu1 = '0';
                        while (!exit2)
                        {
                            System.out.println("Edge Operations\n"+"[1] Find \n[2] Insert\n[3] Delete\n[4] Exit");
                            menu1 = sc.nextInt();
                            sc.nextLine();
                            switch (menu1){
                                case 1:{
                                    System.out.print("Enter the 1st Vertex you want to find:");
                                    String label = sc.nextLine();
                                    System.out.println();
                                    System.out.print("Enter the 2nd Vertex you want to find:");
                                    String label1 = sc.nextLine();
                                    if(graph.isAdjacentS(label,label1))
                                    {
                                        System.out.println(label+" and "+label1+" is connected in the Graph.");
                                        System.out.println();
                                    }
                                    else {

                                        System.out.println("Labels are NOT connected");
                                    }
                                    break;
                                }
                                case 2:{
                                    System.out.print("Enter the 1st Vertex you want to Connect:");
                                    String label1 = sc.nextLine();
                                    System.out.print("Enter the 2nd Vertex you want to Connect:");
                                    String label2 = sc.nextLine();
                                    graph.addEdge(label1,label2);
                                    System.out.println("Do you want to check whether the Edge is Inserted?[Y/N]");
                                    String label = sc.nextLine();
                                    if(label.equals("Y")||label.equals("y"))
                                    {
                                        graph.displayAsList();
                                    }
                                    break;
                                }
                                case 3:{
                                    System.out.println("Enter the 1st Vertex of the Edge you want to Delete:");
                                    String label1 = sc.nextLine();
                                    System.out.println("Enter the 2nd Vertex of the Edge you want to Delete:");
                                    String label2 = sc.nextLine();
                                    graph.removeEdge(label1,label2);
                                    System.out.println("Do you want to check whether the Vertex is Deleted?[Y/N]");
                                    String label = sc.nextLine();
                                    if(label.equals("Y")||label.equals("y"))
                                    {
                                        graph.displayAsList();
                                    }
                                    break;
                                }

                                case 4:{
                                    exit2 = true;
                                    break;
                                }
                                default: {
                                    // Invalid menu selection
                                    System.out.println("Invalid menu option: Enter Valid option");
                                }
                            }
                        }

                        break;
                    }
                    case 4: {
                        printGraphList(graph);

                        break;
                    }
                    case 5: {
                        printGraphMatrix(graph);

                        break;
                    }
                    case 6: {
                        sToD = ReadString(graph);
                        break;
                    }
                    case 7: {
                        getP = allPaths(graph,sToD);
                        break;
                    }

                    case 8: {
                        Sorted(getP,graph.getpSUm(),graph,sToD);

                        break;
                    }

                    case 9: {
                        graph.writeFile();
                        break;
                    }


                    case 10: {
                        // Exit
                        exit = true;
                        break;
                    }

                    default: {
                        // Invalid menu selection
                        System.out.println("Invalid menu option: Enter Valid option");
                    }
                }
            }
        }else if(args[0].equals("-s")) { //when user selects silent mode
            DSAGraph graph = new DSAGraph();
            loadFile(graph,args[1]);
            loadStrfile(args[2],graph,args[3]);

        }
        else
        {
            System.out.println("Enter the necessary Command Line Arguments:'-i' or '-s <keyFile> <strFile> <pathFile>' ");
        }



    }

    /*  --------------------------------------------------------------
     **   Method: loadFile()
     **      Import: DSAGraph graph1,String filename
     **      Export: none
     **   Assertion: loads in to the file
     */
    public static void loadFile(DSAGraph graph1,String filename) throws IOException {
        graph1.loadfile( filename );
        System.out.println("Loaded succesfully");
        System.out.println();

    }

    /*  --------------------------------------------------------------
     **   Method: printGraphList()
     **      Import: DSAGraph graph1
     **      Export: none
     **   Assertion: calls displayAsList() from graph
     */
    public static void printGraphList(DSAGraph graph1)
    {
        graph1.displayAsList();

    }

    /*  --------------------------------------------------------------
     **   Method: printGraphMatrix()
     **      Import: DSAGraph graph1
     **      Export: none
     **   Assertion: calls displayAsMatrix() from graph
     */
    public static void printGraphMatrix(DSAGraph graph1)
    {
        graph1.displayAsMatrix();
    }

    /*  --------------------------------------------------------------
     **   Method: ReadString()
     **      Import: DSAGraph graph1
     **      Export: none
     **   Assertion: returns bfs
     */
    public static String ReadString(DSAGraph graph1)
    {


        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter String to find Path:" );
        String bfs = sc.nextLine();
        return bfs;

    }
    /*  --------------------------------------------------------------
     **   Method: allPaths()
     **      Import: DSAGraph G,String bfs
     **      Export: String[] pass
     **   Assertion: printing all posible paths
     */
    public static String[] allPaths(DSAGraph G,String bfs)
    {

        G.setLengthCheck();
        DSALinkedList ShortesstStr ;
        String pathStr = "";

        //getting the String into a char array
        char[] ch = new char[bfs.length()];
        for (int i = 0; i < bfs.length(); i++) {
            ch[i] = bfs.charAt(i);
        }
        //passing length to graph class
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
        //until the array ends
        for(i=0;i < ch.length-1;i++) {
            //if the chars are Uppercase modify them to lowercase then pass to goddfs method
            String ch1 = String.valueOf(ch[i]);
            String ch2 = String.valueOf(ch[i+1]);
            String ch3 = "";
            if (Character.isUpperCase(ch[i])) {
                ch1 = ch1.toLowerCase();
                G.godfs(ch1, ch2);

            }
            else if (Character.isUpperCase(ch[i + 1]))
            {
                ch2 = ch2.toLowerCase();
                G.godfs(ch1, ch2);
            }
            else if(Character.isUpperCase(ch[i])&&Character.isUpperCase(ch[i + 1]))
            {
                ch1 = ch1.toLowerCase();
                ch2 = ch2.toLowerCase();
                G.godfs(ch1, ch2);
            }
            else {
                G.godfs(ch1, ch2);
            }

            //getting min count
            int moves = G.getMin();

            //setting shortest to null
            G.printShortest();
            pCount = G.getAllPCcount();
            lil = G.getAllPC();
            //Assigning paths to 2d array
            for (j = 0; j < 10; j++) {
                every[j][i] = lil[j];
            }
            //Assigning moves of each path to allC array
            for (j = 0; j < 10; j++) {
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

        for (i=0;i<10;i++)
        {
            pass[i] = "";
        }
        System.out.println("Other Possible Paths:");
        System.out.println();
        //printing the paths
        for(i=0;i<10;i++)
        {
            for(j=0;j<ch.length-1;j++)
            {
                //collecting to pass[] while printing
                pass[i] = pass[i]+every[i][j];
                System.out.print(every[i][j]);
            }
            System.out.println("---> Moves Count:"+pSum[i]);
            System.out.println();
        }
        System.out.println();
        System.out.print( "The shortest path of the Entered String :" );

        //getting shortest path from graph class
        ShortesstStr = G.getCpath();
        pathStr = String.valueOf(ShortesstStr.peekFirst());
        ShortesstStr.removeFirst();
        while (!ShortesstStr.isEmpty())
        {
            pathStr += ("-" + ShortesstStr.removeFirst());
        }
        //printing shortest path
        System.out.println(pathStr);
        //passing string shortest path to graph class
        G.setPassPath(pathStr);
        System.out.println();


        System.out.println( "Total Moves of the Shortest Path:"+totMoves );
        G.setTotMin(totMoves);
        //passing pSum array to graph class
        G.PsumArr(pSum);
        //setting shortest path to null
        G.printCPath();
        System.out.println();
        System.out.println();


        //returning pass
        return pass;


    }

    /*  --------------------------------------------------------------
     **   Method: Sorted()
     **      Import: String[] sArr1,int[] sArr2,DSAGraph G,String bfs
     **      Export: none
     **   Assertion: printing all posible paths in ascending order and writing them on a file if the user chooses to.
     */
    public static void Sorted(String[] sArr1,int[] sArr2,DSAGraph G,String bfs) throws IOException {
        System.out.println();
        System.out.println();

        String temp1 = "";
        int temp2 = 0;




        //The Bubble sorting method got from practical 1 to sort all paths to ascending order
        for (int pass = 0; pass < 10;pass++)
        {
            for (int ii = 0; ii < (10 - pass)-1; ii++)
            {
                    if(sArr2[ii]>sArr2[ii+1])
                    {
                        temp1 = sArr1[ii];
                        temp2 = sArr2[ii];

                        sArr1[ii] = sArr1[ii+1];
                        sArr2[ii] = sArr2[ii+1];

                        sArr1[ii+1] = temp1;
                        sArr2[ii+1] = temp2;
                    }
            }
        }
        System.out.println("All Paths Ranked In Ascending Order:");
        System.out.println();
        //getting the shortest path string from graph class
        String path = G.getPassPath();
        //printing shortest path
        System.out.print(path);
        //get total
        int Tot = G.getTotMin();
        //print total
        System.out.println(" : "+Tot);


        //printing the sorted array
        for(int i=0;i<10;i++)
        {
            System.out.println(sArr1[i]+" : "+sArr2[i]);
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.print("Do You Want to Save the Paths in To a Text file?(Y/N):");
        String choice = sc.nextLine();
        if(choice.equals("Y")||choice.equals("y")) {
            //printing the array and shortest path to a txt file if chose 'y' or 'Y'
            System.out.print("Enter the filename to print the Paths:");
            String filename = sc.nextLine();


            FileWriter fileWriter = new FileWriter(filename, true);
            //adding append = true for add the strings without overwriting to the same file

            BufferedWriter br = new BufferedWriter(fileWriter);
            br.write("The Word: "+bfs);
            br.newLine();
            //write shortest path
            br.write(path);
            br.write(" : "+Tot);
            br.newLine();
            //write array
            for (int i = 0; i < 10; i++) {
                br.write(sArr1[i] + " : " + sArr2[i]);
                br.newLine();
            }
            br.newLine();
            br.write(" ");
            br.newLine();
            //close stream
            br.close();
        }
    }

    /*  --------------------------------------------------------------
     **   Method: loadStrfile()
     **      Import: String filename,DSAGraph G,String pathfile
     **      Export: none
     **   Assertion: Reading the string file and writing it in to a textfile in the silentMode.
     */
    public static void loadStrfile(String filename,DSAGraph G,String pathfile) throws IOException {
        Scanner sc = new Scanner(System.in); //scanner method to get user input
        BufferedReader br = new BufferedReader(new FileReader(filename)); //buffered reader object to read the csv file
        String label1, label2;
        String currrentLine;
        int row = 0;
        String[] arr;
        String[] getP = new String[10];

        //while the file ends
        while((currrentLine = br.readLine()) != null)
        {
            arr = currrentLine.split(" ");

            //while the loop is running get all paths printed in to txt file
            for (int i = 0;i< arr.length;i++)
            {
                getP = allPathsSilent(G,arr[i],pathfile);
                SortedSilent(getP, G.getpSUm(), G,pathfile);
            }




        }
        br.close();
        //stream closed
        System.out.println("Go check out "+pathfile);
    }

    /*  --------------------------------------------------------------
     **   Method: allPathsSilent()
     **      Import: DSAGraph G,String bfs,String filename
     **      Export: String[] pass
     **   Assertion: Reading the string file and writing it in to a textfile in the silentMode.
     */

    //allPaths method with0ut the print Statements
    public static String[] allPathsSilent(DSAGraph G,String bfs,String filename) throws IOException {

        FileWriter fileWriter = new FileWriter(filename, true);
        BufferedWriter br = new BufferedWriter(fileWriter);
        br.write("The Word: "+bfs);
        br.newLine();
        br.close();

        G.setLengthCheck();
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

        for (i=0;i<10;i++)
        {
            pass[i] = "";
        }

        for(i=0;i<10;i++)
        {
            for(j=0;j<ch.length-1;j++)
            {

                pass[i] = pass[i]+every[i][j];

            }
        }


        ShortesstStr = G.getCpath();
        pathStr = String.valueOf(ShortesstStr.peekFirst());
        ShortesstStr.removeFirst();
        while (!ShortesstStr.isEmpty())
        {
            pathStr += ("-" + ShortesstStr.removeFirst());
        }
        G.setPassPath(pathStr);

        G.setTotMin(totMoves);
        G.PsumArr(pSum);
        G.printCPath();



        return pass;


    }
    /*  --------------------------------------------------------------
     **   Method: SortedSilent()
     **      Import: String[] sArr1,int[] sArr2,DSAGraph G,String filename
     **      Export: none
     **   Assertion: writing the paths in Ascending order in to a textfile in the silentMode.
     */
    //Sorted method with0ut the print Statements
    public static void SortedSilent(String[] sArr1,int[] sArr2,DSAGraph G,String filename) throws IOException {
        String temp1 = "";
        int temp2 = 0;




        for (int pass = 0; pass < 10;pass++)
        {
            for (int ii = 0; ii < (10 - pass)-1; ii++)
            {
                if(sArr2[ii]>sArr2[ii+1])
                {
                    temp1 = sArr1[ii];
                    temp2 = sArr2[ii];

                    sArr1[ii] = sArr1[ii+1];
                    sArr2[ii] = sArr2[ii+1];

                    sArr1[ii+1] = temp1;
                    sArr2[ii+1] = temp2;
                }
            }
        }

        String path = G.getPassPath();

        int Tot = G.getTotMin();





            FileWriter fileWriter = new FileWriter(filename, true);

            BufferedWriter br = new BufferedWriter(fileWriter);
            br.write("All Paths Ranked In Ascending Order:");
            br.newLine();
            br.write(path);
            br.write(" : "+Tot);
            br.newLine();
            for (int i = 0; i < 10; i++) {
                br.write(sArr1[i] + " : " + sArr2[i]);
                br.newLine();
            }
            br.newLine();
            br.write(" ");
            br.newLine();
            br.close();

    }


}