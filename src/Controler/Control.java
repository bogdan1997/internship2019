package Controler;

import Model.Atm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Controler.Data;
import Model.CreditCard;
import Model.User;

public class Control {


    private static List<CreditCard> checkCards(List<CreditCard> cards, String date) {
        List<CreditCard> workingCards = new ArrayList<>();
        for (CreditCard card : cards) {
            String cardDate = card.getExDate();
            StringTokenizer st = new StringTokenizer(cardDate, ".");
            StringTokenizer st1 = new StringTokenizer(date, ".");
            String day;
            String month;
            String year;
            day = st.nextToken();
            int cDay = Integer.parseInt(day);
            month = st.nextToken();
            int cMonth = Integer.parseInt(month);
            year = st.nextToken();
            int cYear = Integer.parseInt(year);
            String actualday;
            String actualmonth;
            String actualyear;
            actualday = st.nextToken();
            int aDay = Integer.parseInt(actualday);
            actualmonth = st.nextToken();
            int aMonth = Integer.parseInt(actualmonth);
            actualyear = st.nextToken();
            int aYear = Integer.parseInt(actualyear);
            if (aDay < cDay) {
                if (aMonth < cMonth) {
                    if (aYear < cYear) {
                        workingCards.add(card);
                    }
                } else if (aYear < cYear) {
                    workingCards.add(card);
                }
            } else if (aMonth < cMonth) {
                if (aYear < cYear) {
                    workingCards.add(card);
                }
            } else if (aYear < cYear) {
                workingCards.add(card);
            }

        }
        return workingCards;
    }

    private static boolean atmOpen(Atm atm, int hour, int minute) {
        StringTokenizer st = new StringTokenizer(atm.getCloseTime(), ":");
        int ahour = Integer.parseInt(st.nextToken());
        int aminute = Integer.parseInt(st.nextToken());
        if (ahour >= hour && aminute > minute) {
            StringTokenizer st1 = new StringTokenizer(atm.getOpenTime(), ":");
            ahour = Integer.parseInt(st1.nextToken());
            aminute = Integer.parseInt(st1.nextToken());
            if (ahour <= hour && aminute < minute) {
                return true;
            }

        }
        return false;
    }

    private static List<Atm> atmRoute(int id, Atm atm, HashMap<Atm, HashMap<Atm, Integer>> atms) {

        List<Atm> newList = new ArrayList<>();
        List<Atm> atmroute = new ArrayList<>();

        atmroute.add(atm);
        id++;
        if (id <= atms.size()) {
            for (Atm a : atms.keySet()) {
                if (a.equals(atm)) {
                    for (Atm b : atms.get(a).keySet()) {
                        newList = Stream.concat(atmroute.stream(), atmRoute(id, b, atms).stream())
                                .collect(Collectors.toList());
                    }
                }
            }
        }

        return newList;
    }


    public static List<Atm> getAtmsRoute(HashMap<HashMap<User, List<CreditCard>>, HashMap<Atm, HashMap<Atm, Integer>>> users, int sum) {

        for (HashMap<User, List<CreditCard>> userCred : users.keySet()) {
            String date;
            String time;
            HashMap<Atm, HashMap<Atm, Integer>> atms = users.get(userCred);
            for (User user : userCred.keySet()) {//user time
                List<Atm> route = new ArrayList<>();
                time = user.getTime();
                StringTokenizer st = new StringTokenizer(time, ":");
                int hour = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                date = user.getDate();
                List<CreditCard> cards = userCred.get(user);//get Cards
                List<CreditCard> workingCards = checkCards(cards, date);
                int money = 0;
                for (CreditCard card : workingCards) {
                    money += card.getMoney() - card.getMoney() * card.getFee();
                }
                if (money < sum) {
                    break;
                }
                List<List<Atm>> routeList = new ArrayList<>();
                for (Atm atm : atms.keySet()) {
                    if (atmOpen(atm, hour, minute)) {
                        routeList.add(atmRoute(1, atm, atms));
                    } else {
                        break;
                    }
                }

                for (List<Atm> a : routeList) {
                    int x = 0;
                    for (Atm b : a) {
                        for (Atm c : a) {
                            if (b.equals(c)) {
                                x = 1;
                                break;
                            }
                        }
                        if (x == 1) {
                            break;
                        }
                    }
                    if (x == 0) {
                        return a;
                    }
                }


            }
        }

        return null;

    }
}
