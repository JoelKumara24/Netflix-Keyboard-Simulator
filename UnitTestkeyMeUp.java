import java.io.*;
import java.util.Scanner;

public class UnitTestkeyMeUp
{

    public static void main(String[] args) throws IOException {

        if(args.length == 0)
        {
            System.out.println("Enter the necessary Command Line Arguments:'-i' or '-s <keyFile> <strFile> <pathFile>' ");
        }
        else if(args[0].equals("-i")) {
            DSAGraph graph = new DSAGraph();
            graph.loadfile("Direct.txt");


            String std = "joel";
            System.out.println("The input String: joel");
            System.out.println();
            System.out.println("========Testing allPaths========");
            System.out.println();
            String[] path = allPaths(graph, std);
            System.out.println();
            System.out.println("****EXPECTED****\nOther Possible Paths:\n" +
                    "\n" +
                    "j-d-c-b-a-g-h-i--o-i-c-d--e-d-c-i-o-p-q-k-l---> Moves Count:23\n" +
                    "\n" +
                    "j-d-c-b-a-g-h-n--o-i-h-b-c-d--e-d-c-i-o-p-q-r-l---> Moves Count:25\n" +
                    "\n" +
                    "j-d-c-b-a-g-m-n--o-i-h-g-a-b-c-d--e-d-j-i-o-p-q-k-l---> Moves Count:27\n" +
                    "\n" +
                    "j-d-c-b-h-g-m-n--o-i-j-d--e-d-j-i-o-p-q-r-l---> Moves Count:23\n" +
                    "\n" +
                    "j-d-c-b-h-i--o-n-h-b-c-i-j-d--e-k-q-p-v-w-x-r-l---> Moves Count:25\n" +
                    "\n" +
                    "j-d-c-b-h-n-t-u--o-n-h-b-c-d--e-k-q-w-3-4-x-r-l---> Moves Count:25\n" +
                    "\n" +
                    "j-d-c-b-h-n--o-n-h-g-a-b-c-d--e-k-q-w-x-r-l---> Moves Count:23\n" +
                    "\n" +
                    "j-d-c-i-h-g-m-n--o-n-h-i-c-d--e-k-q-r-l---> Moves Count:21\n" +
                    "\n" +
                    "j-d-c-i-h-n-t-u--o-n-h-i-j-d--e-k-l---> Moves Count:19\n" +
                    "\n" +
                    "j-d-c-i-h-n--o-n-m-g-a-b-c-d--e-f-l---> Moves Count:19\n" +
                    "\n" +
                    "\n" +
                    "The shortest path of the Entered String :j-i-o-o-i-c-d-e-e-k-l\n" +
                    "\n" +
                    "Total Moves of the Shortest Path:11");

            System.out.println();
            System.out.println("========Testing Sorted========");
            System.out.println();
            Sorted(path, graph.getpSUm(), graph);
            System.out.println();
            System.out.println("*******EXPECTED******\nAll Paths Ranked In Ascending Order:\n" +
                    "\n" +
                    "j-i-o-o-i-c-d-e-e-k-l : 11\n" +
                    "j-d-c-i-h-n-t-u--o-n-h-i-j-d--e-k-l : 19\n" +
                    "\n" +
                    "j-d-c-i-h-n--o-n-m-g-a-b-c-d--e-f-l : 19\n" +
                    "\n" +
                    "j-d-c-i-h-g-m-n--o-n-h-i-c-d--e-k-q-r-l : 21\n" +
                    "\n" +
                    "j-d-c-b-a-g-h-i--o-i-c-d--e-d-c-i-o-p-q-k-l : 23\n" +
                    "\n" +
                    "j-d-c-b-h-g-m-n--o-i-j-d--e-d-j-i-o-p-q-r-l : 23\n" +
                    "\n" +
                    "j-d-c-b-h-n--o-n-h-g-a-b-c-d--e-k-q-w-x-r-l : 23\n" +
                    "\n" +
                    "j-d-c-b-a-g-h-n--o-i-h-b-c-d--e-d-c-i-o-p-q-r-l : 25\n" +
                    "\n" +
                    "j-d-c-b-h-i--o-n-h-b-c-i-j-d--e-k-q-p-v-w-x-r-l : 25\n" +
                    "\n" +
                    "j-d-c-b-h-n-t-u--o-n-h-b-c-d--e-k-q-w-3-4-x-r-l : 25\n" +
                    "\n" +
                    "j-d-c-b-a-g-m-n--o-i-h-g-a-b-c-d--e-d-j-i-o-p-q-k-l : 27");

            System.out.println("If you did select the save to a file option Go checkout the file that you saved!");

        }else if(args[0].equals("-s")) {
            DSAGraph graph = new DSAGraph();
            graph.loadfile(args[1]);
            loadStrfile(args[2],graph,args[3]);


}
        else
    {
        System.out.println("Enter the necessary Command Line Arguments:'-i' or '-s <keyFile> <strFile> <pathFile>' ");
    }


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
        for(i=0;i < ch.length-1;i++) {
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

            int moves = G.getMin();

            G.printShortest();
            pCount = G.getAllPCcount();
            lil = G.getAllPC();
            for (j = 0; j < 10; j++) {
                every[j][i] = lil[j];
            }

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


        ShortesstStr = G.getCpath();
        pathStr = String.valueOf(ShortesstStr.peekFirst());
        ShortesstStr.removeFirst();
        while (!ShortesstStr.isEmpty())
        {
            pathStr += ("-" + ShortesstStr.removeFirst());
        }
        System.out.println(pathStr);
        G.setPassPath(pathStr);
        System.out.println();


        System.out.println( "Total Moves of the Shortest Path:"+totMoves );
        G.setTotMin(totMoves);
        G.PsumArr(pSum);
        G.printCPath();
        System.out.println();
        System.out.println();



        return pass;


    }

    public static void Sorted(String[] sArr1,int[] sArr2,DSAGraph G) throws IOException {
        System.out.println();
        System.out.println();

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
        System.out.println("All Paths Ranked In Ascending Order:");
        System.out.println();
        String path = G.getPassPath();
        System.out.print(path);
        int Tot = G.getTotMin();
        System.out.println(" : "+Tot);


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
            System.out.print("Enter the filename to print the Paths:");
            String filename = sc.nextLine();
//            FileOutputStream filestrm = new FileOutputStream(filename);
//            PrintWriter pw = new PrintWriter(new FileWriter(filename, true));

            FileWriter fileWriter = new FileWriter(filename, true);

            BufferedWriter br = new BufferedWriter(fileWriter);
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

    public static void loadStrfile(String filename,DSAGraph G,String pathfile) throws IOException {
        Scanner sc = new Scanner(System.in); //scanner method to get user input
        BufferedReader br = new BufferedReader(new FileReader(filename)); //buffered reader object to read the csv file
        String label1, label2;
        String currrentLine;
        int row = 0;
        String[] arr;
        String[] getP = new String[10];

        while((currrentLine = br.readLine()) != null)
        {
            arr = currrentLine.split(" ");

            for (int i = 0;i< arr.length;i++)
            {
                getP = allPathsSilent(G,arr[i],pathfile);
                SortedSilent(getP, G.getpSUm(), G,pathfile);
            }




        }
        br.close();
        System.out.println("Go check out "+pathfile);
    }

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
