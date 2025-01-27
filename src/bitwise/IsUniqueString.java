package bitwise;

public class IsUniqueString {
    private boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        int bitWise = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((bitWise & (1 << val)) > 0) {
                return false;
            }
            bitWise |= (1 << val);
        }
        return true;
    }
}
