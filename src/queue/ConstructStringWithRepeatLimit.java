package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/construct-string-with-repeat-limit/submissions/

public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        Queue<Element> q = new PriorityQueue<>(new ElementComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int freq = freqs[c - 'a'];
            if (freq == 0)  continue;
            q.offer(new Element(c, repeatLimit, freq));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Element e = q.remove();
            sb.append(e.c);
            e.n--;
            e.p--;
            if (e.n == 0)   continue;
            if (e.p == 0) {
                if (!q.isEmpty()) {
                    Element next = q.remove();
                    sb.append(next.c);
                    next.n--;
                    next.p = repeatLimit;
                    if (next.n > 0) {
                        q.offer(next);
                    }
                    e.p = Math.min(repeatLimit, e.n);
                }
                else break;
            }
            if (e.n == 0)   continue;
            q.offer(e);
        }

        return sb.toString();
    }
}

class ElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element e1, Element e2) {
        return e2.c - e1.c;
    }
}

class Element {
    char c;
    int p;
    int n;

    public Element(char c, int p, int n) {
        this.c = c;
        this.p = Math.min(p, n);
        this.n = n;
    }
}