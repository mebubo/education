package c01_arrays_and_strings;

public class E01_05 {

    public static String compressUgly(String input) {
        char[] result = new char[input.length()];
        int resultPointer = 0;
        for (int i = 0; i < input.length(); i++) {
            int sequenceStart = i;
            while (i < input.length() && input.charAt(sequenceStart) == input.charAt(i)) {
                i++;
            }
            i--;
            int sequenceLength = i - sequenceStart + 1;
            if (resultPointer >= input.length()) return input;
            result[resultPointer++] = input.charAt(sequenceStart);
            String charCount = String.valueOf(sequenceLength);
            for (int k = 0; k < charCount.length(); k++) {
                if (resultPointer >= input.length()) return input;
                result[resultPointer++] = charCount.charAt(k);
            }
        }
        if (resultPointer >= input.length()) return input;
        return new String(result, 0, resultPointer);
    }

    public static String compressWithStringBuffer(String input) {
        if (input.length() < 2) {
            return input;
        }
        StringBuffer result = new StringBuffer();
        char last = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == last) {
                count++;
            } else {
                result.append(last);
                appendCount(result, count);
                last = input.charAt(i);
                count = 1;
            }
        }
        result.append(last);
        appendCount(result, count);
        if (result.length() >= input.length()) {
            return input;
        } else {
            return result.toString();
        }
    }

    private static void appendCount(StringBuffer buffer, int count) {
        for (char c : String.valueOf(count).toCharArray()) {
            buffer.append(c);
        }
    }
}
