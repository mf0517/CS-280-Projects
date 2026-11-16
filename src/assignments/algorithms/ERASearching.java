package assignments.algorithms;

import assignments.datastructures.HashSet;
import assignments.datastructures.VectorSet;
import assignments.datastructures.TreeSet;
import java.util.Random;

public class ERASearching {
    public static void main(String[] args) {
        System.out.println("N, VectorSet (ns), TreeSet (ns), HashSet (ns)");
        
        Random rand = new Random();

        // Adjust your range of N values as needed for your analysis
        for (int i = 10000; i <= 100000; i += 10000) {
            
            // ---------------------------------------------------------
            // 1. Test VectorSet
            // ---------------------------------------------------------
            VectorSet<Integer> vectorSet = new VectorSet<>();
            for (int l = 0; l < i; l++) {
                vectorSet.add(rand.nextInt(i) + 1); // Random numbers between 1 and N
            }
            
            long startVector = System.nanoTime();
            vectorSet.contains(i + 1); // Searching for N+1 (guaranteed miss)
            long endVector = System.nanoTime();
            long vectorTime = endVector - startVector;

            // ---------------------------------------------------------
            // 2. Test TreeSet
            // ---------------------------------------------------------
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int l = 0; l < i; l++) {
                treeSet.add(rand.nextInt(i) + 1);
            }
            
            long startTree = System.nanoTime();
            treeSet.contains(i + 1);
            long endTree = System.nanoTime();
            long treeTime = endTree - startTree;

            // ---------------------------------------------------------
            // 3. Test HashSet
            // ---------------------------------------------------------
            HashSet<Integer> hashSet = new HashSet<>();
            for (int l = 0; l < i; l++) {
                hashSet.add(rand.nextInt(i) + 1);
            }
            
            long startHash = System.nanoTime();
            hashSet.contains(i + 1);
            long endHash = System.nanoTime();
            long hashTime = endHash - startHash;

            // Print the results for this value of N
            System.out.println(hashTime);
        }
    }
}