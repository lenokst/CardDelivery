package ru.netology;

import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator(){
    }

    @Value
    public static class UserInfo {
        private String city;
        private String fullName;
        private String phone;
    }


    public static String getDateMeeting(int plusDays) {
        final String dateFormatWithDots = "dd.MM.yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatWithDots);
        LocalDate newDateMeeting = LocalDate.now().plusDays(plusDays);
        return newDateMeeting.format(formatter);
    }


    public static UserInfo getUserInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(
                generateCity(),
                faker.name().lastName()+" "+faker.name().firstName(),
                faker.phoneNumber().phoneNumber());
    }

    public static String generateCity() {
        String[] CityList = new String[]{"Москва", "Санкт-Петербург", "Самара", "Ульяновск"};
        int n = (int) Math.floor(Math.random() * CityList.length);
        return CityList[n];
    }
}