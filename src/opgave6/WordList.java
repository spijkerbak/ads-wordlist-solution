
package opgave6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordList {
    // internal list: 
    // - must be kept sorted after every operation
    // - may not contain double values

    private List<String> list;

    String get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println("Run the tests, please!");
    }

    WordList(String[] input) {
        // bubble-sort the input array
        // NOTE: THIS WILL MODIFY THE INPUT ARRAY
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j + 1].compareTo(input[j]) < 0) {
                    String h = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = h;
                }
            }
        }
        // copy array to list, eliminating double values
        list = new ArrayList<>();
        String last = null;
        for(String word : input) {
            if(!word.equals(last)) {
                list.add(word);
                last = word;
            }
        }
    }
    
    WordList(WordList a, WordList b) {
        // merge-sort:
        list = new ArrayList<>();
        int aLen = a.list.size();
        int bLen = b.list.size();
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            int d = a.list.get(i).compareTo(b.list.get(j));
            if (d == 0) {
                list.add(a.list.get(i++));
                j++;
            } else if (d < 0) {
                list.add(a.list.get(i++));
            } else if (d > 0) {
                list.add(b.list.get(j++));
            }
        }
        while (i < aLen) {
            list.add(a.list.get(i++));
        }
        while (j < bLen) {
            list.add(b.list.get(j++));
        }
    }

    boolean hasWord(String word) {
        // binary search
        int first = 0;
        int last = list.size() - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            int dif = list.get(mid).compareTo(word);
            if (dif < 0) {
                first = mid + 1;
            } else if (dif > 0) {
                last = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        // hash per element - exactly what we need
        return this.list.hashCode();

        // return 1; // would work, but makes hashMap one long list
    }

    @Override
    public boolean equals(Object obj) {
        final WordList that = (WordList) obj;
        // equals per element - exactly what we need
        return this.list.equals(that.list);
    }

    private boolean equalsAlternative(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WordList that = (WordList) obj;

        if (this.list.size() != that.list.size()) {
            return false;
        }
        for (int i = 0; i < this.list.size(); i++) {
            if (!this.list.get(i).equals(that.list.get(i))) {
                return false;
            }
        }
        return true;
    }

}
