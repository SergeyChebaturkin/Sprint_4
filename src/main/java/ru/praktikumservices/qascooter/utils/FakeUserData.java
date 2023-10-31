package ru.praktikumservices.qascooter.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;

public class FakeUserData {

    private static final Faker faker = new Faker(new Locale("ru", "RU"));
    private static final FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("ru", "RU"), new RandomService());
    public static String randomFirstName() {
        return faker.name().firstName();
    }
    public static String randomSurname() {
        return faker.name().lastName();
    }

    public static String randomAddress() {
        return faker.address().streetAddress();
    }

    public static String randomPhone() {
        return fakeValuesService.regexify("(+7|8)9[1-9]{9}");
    }

    public static int randomMetroIndex() {
        return faker.number().numberBetween(1, 237);
    }
    public static String randomNumber() {
        return fakeValuesService.regexify("[1-9]{6}");
    }
}