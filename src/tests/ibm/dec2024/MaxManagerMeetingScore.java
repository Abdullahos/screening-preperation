package tests.ibm.dec2024;

import java.util.List;

public class MaxManagerMeetingScore {

    public int getMax(List<Integer> meetingScore) {
        meetingScore.sort(Integer::compareTo);
        int counts = 0;
        int score = 0;

        for (int i = 1; i < meetingScore.size(); i++) {
            score += meetingScore.get(i);
            if (score > 0) {
                counts++;
            }
        }

        return counts;
    }
}
