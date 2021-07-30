public class LargestNumberKSwaps {

    public static void main(String[] args) {
        String input = "354545344534534543534";
        int[] arr = getMaxNumber(input, 10);
        for(int i : arr) {
            System.out.print(i);
        }
    }

    private static int[] getIntegerArray(String input) {
        char[] charArray = input.toCharArray();
        int[] intArray = new int[charArray.length];
        for(int i = 0; i < charArray.length ; i++ ) {
            intArray[i] = charArray[i] - '0';
        }
        return intArray;
    }

    private static int[] getMaxNumber(String input, int k) {

        int[] inputArr = getIntegerArray(input);
        for(int i = 0 ; k > 0 && i < inputArr.length ; i++){
            int max = inputArr[i];
            int maxPos = i;
            for(int j = i+1; j < inputArr.length; j++) {
                if(max <= inputArr[j]) {
                    max = inputArr[j];
                    maxPos = j;
                }
            }
            if(maxPos != i) {
                int tmp = inputArr[i];
                inputArr[i] = inputArr[maxPos];
                inputArr[maxPos] = tmp;
                k--;
            }
        }
        return inputArr;
    }
}
