class Solution {
    public boolean isPalindrome(String s) {
        // 2 pointer system might be the best thing we can do.
        // We have one pointer start on the right and one start in the left
        if (s.length() == 0) {
            return true;
        }
        String removedSpaces = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(removedSpaces);
        char[] charArray = removedSpaces.toCharArray();

        int leftStart = 0;
        int rightStart = charArray.length - 1;
        while (leftStart < rightStart) {
            // If left and right index are the same keep going
            // If they aren't the same, stop right there
            if (Character.toLowerCase(charArray[leftStart]) != Character.toLowerCase(charArray[rightStart])) {
                return false;
            }

            // move left pointer right and move right pointer left
            leftStart++;
            rightStart--;
        }

        // If we get out of the while loop, return true
        return true;
    }
}
