import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public String algorithm(String toBe) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toBe.getBytes(StandardCharsets.UTF_8));
            return byteToHex(hash);
        } catch (Exception e) {
            throw new NoSuchAlgorithmException(e);
        }

    }

    private String byteToHex(byte[] hash) {
        try {
            StringBuilder hex = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hexer = Integer.toHexString(0xff & b);

                if (hexer.length() == 1) {
                    hex.append('0');
                }
                hex.append(hex);
            }
            return hex.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
