package Model;

public class Atm {
    int money;
    String openTime;
    String closeTime;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Atm(int money, String openTime, String closeTime) {
        this.money = money;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
}
