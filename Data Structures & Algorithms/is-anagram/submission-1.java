class Solution {
    public boolean isAnagram(String s, String t) {
        // Quick edge cases
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        // Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // Turn strings into Map
        sMap = turnStringIntoMap(s);
        tMap = turnStringIntoMap(t);

        // Compare the maps to see if they are the same
        return areMapsTheSame(tMap, sMap);

    }

    private HashMap<Character, Integer> turnStringIntoMap(String toMapString) {
        HashMap<Character, Integer> newMap = new HashMap<>();

        char[] charArray = toMapString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (newMap.containsKey(charArray[i])) {
                newMap.put(charArray[i], newMap.get(charArray[i]) + 1);
            }
            else {
                newMap.put(charArray[i], 1);
            }
        }

        return newMap;
    }

    private boolean areMapsTheSame(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap) {
        // We need to find the exact same, maps.  Exact same maps will have same length, and same keys.  Should we order? Probably not
        if (tMap.size() != sMap.size()) {
            return false;
        }

        Set<Character> sKeySet = sMap.keySet();
        // And then we compare
        for (Character key: sKeySet) {
            if (!tMap.containsKey(key) || !(tMap.get(key).equals(sMap.get(key)))) {
                return false;
            }
        }

        return true;
    }
}
