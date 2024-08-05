package heap.priorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
CodeChef: ChefTeams

*
The executive chef is trying to bring some competitive spirit into his kitchen.
He wants to split the chefs into two teams based on their age -
he'll form the young and the old team.
 To make it fair, he will split them evenly or give the young team
one person advantage when there is an odd number of chefs.
Ages of all employees are unique.
The executive chef also rated all chefs according to their cooking skills.
Rating of a team is equal to the sum of ratings of its members.
The chefs have developed a habit of coming to work late.
 The executive chef wants to keep the teams as fair as possible at all times and
is therefore forced to change the teams each time one of the chefs comes to work
in the morning. He needs your help with this task.

input:
5
2 3
1 7
5 5
3 1
8 15

output:
3
4
5
4
9
* * */

public class ChefTeams {

    static class Chef implements Comparable<Chef> {
        int age;
        int rating;

        Chef(int age, int rating) {
            this.age = age;
            this.rating = rating;
        }

        @Override
        public int compareTo(Chef other) {
            return Integer.compare(this.age, other.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Chef> youngTeam = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Chef> oldTeam = new PriorityQueue<>();
        long youngSum = 0, oldSum = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            int rating = Integer.parseInt(st.nextToken());

            if (youngTeam.size() <= oldTeam.size()) {
                youngTeam.offer(new Chef(age, rating));
                youngSum += rating;
            } else {
                oldTeam.offer(new Chef(age, rating));
                oldSum += rating;
            }

            while (!youngTeam.isEmpty() && !oldTeam.isEmpty() && youngTeam.peek().age > oldTeam.peek().age) {
                Chef oldChef = oldTeam.poll();
                Chef youngChef = youngTeam.poll();
                youngTeam.offer(oldChef);
                oldTeam.offer(youngChef);
                youngSum = youngSum - youngChef.rating + oldChef.rating;
                oldSum = oldSum - oldChef.rating + youngChef.rating;
            }

            out.println(Math.abs(youngSum - oldSum));
        }
        out.flush();
    }
}
