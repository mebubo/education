package c01_arrays_and_strings;

public class E01_04 {

        public static void escapeWhitespace(char[] input, int length) {
                int count = 0;
                for (int i=0; i<length; i++) {
                        if (input[i] == ' ') {
                                count++;
                        }
                }
                int newLength = length + count * 2;
                int insertion = newLength -1;
                //input[newLength] = 0;
                for (int i = length - 1; i >= 0; i--) {
                        if (input[i] == ' ') {
                                input[insertion] = '0';
                                input[insertion - 1] = '2';
                                input[insertion - 2] = '%';
                                insertion -= 3;
                        } else {
                                input[insertion] = input[i];
                                insertion--;
                        }
                }
        }

}
