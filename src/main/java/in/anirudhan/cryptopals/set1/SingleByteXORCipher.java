package in.anirudhan.cryptopals.set1;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.util.*;

class Result implements Comparable{
    String string;
    char key;
    float score;

    public Result(String s, char i, float score){
        this.string  = s;
        this.key = i;
        this.score = score;
    }

    public String getString() {
        return string;
    }

    public char getKey() {
        return key;
    }

    public float getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return new Float(((Result) o).getScore()).compareTo(this.score);
    }

    public String toString(){
        return this.string + " " + this.key + " " + this.score + "\n";
    }
}

public class SingleByteXORCipher {
    public static  void main(String args[]) throws DecoderException {
        String hexString = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";

        Map<Character, Float> charFreq = new HashMap<>();
        charFreq.put('a', 0.0651738f);
        charFreq.put('b', 0.0124248f);
        charFreq.put('c', 0.0217339f);
        charFreq.put('d', 0.0349835f);
        charFreq.put('e', 0.1041442f);
        charFreq.put('f', 0.0197881f);
        charFreq.put('g', 0.0158610f);

        charFreq.put('h', 0.0492888f);
        charFreq.put('i', 0.0558094f);
        charFreq.put('j', 0.0009033f);
        charFreq.put('k', 0.0050529f);
        charFreq.put('l', 0.0331490f);
        charFreq.put('m', 0.0202124f);
        charFreq.put('n', 0.0564513f);

        charFreq.put('o', 0.0596302f);
        charFreq.put('p', 0.0137645f);
        charFreq.put('q', 0.0008606f);
        charFreq.put('r', 0.0497563f);
        charFreq.put('s', 0.0515760f);
        charFreq.put('t', 0.0729357f);
        charFreq.put('u', 0.0225134f);

        charFreq.put('v', 0.0082903f);
        charFreq.put('w', 0.0171272f);
        charFreq.put('x', 0.0013692f);
        charFreq.put('y', 0.0145984f);
        charFreq.put('z', 0.0007836f);
        charFreq.put(' ', 0.1918182f);
//        charFreq.put('a',0.0651738f);
//        charFreq.put('b',1.492f);
//        charFreq.put('c',2.202f);
//        charFreq.put('d',4.253f);
//        charFreq.put('e',11.162f);
//        charFreq.put('f',2.228f);
//        charFreq.put('g',2.015f);
//        charFreq.put('h',6.094f);
//        charFreq.put('i',7.546f);:/
//        charFreq.put('j',0.153f);
//        charFreq.put('k',1.292f);
//        charFreq.put('l',4.025f);
//        charFreq.put('m',2.406f);;
//        charFreq.put('n',6.749f);
//        charFreq.put('o',7.507f);
//        charFreq.put('p',1.929f);
//        charFreq.put('q',0.095f);
//        charFreq.put('r',7.587f);
//        charFreq.put('s',6.327f);
//        charFreq.put('t',9.356f);
//        charFreq.put('u',2.758f);
//        charFreq.put('v',0.978f);
//        charFreq.put('w',2.560f);
//        charFreq.put('x',0.150f);
//        charFreq.put('y',1.994f);
//        charFreq.put('z',0.077f);

        byte[] bytes = Hex.decodeHex(hexString);

        Set<Result> results = new TreeSet<>();

        for(int i =0; i<256;i++){
            byte b = (byte) i;
            float score = 0.0f;
            byte[] result = new byte[bytes.length];
            for(int j = 0; j < bytes.length; j++){
                result[j] = (byte) (bytes[j] ^ b);

                char ch = Character.toLowerCase((char)result[j]);
                score = score + (charFreq.containsKey(ch)?charFreq.get(ch): 0);
            }
            results.add(new Result(new String(result), (char)i, score));
        }

        System.out.println(((TreeSet)results).first());
    }
}
