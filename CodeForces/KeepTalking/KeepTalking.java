import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class KeepTalking implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new KeepTalking(), "whatever", 1<<26).start();
    }
    public int[] num;
    public int[] result;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        num = new int[101];
        result = new int[101];
        for (int i = 0; i < input.length()-1; i++) {
            num[i+1] = input.charAt(i) - '0';
            result[i+1] = num[i+1];
        }
        generatedCode();
        for (int i = 1; i < 101; i++) {
            System.out.print(result[i]);
        }
    }

    public void rotate(int pos, int add) {
        result[pos] = (result[pos] + add) % 10;
    }

    public void generatedCode() {
        if (num[39] % 2 != 0) {
                rotate(39, 9);
        }else {
                rotate(37, 1);
        }
        if (num[24] % 2 != 0) {
                rotate(24, 1);
        }else {
                rotate(76, 3);
        }
        if (num[13] + num[91] > 10) {
                rotate(14, 6);
        }else {
                rotate(34, 8);
        }
        if (num[87] % 2 != 0) {
                rotate(87, 7);
        }else {
                rotate(22, 9);
        }
        if (num[79] > num[15]) {
                rotate(74, 7);
        }else {
                rotate(84, 6);
        }
        if (num[26] + num[66] > 9) {
                rotate(31, 7);
        }else {
                rotate(95, 4);
        }
        if (num[53] + num[1] > 8) {
                rotate(66, 1);
        }else {
                rotate(94, 6);
        }
        if (num[41] > num[29]) {
                rotate(67, 5);
        }else {
                rotate(41, 9);
        }
        if (num[79] + num[20] > 10) {
                rotate(18, 2);
        }else {
                rotate(72, 9);
        }
        if (num[14] + num[24] > 10) {
                rotate(64, 2);
        }else {
                rotate(84, 2);
        }
        if (num[16] > num[34]) {
                rotate(81, 5);
        }else {
                rotate(15, 2);
        }
        if (num[48] + num[65] > 9) {
                rotate(57, 2);
        }else {
                rotate(28, 5);
        }
        if (num[81] % 2 != 0) {
                rotate(81, 5);
        }else {
                rotate(25, 4);
        }
        if (num[70] % 2 != 0) {
                rotate(70, 9);
        }else {
                rotate(93, 3);
        }
        if (num[92] + num[49] > 9) {
                rotate(81, 2);
        }else {
                rotate(42, 3);
        }
        if (num[96] > num[20]) {
                rotate(45, 4);
        }else {
                rotate(45, 1);
        }
        if (num[91] > num[21]) {
                rotate(60, 3);
        }else {
                rotate(72, 1);
        }
        if (num[89] > num[7]) {
                rotate(98, 9);
        }else {
                rotate(52, 7);
        }
        if (num[38] > num[97]) {
                rotate(92, 6);
        }else {
                rotate(35, 4);
        }
        if (num[96] > num[99]) {
                rotate(42, 4);
        }else {
                rotate(40, 9);
        }
        if (num[86] % 2 != 0) {
                rotate(86, 1);
        }else {
                rotate(14, 3);
        }
        if (num[23] % 2 != 0) {
                rotate(23, 5);
        }else {
                rotate(55, 9);
        }
        if (num[79] % 2 != 0) {
                rotate(79, 1);
        }else {
                rotate(29, 8);
        }
        if (num[4] > num[91]) {
                rotate(98, 8);
        }else {
                rotate(69, 4);
        }
        if (num[93] > num[24]) {
                rotate(75, 9);
        }else {
                rotate(95, 3);
        }
        if (num[32] + num[50] > 10) {
                rotate(91, 3);
        }else {
                rotate(1, 5);
        }
        if (num[81] > num[31]) {
                rotate(86, 7);
        }else {
                rotate(67, 5);
        }
        if (num[83] > num[86]) {
                rotate(48, 7);
        }else {
                rotate(2, 6);
        }
        if (num[20] > num[88]) {
                rotate(9, 2);
        }else {
                rotate(99, 4);
        }
        if (num[14] % 2 != 0) {
                rotate(14, 5);
        }else {
                rotate(97, 7);
        }
        if (num[38] > num[14]) {
                rotate(48, 2);
        }else {
                rotate(81, 5);
        }
        if (num[92] > num[74]) {
                rotate(92, 1);
        }else {
                rotate(50, 9);
        }
        if (num[76] > num[89]) {
                rotate(68, 6);
        }else {
                rotate(69, 5);
        }
        if (num[2] > num[28]) {
                rotate(75, 1);
        }else {
                rotate(89, 1);
        }
        if (num[67] % 2 != 0) {
                rotate(67, 9);
        }else {
                rotate(49, 1);
        }
        if (num[23] % 2 != 0) {
                rotate(23, 1);
        }else {
                rotate(59, 3);
        }
        if (num[81] % 2 != 0) {
                rotate(81, 9);
        }else {
                rotate(9, 4);
        }
        if (num[92] + num[82] > 9) {
                rotate(81, 2);
        }else {
                rotate(91, 5);
        }
        if (num[42] + num[48] > 9) {
                rotate(35, 8);
        }else {
                rotate(59, 6);
        }
        if (num[55] % 2 != 0) {
                rotate(55, 9);
        }else {
                rotate(61, 6);
        }
        if (num[83] % 2 != 0) {
                rotate(83, 5);
        }else {
                rotate(85, 4);
        }
        if (num[96] % 2 != 0) {
                rotate(96, 1);
        }else {
                rotate(72, 4);
        }
        if (num[17] % 2 != 0) {
                rotate(17, 1);
        }else {
                rotate(28, 3);
        }
        if (num[85] > num[74]) {
                rotate(37, 3);
        }else {
                rotate(10, 3);
        }
        if (num[50] + num[67] > 9) {
                rotate(85, 9);
        }else {
                rotate(42, 4);
        }
        if (num[11] + num[43] > 10) {
                rotate(56, 7);
        }else {
                rotate(50, 7);
        }
        if (num[95] + num[64] > 9) {
                rotate(95, 4);
        }else {
                rotate(95, 9);
        }
        if (num[21] + num[16] > 9) {
                rotate(87, 3);
        }else {
                rotate(30, 1);
        }
        if (num[91] % 2 != 0) {
                rotate(91, 1);
        }else {
                rotate(77, 1);
        }
        if (num[95] > num[82]) {
                rotate(53, 2);
        }else {
                rotate(100, 5);
        }
        if (num[88] + num[66] > 10) {
                rotate(34, 4);
        }else {
                rotate(57, 4);
        }
        if (num[73] > num[84]) {
                rotate(52, 3);
        }else {
                rotate(42, 9);
        }
        if (num[66] > num[38]) {
                rotate(94, 7);
        }else {
                rotate(78, 7);
        }
        if (num[23] > num[12]) {
                rotate(78, 2);
        }else {
                rotate(62, 8);
        }
        if (num[13] > num[9]) {
                rotate(42, 7);
        }else {
                rotate(1, 9);
        }
        if (num[43] > num[29]) {
                rotate(20, 2);
        }else {
                rotate(47, 2);
        }
        if (num[100] + num[51] > 8) {
                rotate(10, 6);
        }else {
                rotate(89, 1);
        }
        if (num[19] > num[37]) {
                rotate(26, 7);
        }else {
                rotate(30, 8);
        }
        if (num[73] > num[25]) {
                rotate(77, 3);
        }else {
                rotate(41, 1);
        }
        if (num[67] + num[96] > 10) {
                rotate(47, 6);
        }else {
                rotate(33, 5);
        }
        if (num[11] > num[10]) {
                rotate(33, 3);
        }else {
                rotate(4, 3);
        }
        if (num[85] % 2 != 0) {
                rotate(85, 7);
        }else {
                rotate(37, 9);
        }
        if (num[14] % 2 != 0) {
                rotate(14, 1);
        }else {
                rotate(28, 4);
        }
        if (num[30] + num[18] > 8) {
                rotate(93, 5);
        }else {
                rotate(68, 1);
        }
        if (num[54] + num[72] > 8) {
                rotate(88, 8);
        }else {
                rotate(25, 8);
        }
        if (num[72] % 2 != 0) {
                rotate(72, 5);
        }else {
                rotate(10, 3);
        }
        if (num[15] % 2 != 0) {
                rotate(15, 3);
        }else {
                rotate(68, 1);
        }
        if (num[81] + num[31] > 9) {
                rotate(2, 5);
        }else {
                rotate(35, 1);
        }
        if (num[57] % 2 != 0) {
                rotate(57, 1);
        }else {
                rotate(25, 9);
        }
        if (num[75] + num[51] > 9) {
                rotate(73, 8);
        }else {
                rotate(49, 1);
        }
        if (num[81] + num[61] > 10) {
                rotate(61, 3);
        }else {
                rotate(88, 1);
        }
        if (num[60] % 2 != 0) {
                rotate(60, 1);
        }else {
                rotate(31, 2);
        }
        if (num[93] % 2 != 0) {
                rotate(93, 5);
        }else {
                rotate(50, 1);
        }
        if (num[19] + num[82] > 9) {
                rotate(48, 7);
        }else {
                rotate(88, 8);
        }
        if (num[45] % 2 != 0) {
                rotate(45, 7);
        }else {
                rotate(100, 1);
        }
        if (num[46] > num[71]) {
                rotate(28, 8);
        }else {
                rotate(37, 6);
        }
        if (num[79] % 2 != 0) {
                rotate(79, 5);
        }else {
                rotate(10, 1);
        }
        if (num[19] > num[95]) {
                rotate(76, 9);
        }else {
                rotate(95, 8);
        }
        if (num[49] % 2 != 0) {
                rotate(49, 5);
        }else {
                rotate(66, 3);
        }
        if (num[62] % 2 != 0) {
                rotate(62, 1);
        }else {
                rotate(26, 8);
        }
        if (num[67] > num[33]) {
                rotate(27, 8);
        }else {
                rotate(96, 2);
        }
        if (num[73] + num[15] > 8) {
                rotate(98, 6);
        }else {
                rotate(11, 6);
        }
        if (num[63] > num[42]) {
                rotate(66, 1);
        }else {
                rotate(58, 2);
        }
        if (num[41] % 2 != 0) {
                rotate(41, 9);
        }else {
                rotate(99, 5);
        }
        if (num[93] % 2 != 0) {
                rotate(93, 5);
        }else {
                rotate(53, 1);
        }
        if (num[46] % 2 != 0) {
                rotate(46, 3);
        }else {
                rotate(64, 4);
        }
        if (num[99] + num[64] > 10) {
                rotate(72, 9);
        }else {
                rotate(51, 5);
        }
        if (num[75] > num[23]) {
                rotate(89, 2);
        }else {
                rotate(76, 7);
        }
        if (num[6] % 2 != 0) {
                rotate(6, 1);
        }else {
                rotate(44, 6);
        }
        if (num[58] % 2 != 0) {
                rotate(58, 3);
        }else {
                rotate(49, 9);
        }
        if (num[5] > num[13]) {
                rotate(46, 9);
        }else {
                rotate(21, 7);
        }
        if (num[44] + num[94] > 9) {
                rotate(36, 4);
        }else {
                rotate(15, 3);
        }
        if (num[52] + num[43] > 8) {
                rotate(29, 8);
        }else {
                rotate(72, 6);
        }
        if (num[87] + num[48] > 9) {
                rotate(61, 8);
        }else {
                rotate(14, 3);
        }
        if (num[81] % 2 != 0) {
                rotate(81, 7);
        }else {
                rotate(64, 2);
        }
        if (num[88] % 2 != 0) {
                rotate(88, 7);
        }else {
                rotate(53, 9);
        }
        if (num[86] + num[78] > 10) {
                rotate(96, 7);
        }else {
                rotate(79, 1);
        }
        if (num[20] % 2 != 0) {
                rotate(20, 7);
        }else {
                rotate(2, 7);
        }
        if (num[77] > num[80]) {
                rotate(60, 5);
        }else {
                rotate(38, 8);
        }
        if (num[65] % 2 != 0) {
                rotate(65, 1);
        }else {
                rotate(85, 3);
        }
    }
}
