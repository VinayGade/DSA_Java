package hashing;

import java.util.*;

//LeetCode 380. Insert Delete GetRandom O(1)

/*
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present.
Returns true if the item was not present, false otherwise.

bool remove(int val) Removes an item val from the set if present.
Returns true if the item was present, false otherwise.

int getRandom() Returns a random element from the current set of elements
 (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
* */

/*
* example
* input:
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
* output:
[null, true, false, true, 2, true, false, 2]

* Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
**/
public class RandomizedSet {

    Map<Integer, Integer> valToIndex;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToIndex=new HashMap<>();
        list=new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not
     already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val))
            return false;

        list.add(val);
        valToIndex.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set.
     Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int i=valToIndex.getOrDefault(val, -1);
        if(i == -1)
            return false;
        Collections.swap(list,i,list.size()-1);
        int swappedWith = list.get(i);
        valToIndex.put(swappedWith, i);
        list.remove(list.size()-1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int max=list.size();
        int min=0;
        int i=(int)(Math.random()*(max-min)+min);
        return list.get(i);
    }
}
