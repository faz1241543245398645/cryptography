public class UTF8ToBinary {
    public static void main(String[] args) {
        char character = '€'; // Replace this with the character you want to convert
        
        String binaryRepresentation = utf8ToBinary(character);
        
        System.out.println("UTF-8 character: " + character);
        System.out.println("Binary representation: " + binaryRepresentation);
    }
    
    public static String utf8ToBinary(char character) {
        byte[] utf8Bytes = new String(new char[] { character }).getBytes(java.nio.charset.StandardCharsets.UTF_8);
        
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (byte b : utf8Bytes) {
            String binaryByte = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryStringBuilder.append(binaryByte);
        }
        
        return binaryStringBuilder.toString();
    }
}