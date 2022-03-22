import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Date;

public class Block {

    private String data;
    private long timeStamp;
    public String hash;
    public String prevHash;
    public int nonce;
    public SHA cryp = new SHA();

    public Block(String data, long timeStamp, String hash, String prevHash) throws NoSuchAlgorithmException {
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculate();
        this.prevHash = prevHash;
    }

    public String calculate() throws NoSuchAlgorithmException {
        return cryp.algorithm(prevHash + data + Long.toString(timeStamp)
                + Integer.toString(nonce));
    }


    public void proofOfWork(String difficulty) throws NoSuchAlgorithmException {
        try {
            while (!hash.startsWith(difficulty)) {
                this.nonce++;
                this.hash = this.calculate();
            }
        } catch (Exception e) {
            throw new NoSuchAlgorithmException(e);
        }
        System.out.println("Block mined." + "\n" + "Hashed Block = " + this.hash);
    }

    public boolean isValid() {
        return true;
    }




}
