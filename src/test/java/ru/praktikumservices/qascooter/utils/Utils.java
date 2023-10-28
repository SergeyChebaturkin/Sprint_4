package ru.praktikumservices.qascooter.utils;

import java.util.Random;

public class Utils {
    private static final Random randomizer = new Random();

    public static String randomString() {
        return randomString(10);
    }

    public static String randomString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;
        StringBuilder buffer = new StringBuilder(length);

        for(int i = 0; i < length; ++i) {
            int randomLimitedInt = leftLimit + (int)(randomizer.nextFloat() * (float)(rightLimit - leftLimit + 1));
            buffer.append(Character.toChars(randomLimitedInt));
        }

        return buffer.toString();
    }

    public static String getRandomPhone() {
        String s = "123456789";
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }

        String[] prefixes = new String[] {"+79", "89"};
        return prefixes[randomizer.nextInt(prefixes.length)] + phoneNumber;
    }

    public static String getRandomWord(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = randomizer.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }

        return sb.toString();
    }
}