package hashing.hackerrank.bday_cake_candles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {

        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> frequencies = new HashMap<>();

        for(int candle: candles){
            if(candle > max)
                max = candle;  // max = Math.max(candle, max);
            frequencies.put(candle, frequencies.getOrDefault(candle, 0) +1);
        }
        return frequencies.get(max);
    }

    public static void main(String[] args) {
        List<Integer> candles = Arrays.asList(3, 2, 1, 3);
        int max = birthdayCakeCandles(candles);
        System.out.println("tallest candle count = "+max);
    }
}
