import java.util.ArrayList;
import java.util.Scanner;

public class main {

    // static int g ;
    private static ArrayList<State> explored = new ArrayList<State>();
    private static ArrayList<State> frontier = new ArrayList<State>();
    private static int MaxVisited = 100000;
    private static int MaxVisitedIDS = 50;
    private static int createdNodes = 0;
    private static int exploredNodes = 0;
    private static int depth = 0;
    private static int depthIDS = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int rows = 6;
        int columns = 4;

        //getting initial state of rubik
        System.out.println("Enter Rubik : ");
        int init[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                init[i][j] = sc.nextInt();
                //   System.out.println(init[i][j]);
            }
        }
        State root = new State();
        root.a = init;
        // System.out.println(root.a[0][0]);

 //getting wanted algorithm
        System.out.println("enter your algorithm name(UCS/IDS/bidirectional)");
        Scanner scan=new Scanner(System.in);
        String selectedAlgorithm = scan.next();


        if (selectedAlgorithm.equals("UCS")) {  //UCS ALGORITHM
            int cnt = 0;

//root should be visited anyway
            createdNodes++;
//root is added to frontier
            frontier.add(root);

//checking if root is already the goal
            if (Solve.goalTest(root) == 1) {
                System.out.println("goal depth = 0");
                System.out.println("nodes viewed = 1");
                System.out.println("nodes explored = 0");
                //System.out.println("max nodes = 0");
            } else {
//remove root from frontier list

                frontier.remove(0);
                //System.out.println(goalTest(root));
//root is going to be explored
                exploredNodes++;
//root is explored
                explored.add(root);
                State child;
                int power = 0;
                do {
//apply action on the current root to expand its children
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 2; j++) {
                            child = Solve.applyAction(root, i, j);
                            if (child == null)
                                System.out.println("failure");
                            else {
//each child is added to frontier and thus visited
                                createdNodes++;
                                frontier.add(child);
                            }
                        }
                    }
//fifo policy to choose child
                    root = frontier.remove(0);
//the chosen child is going to be expanded thus is added to explored list
                    explored.add(root);
                    exploredNodes++;

//compute depth of goal
                    if ((explored.size()) % (Math.pow(12, power)) == 0)
                        depth++;
//avoiding loop
                    if (cnt > MaxVisited) {
                        System.out.println("couldn't find the goal:)");
                        break;
                    }

                    cnt++;
                    power++;
                } while (Solve.goalTest(root) == 0);  //repeat the process until goal is found

                System.out.println("depth of goal is:" + depth);
                System.out.println("number of created nodes is:" + createdNodes);
                System.out.println("number of explored nodes is:" + exploredNodes);

            }

        } else if (selectedAlgorithm.equals("IDS")) {  //IDS ALGORITHM

            for(int depth = 0; depth < MaxVisitedIDS ;depth++){
                Boolean found = DLS(root,depth);
                if(found!=null){
                    System.out.println("depth of goal is:" + depth);
                    System.out.println("number of created nodes is:" + createdNodes);
                    System.out.println("number of explored nodes is:" + exploredNodes);
                    break;
                }


            }

        } else {
           //biderictional
        }

    }

    private static Boolean DLS(State root, int depth) {


        Boolean foundGoal;
        for (int i = 0 ; i < depth ;i++){
           foundGoal = DFS(root,depth);
            if(foundGoal ) {
             //   System.out.println("yes");
                return true;
            }
            System.out.println("yes");
        }
        System.out.println("nooooo");
           return null;
    }

    private static Boolean DFS(State root ,int limit) {
        int cnt = 0;
        //root should be visited anyway
        createdNodes++;
//root is added to frontier
        frontier.add(root);

//checking if root is already the goal
        if (Solve.goalTest(root) == 1) {
           // System.out.println("goal depth = 0");
            //System.out.println("nodes viewed = 1");
            //System.out.println("nodes explored = 0");
            return true;
            //System.out.println("max nodes = 0");
        } else {
          //  System.out.println("else");


//remove root from frontier list
//            for(int i=0; i<frontier.size();i++){
//                System.out.println(frontier.get(i).a[0][0]);
//            }

            frontier.remove(0);
            //System.out.println(goalTest(root));
//root is going to be explored
            exploredNodes++;
//root is explored
            explored.add(root);
            State child;
           // int power = 0;
            do {
//apply action on the current root to expand its children
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 2; j++) {
                        child = Solve.applyAction(root, i, j);
                       // System.out.println("hello");
                        if (child == null)
                            System.out.println("failure");
                        else {
//each child is added to frontier and thus visited
                            createdNodes++;
                            frontier.add(child);
                        }
                    }
                }
//LIFO policy to choose child(stack)
                root = frontier.remove(frontier.size()-1);
//the chosen child is going to be expanded thus is added to explored list
                explored.add(root);
                exploredNodes++;

//compute depth of goal
                   depthIDS++;
                    if(depthIDS > limit) {
                        System.out.println("couldn't find the goal:(");
                        return false;
                    }
//avoiding loop
                if (cnt > MaxVisited) {
                    break;
                }
                cnt++;
            } while (Solve.goalTest(root) == 0);  //repeat the process until goal is found
            return true;

        }

    }


}


