package graph.problems.bfs;

import java.util.*;

//HackerRank: Data Structure: Queue
public class CastleOnGrid {

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        Queue<Integer> rq=new LinkedList<Integer>();
        Queue<Integer> cq=new LinkedList<Integer>();
        Queue<Integer> counterQ=new LinkedList<Integer>();
        boolean[][] visit=new boolean[grid.size()][grid.size()];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.size();j++){
                visit[i][j]=false;
            }
        }
        rq.add(startX);
        cq.add(startY);
        counterQ.add(0);
        int counter=0;
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        while(!rq.isEmpty()){
            int x=rq.remove();
            int y=cq.remove();
            counter=counterQ.remove();
            counter++;
            for(int i=0;i<4;i++){
                int xNew=x;
                int yNew=y;
                while(true){
                    xNew+=dr[i];
                    yNew+=dc[i];
                    //System.out.println(xNew+","+yNew);
                    //stop arguments
                    if(xNew<0 || xNew>=grid.size() || yNew<0 || yNew>=grid.get(xNew).length()
                            ||grid.get(xNew).charAt(yNew)=='X'){
                        System.out.println("B"); break;}
                    //continue or get ans
                    if(xNew==goalX &&yNew==goalY)
                        return counter;
                    else if(!visit[xNew][yNew]){
                        visit[xNew][yNew]=true;
                        rq.add(xNew);
                        cq.add(yNew);
                        counterQ.add(counter);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());  // grid of size n * n

        List<String> grid = new ArrayList<>();
        for(int i=0; i<n; i++){
            String row = scan.nextLine();
            grid.add(row);
        }

        int startX = 0, startY = 0, goalX = 0, goalY = 2;

        int moves = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(moves);
    }
}
