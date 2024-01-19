package com.bizplus.samplecustomer.support;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class GenerateUtil {
    public static String generateRandomText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomText = new StringBuilder();

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomText.append(randomChar);
        }

        return randomText.toString();
    }

    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "test.com"};
        String randomDomain = domains[new SecureRandom().nextInt(domains.length)];

        return generateRandomText(8) + "@" + randomDomain;
    }

    public static Date generateRandomDate() {
        // 시작일과 종료일 지정
        LocalDate startDate = LocalDate.of(2000, 1, 1); // 시작일
        LocalDate endDate = LocalDate.now(); // 현재일

        // 랜덤한 일수를 생성 // 에포크 날짜 = 1970.01.01
        long randomDay = startDate.toEpochDay() + new Random().nextInt((int) (endDate.toEpochDay() - startDate.toEpochDay()));

        // 랜덤한 일수를 날짜로 변환
        LocalDate localDate = LocalDate.ofEpochDay(randomDay);
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        return Date.from(instant);
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        Random random = new Random();
        T[] values = clazz.getEnumConstants();
        return values[random.nextInt(values.length)];
    }
}
