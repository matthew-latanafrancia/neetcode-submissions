class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Brute force: To brute force this, we can have a hash set for each string and then 1 by one go through each one.  This would end up being O(n^2)
        // Not sure how else we could do this though
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Create a frequency array for lowercase English letters
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // 2. Convert the array into a unique string key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // Delimiter prevents collisions
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            // 3. Group the word under its frequency key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
