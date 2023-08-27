public class RemoveDuplicate {
    public static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        String input = "KEYYWORD" + ALPHABET;
        StringBuilder output = new StringBuilder();
        //String output = "";
        for (char c : input.toCharArray()) {
            if (output.indexOf(String.valueOf(c)) == -1) {
                output.append(c);
            }
        }
        System.out.println(output.toString());
    }
}
