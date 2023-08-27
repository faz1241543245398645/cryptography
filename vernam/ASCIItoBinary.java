public class ASCIItoBinary {
    public static void main(String[] args) {
        char character = 'A'; // Replace this with the ASCII character you want to convert
        
        String binaryRepresentation = asciiToBinary(character);
        
        System.out.println("ASCII character: " + character);
        System.out.println("Binary representation: " + binaryRepresentation);
    }
    
    public static String asciiToBinary(char character) {
        int asciiValue = (int) character;
        String binaryRepresentation = Integer.toBinaryString(asciiValue);
        
        // Ensure the binary representation is 8 bits long
        while (binaryRepresentation.length() < 8) {
            binaryRepresentation = "0" + binaryRepresentation;
        }
        
        return binaryRepresentation;
    }
}