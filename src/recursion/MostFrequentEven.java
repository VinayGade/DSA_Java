package recursion;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentEven {

    public static void main(String[] args) {
        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};

        /*
        {4,4,4,9,2,4}

        [0,1,2,2,4,4,1]

        [29,47,21,41,13,37,25,7]

        [8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290]

        o/p: 8154   exptected : 3346
        *
        *
        * */

        MostFrequentEven even = new MostFrequentEven();

        int frequently = even.mostFrequentEvenNumber(nums);

        System.out.println("frequntly even ="+frequently);
        /*
        map.entrySet().forEach(entry ->{
            System.out.println("number ="+entry.getKey()+" frequency="+entry.getValue());
        });

         */
    }

    // final solution passing all test cases
    public int mostFrequentEvenNumber(int[] nums) {
        //Map<Integer, Integer> table = new HashMap<>();

        Map<Integer, Integer> table = numberFrequency(nums);

        int result = -1;
        int frequency = -1;

        /*
        for(int key : nums)
            if(key % 2 == 0)
                table.put(key, table.getOrDefault(key, 0)+1);

         */

        if(table.size() == 0)
            return -1;

        for(int num : table.keySet()){
            int key = table.get(num);
            if(key > frequency){
                frequency = key;
                result = num;
            }

            if(key == frequency && num < result)
                result = num;
        }

        return result;
    }

    public int mostFrequentEven(int[] nums) {

        //List<Integer> evens = listEvens(nums);

        Map<Integer, Integer> map = numberFrequency(nums);

        map = sortByFrequency(map);

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        int frequency = -1;
        if(!map.isEmpty()) {
            if(new LinkedHashSet<>(map.values()).size() == 1){
                int min = new ArrayList<>(map.keySet()).get(entrySet.size()-1);
                for(Map.Entry<Integer, Integer> entry :entrySet){
                    int num = entry.getKey();
                    if(num < min){
                        min = num;
                    }
                }
                return min;
            } else if (entrySet.size() == nums.length) {
                Arrays.sort(nums);
                return nums[0];
            } else {

                //Map<Integer, Integer> map = numberFrequency(evens);

                /*
                map = sortByFrequency(map);

                map = entrySet
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                 */


                List<Map.Entry<Integer, Integer>> solutions = new ArrayList<>();
                entrySet.forEach(entry -> solutions.add(entry));

                //Map.Entry<Integer, Integer>[] arr = (Map.Entry<Integer, Integer>[]) map.entrySet().toArray();
                int key0 = solutions.get(0).getKey();

                if (solutions.size() > 1) {
                    int key1 = solutions.get(1).getKey();
                    if (solutions.get(0).getValue() == solutions.get(1).getValue()) {
                        if (key0 > key1)
                            frequency = key1;
                        else
                            frequency = key0;
                    } else
                        frequency = key0;
                } else
                    frequency = key0;
            }
        }
        return frequency;
    }

    /*
    private List<Integer> listEvens(int[] nums){

        List<Integer> evens = new ArrayList<>();

        for(int x : nums){

            if(x%2 == 0)
                evens.add(x);
        }
        return evens;
    }
    */

    private Map<Integer, Integer> numberFrequency(int[] nums){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int c : nums)
            if(c%2 == 0)
                map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }

    private Map<Integer, Integer> sortByFrequency(Map<Integer, Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
