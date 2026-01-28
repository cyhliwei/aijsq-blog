package com.github.paicoding.forum.service.article.repository.entity;
import java.security.SecureRandom;

public class SecureRandomStringGenerator {
    private static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static final int ID_LENGTH = 46; // 长度可以根据需要调整
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(CHAR_LIST.length());
            sb.append(CHAR_LIST.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String id = generateRandomString();
        System.out.println(id);
    }
}
