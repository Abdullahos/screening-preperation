package greedy;

public class LexicographicallyLargestStringPossibleByAtMostkReplacements {

    public String construct(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int accK = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(accK);
            if (c != 'z') {
                c = 'z';
                accK++;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LexicographicallyLargestStringPossibleByAtMostkReplacements l = new LexicographicallyLargestStringPossibleByAtMostkReplacements();
        assert l.construct("dbza", 1).equals("zbza");
        assert l.construct("zzzz", 2).equals("zzzz");
        assert l.construct("zzzz", 0).equals("zzzz");
    }

}
