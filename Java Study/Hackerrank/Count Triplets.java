import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();
        long ans = 0;
        
        for(long i: arr){
            rightMap.put(i, rightMap.getOrDefault(i,0L)+1);
        }
        
        for(int i = 0 ; i<arr.size();i++){
            long current = arr.get(i);
            long leftOperand = 0;
            long rightOperand = 0;
            rightMap.put(current, rightMap.getOrDefault(current,0L)-1);
            
            if(leftMap.containsKey(current/r) && current%r==0){
                leftOperand = leftMap.get(current/r);
            }
            
            if(rightMap.containsKey(current*r)){
                rightOperand = rightMap.get(current*r);
            }
            
            ans += leftOperand * rightOperand;
            leftMap.put(current, leftMap.getOrDefault(current,0L)+1);
        }
        
        return ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
