package arrays;

//I wonder when i am gonna solve it on ma own XD
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int acc = 0, total = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            acc += diff;
            if (acc < 0) {
                acc = 0;
                start = i + 1;
            }
        }

        return total < 0 ? -1 : start;
    }
}
