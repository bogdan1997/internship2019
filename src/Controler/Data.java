package Controler;
import Model.Atm;
import Model.CreditCard;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {

   public static HashMap<HashMap<User, List<CreditCard>>, HashMap<Atm, HashMap<Atm, Integer>>> setTimes(){
       HashMap<Atm, HashMap<Atm, Integer>> fAtm = new HashMap<Atm, HashMap<Atm, Integer>>();
       HashMap<Atm, Integer> sAtm0 = new HashMap<Atm, Integer>();
       HashMap<Atm, Integer> sAtm1 = new HashMap<Atm, Integer>();
       HashMap<Atm, Integer> sAtm2 = new HashMap<Atm, Integer>();
       HashMap<Atm, Integer> sAtm3= new HashMap<Atm, Integer>();
       HashMap<Atm, Integer> sAtm4 = new HashMap<Atm, Integer>();
       User user = new User("19.03.2019 - 11:30");
        Atm a0 = new Atm(0,user.getTime(),"user first pos");
        Atm a1 = new Atm(5000,"12:00","18:00");
        Atm a2 = new Atm(5000,"10:00","17:00");
        Atm a3 = new Atm(5000,"22:00","13:00");
        Atm a4 = new Atm(5000,"17:00","01:00");
        sAtm0.put(a1,5);sAtm0.put(a2,60);sAtm0.put(a3,30);sAtm0.put(a4,45);
        fAtm.put(a0,sAtm0);
        sAtm1.put(a2,40); sAtm1.put(a4,45);
        fAtm.put(a1,sAtm1);
        sAtm2.put(a3,15);
        fAtm.put(a2,sAtm2);
        sAtm3.put(a1,40);sAtm3.put(a4,15);
        fAtm.put(a3,sAtm3);
        sAtm4.put(a2,30);
        fAtm.put(a4,sAtm4);

       HashMap<HashMap<User, List<CreditCard>>,HashMap<Atm, HashMap<Atm, Integer>>> users = new HashMap<HashMap<User, List<CreditCard>>,HashMap<Atm, HashMap<Atm, Integer>>> ();
       HashMap<User, List<CreditCard>> user1 = new HashMap<User, List<CreditCard>>();
       List<CreditCard> myList = new ArrayList<>();
       CreditCard c1 = new CreditCard(2000,0.2,"23.05.2020",20000);
       CreditCard c2 = new CreditCard(2000,0.1,"15.08.2018",25000);
       CreditCard c3 = new CreditCard(2000,0,"20.03.2019",3000);
       myList.add(c1);myList.add(c2);myList.add(c3);
       user1.put(user,myList);
       users.put(user1,fAtm);
       return users;
   }

}
