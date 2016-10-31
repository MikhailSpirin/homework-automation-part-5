package com.wix;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZodiacSigns {

    static DateFormat dateFormat = new SimpleDateFormat("d/M");

    enum ELEMENT {
        FIRE, EARTH, AIR, WATER,
    }

    enum ZODIACSIGNS {
        ARIES("Aries", "Ram", "21/3-20/4", ELEMENT.FIRE, "Mars"),
        TAURUS("Taurus", "Bull", "21/4-20/5", ELEMENT.EARTH, "Earth"),
        GEMINI("Gemini", "Twins", "21/5-20/6", ELEMENT.AIR, "Mercury"),
        CANCER("Cancer", "Crab", "21/6-20/7", ELEMENT.WATER, "Moon"),
        LEO("Leo", "Lion", "21/7-20/8", ELEMENT.FIRE, "Sun"),
        VIRGO("Virgo", "Maiden", "21/8-20/9", ELEMENT.EARTH, "Mercury"),
        LIBRA("Libra", "Scales", "21/9-20/10", ELEMENT.AIR, "Venus"),
        SCORPIO("Scorpio", "Scorpion", "21/10-20/11", ELEMENT.WATER, "Pluto"),
        SAGITTARIUS("Sagitarius", "Archer", "21/11-20/12", ELEMENT.FIRE, "Jupiter"),
        CAPRICORN("Capricorn", "Great Horn", "21/12-20/1", ELEMENT.EARTH, "Saturn"),
        AQUARIUS("Aquarius", "Water Carrier", "21/1-20/2", ELEMENT.AIR, "Uranus"),
        Pisces("Pisces", "Fish", "21/2-20/3", ELEMENT.WATER, "Neptune");

        ZODIACSIGNS(String name, String translation, String dates, ELEMENT element, String planet) {
            this.name = name;
            this.translation = translation;
            this.dates = dates;
            this.element = element;
            this.planet = planet;
        }

        private String name;
        private String translation;
        private String dates;
        private ELEMENT element;
        private String planet;

        public String getName() {
            return name;
        }

        public String getTranslation() {
            return translation;
        }

        public Date getStartDate() {
            Date date = null;
            try {
                date = dateFormat.parse(dates.split("-")[0]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        public Date getFinishDate() {
            Date date = null;
            try {
                date = dateFormat.parse(dates.split("-")[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        public ELEMENT getElement() {
            return element;
        }

        public String getPlanet() {
            return planet;
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        String currentDate = date.getDate() + "/" + (date.getMonth() + 1);
        try {
            date = dateFormat.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (ZODIACSIGNS sign : ZODIACSIGNS.values()) {
            if (date.after(sign.getStartDate()) && date.before(sign.getFinishDate())) {
                System.out.println(currentDate);
                System.out.println("sign is: " + sign.getName());
                System.out.println("translation is: " + sign.getTranslation());
                System.out.println("element is: " + sign.getElement());
                System.out.println("start date from: " + dateFormat.format(sign.getStartDate())
                        + " to: " + dateFormat.format(sign.getFinishDate()));
                System.out.println("Planet: " + sign.getPlanet());
            }
        }
    }
}
