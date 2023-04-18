package extra.simulate;

public class CountDaysSpentTogether_2409 {

    public static void main(String[] args) {

    }
}

class Solution2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String arriveLater = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leaveEarlier = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        int ans = 0;
        if(arriveLater.compareTo(leaveEarlier) <= 0) {
            int arriveMonth = Integer.parseInt(arriveLater.substring(0, 2));
            int arriveDay = Integer.parseInt(arriveLater.substring(3, 5));
            int leaveMonth = Integer.parseInt(leaveEarlier.substring(0, 2));
            int leaveDay = Integer.parseInt(leaveEarlier.substring(3, 5));
            if(arriveMonth == leaveMonth) {
                ans = leaveDay - arriveDay + 1;
            } else {
                ans += days[arriveMonth] - arriveDay + 1;
                for(int i = arriveMonth + 1; i < leaveMonth; i++) {
                    ans += days[i];
                }
                ans += leaveDay;
            }
        }

        return ans;


    }
}
