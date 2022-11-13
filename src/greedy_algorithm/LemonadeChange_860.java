package greedy_algorithm;

import java.util.Scanner;

public class LemonadeChange_860 {

    public static void main(String[] args) {
        Solution860 sol = new Solution860();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] bills = new int[arr.length];
            for (int i = 0; i < bills.length; i++) {
                bills[i] = Integer.parseInt(arr[i]);
            }
            boolean res = sol.lemonadeChange(bills);
            System.out.println(res);
        }

    }


}

class Solution860 {
    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
     *
     * @param bills 账单
     * @return 是否能给每个顾客正确找零
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0) return false;
        }

        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                countFive++;
            }else {
                if(countFive == 0) return false;
                if(bills[i] == 10) {
                    countFive--;
                    countTen++;
                } else {
                    if(countTen == 0 && countFive < 3) return false;
                    if(countTen == 0) {
                        countFive -= 3;
                    } else{
                        countTen--;
                        countFive--;
                    }
                }
            }
        }
        return true;

//            int cntOfFive = 0;
//            int cntOfTen = 0;
//            for(int bill : bills) {
//                if(bill == 5) {
//                    cntOfFive++;
//                } else if(bill == 10) {
//                    if(cntOfFive == 0) return false;
//                    cntOfFive--;
//                    cntOfTen++;
//                } else if(bill == 20) {
//                    if(cntOfFive == 0 || cntOfTen * 10 + cntOfFive * 5 < 15) return false;
//                    if(cntOfTen == 0) {
//                        cntOfFive -= 3;
//                    } else {
//                        cntOfFive--;
//                        cntOfTen--;
//                    }
//                }
//            }
//
//            return true;
    }
}
