class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int[] common = new int[26];

        // Count characters of first word
        for (char ch : words[0].toCharArray()) {
            common[ch - 'a']++;
        }

        // Compare with remaining words
        for (int i = 1; i < words.length; i++) {
            int[] count = new int[26];

            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], count[j]);
            }
        }

        // Add common characters
        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                result.add("" + (char)(i + 'a'));
                common[i]--;
            }
        }

        return result;
    }
}
