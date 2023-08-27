import java.math.BigInteger;

public class ModInverseExample {

    public static void main(String[] args) {
        BigInteger value = new BigInteger("7");
        BigInteger modulus = new BigInteger("6"); // Modulus for the inverse calculation
        
        try {
            BigInteger modInverse = value.modInverse(modulus);
            System.out.println("Modular Inverse: " + modInverse);
        } catch (ArithmeticException e) {
            System.out.println("Modular inverse does not exist.");
        }
    }
}
