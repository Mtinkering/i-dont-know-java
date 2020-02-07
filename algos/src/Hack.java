class Hack {
    public static int repeatedStringMatch(String A, String B) {
        int a = A.length();
        int b = B.length();

        for (int i = 0; i < a; i ++) {
            int k = i;
            int l = i;
            int j = 0;

            while (A.charAt(l) == B.charAt(j)) {
                j += 1;

                if (j == b){
                    return k/a + 1;
                }

                k += 1;
                l = k%a;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abc";

        char c = s.charAt(1);
        int[] y = new int[30];
        y[c] = 2;

        System.out.println(y);
    }
}