package greedy;

import java.util.*;

class Job {

    /*
    Since, the task is to get the maximum profit by scheduling the jobs, the idea is to approach this problem greedily.

    Algorithm

    Sort the jobs based on decreasing order of profit.
    Iterate through the jobs and perform the following:
        Choose a Slot i if:
        Slot i isn’t previously selected.
           I < deadline
            I is maximum
        If no such slot exists, ignore the job and continue.
    * */

    int id;
    int deadline, profit;

    public int getId() {
        return id;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getProfit() {
        return profit;
    }

    public Job() {
    }

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequencingWithDeadline {

    void printJobScheduling(List<Job> arr, int totalJobs)
    {
        int n = arr.size();
        Collections.sort(arr,
                (a, b) -> b.getProfit() - a.getProfit());

        boolean result[] = new boolean[totalJobs];
        int job[] = new int[totalJobs];
        for (int i = 0; i < n; i++)
        {
            for (int j = Math.min(totalJobs - 1, arr.get(i).getDeadline() - 1);
                 j >= 0;
                 j--) {
                if (!result[j])
                {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
        for (int jb : job)
        {
            System.out.print(jb + " ");
        }
        System.out.println();
    }

    public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, new Comparator<int[]>(){
            public int compare(int[] first, int[] second)
            {
                if(first[1] < second[1]) return 1;
                else return -1;
            }
        });

        int maxProfit = 0;
        int maxDeadline = 0;
        for (int i = 0; i < jobs.length; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = maxDeadline; i > 0; i--) {
            set.add(i);
        }
        TreeSet<Integer> slots = (TreeSet<Integer>)set.descendingSet();

        for (int i = 0; i < jobs.length; i++)
        {
            if (slots.size() == 0 || jobs[i][0] < slots.last()) {
                continue;
            }

            Integer availableSlot = -1;

            for (Integer val : slots) {
                if (val <= jobs[i][0]) {
                    availableSlot = val;
                    break;
                }
            }
            if (availableSlot != -1) {
                maxProfit = maxProfit + jobs[i][1];
                slots.remove(availableSlot);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        List<Job> arr = Arrays.asList(
                new Job(0,2,100),
                new Job(1, 1, 50),
                new Job(2, 2, 10),
                new Job(3, 1, 20),
                new Job(4, 3, 30));

        int totalJobs = arr.size();

        JobSequencingWithDeadline jobsequencing = new JobSequencingWithDeadline();
        jobsequencing.printJobScheduling(arr, totalJobs);
    }
}
