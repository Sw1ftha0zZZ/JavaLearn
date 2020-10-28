package algorithm.bitmanipulation.book;

public class BitMap { // Java中char类型占16bit，也即是2个字节
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) {
            return;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;

        //set的时候是按位**或**
        //将1左移bitIndex位
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;

        //get的时候是按位**与**
        //将1左移bitIndex位
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }
}

