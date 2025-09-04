class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
   
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // Add new element to frequency map
            int num = arr[i];
            int oldFreq = freq.getOrDefault(num, 0);
            int newFreq = oldFreq + 1;
            freq.put(num, newFreq);
            
            // Update freqMap
            if (oldFreq > 0) {
                TreeSet<Integer> set = freqMap.get(oldFreq);
                set.remove(num);
                if (set.isEmpty()) freqMap.remove(oldFreq);
            }
            freqMap.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(num);
            
            // Remove element going out of window
            if (i >= k) {
                int outNum = arr[i - k];
                int outFreq = freq.get(outNum);
                freq.put(outNum, outFreq - 1);
                
                TreeSet<Integer> set = freqMap.get(outFreq);
                set.remove(outNum);
                if (set.isEmpty()) freqMap.remove(outFreq);
                
                if (outFreq - 1 > 0) {
                    freqMap.computeIfAbsent(outFreq - 1, x -> new TreeSet<>()).add(outNum);
                } else {
                    freq.remove(outNum);
                }
            }
            
            // Add mode to sum if window is ready
            if (i >= k - 1) {
                int maxFreq = freqMap.lastKey();
                int mode = freqMap.get(maxFreq).first(); // smallest element with max frequency
                sum += mode;
            }
        }
        
        return sum;
        
    }
}
