package heap.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// CodeChef: Heap: IPC Trainers
public class IPCTrainers {

    public static void main(String[] args) throws java.lang.Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int test = 0; test < tc; test++) {
            String s1[] = br.readLine().split(" ");

            int totalTrainers = Integer.parseInt(s1[0]);
            int totalDays = Integer.parseInt(s1[1]);

            ArrayList < Trainer > [] arr = new ArrayList[totalDays]; //array of type arraylist which are of DataType Trainers

            for (int i = 0; i < totalTrainers; i++) {
                String s2[] = br.readLine().split(" ");
                int d = Integer.parseInt(s2[0]);
                int t = Integer.parseInt(s2[1]);
                int s = Integer.parseInt(s2[2]);

                Trainer tr = new Trainer(d, t, s);

                if (arr[d - 1] == null)
                    arr[d - 1] = new ArrayList<>();
                arr[d - 1].add(tr);
            }
            PriorityQueue< Trainer > pq = new PriorityQueue <> (
                    (Trainer t1, Trainer t2) -> (t1.sadness < t2.sadness) ? 1 : -1
            );
            long remSadness = 0;
            for (int i = 0; i < totalDays; i++) {
                if (arr[i] != null) {
                    for (int j = 0; j < arr[i].size(); j++)
                        pq.add(arr[i].get(j));
                }
                if (pq.size() > 0) {
                    Trainer tr = pq.peek();
                    if (tr.lectures <= 1)
                        pq.poll();
                    else
                        tr.lectures--;
                }
            }
            while (pq.size() > 0) {
                Trainer tr = pq.poll();
                remSadness += (long) tr.lectures * tr.sadness;
            }
            sb.append(remSadness + "\n");
        }
        System.out.println(sb);
    }
}

/*
class TrainerComparator implements Comparator< Trainer > {
    public int compare(Trainer t1, Trainer t2) {
        return (t1.sadness < t2.sadness) ? 1 : -1;
    }
}*/

class Trainer
{
    int dayArrive, lectures, sadness;
    Trainer(int d, int t, int s)
    {
        dayArrive = d;
        lectures = t;
        sadness = s;
    }
}