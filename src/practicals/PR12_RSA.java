/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals;

import java.io.DataInputStream;

import java.io.IOException;

import java.math.BigInteger;

import java.util.Random;

public class PR12_RSA {

    private BigInteger p;

    private BigInteger q;

    private BigInteger N;

    private BigInteger phi;

    private BigInteger e;

    private BigInteger d;

    private int bitlength = 1024;

    private Random r;

    public PR12_RSA() {

        r = new Random();

        p = BigInteger.probablePrime(bitlength, r);

        q = BigInteger.probablePrime(bitlength, r);

        N = p.multiply(q);

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitlength / 2, r);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {

            e.add(BigInteger.ONE);

        }

        d = e.modInverse(phi);

    }

    public PR12_RSA(BigInteger e, BigInteger d, BigInteger N) {

        this.e = e;

        this.d = d;

        this.N = N;

    }

    @SuppressWarnings("deprecation")

    public static void main(String[] args) throws IOException {

        PR12_RSA rsa = new PR12_RSA();

        DataInputStream in = new DataInputStream(System.in);

        String teststring;

        System.out.println("Enter the plain text:");

        teststring = in.readLine();

        // encrypt
        byte[] encrypted = rsa.encrypt(teststring.getBytes());

        // decrypt
        byte[] decrypted = rsa.decrypt(encrypted);
        
        System.out.println("Original String: " + teststring);
        System.out.println("Original String  in Bytes: "
                + bytesToString(teststring.getBytes()));
        System.out.println("Encrypted in Bytes: "
                + bytesToString(encrypted));
        System.out.println("Encrypted String: " + new String(encrypted));

        

       

        System.out.println("Decrypted String in Bytes: " + bytesToString(decrypted));

        System.out.println("Decrypted String: " + new String(decrypted));

    }

    private static String bytesToString(byte[] encrypted) {

        String test = "";

        for (byte b : encrypted) {

            test += Byte.toString(b);

        }

        return test;

    }

        // Encrypt message
    public byte[] encrypt(byte[] message) {

        return (new BigInteger(message).modPow(e, N)).toByteArray();

    }

        // Decrypt message
    public byte[] decrypt(byte[] message) {

        return (new BigInteger(message)).modPow(d, N).toByteArray();

    }

}

