class Solution {
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();

            String row;

            if (row1.contains("" + w.charAt(0)))
                row = row1;
            else if (row2.contains("" + w.charAt(0)))
                row = row2;
            else
                row = row3;

            boolean ok = true;

            for (char c : w.toCharArray()) {
                if (!row.contains("" + c)) {
                    ok = false;
                    break;
                }
            }

            if (ok)
                list.add(word);
        }

        return list.toArray(new String[0]);
    }
}
