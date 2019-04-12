package Model;

public class CreditCard {
    int limit;
    double fee;
    String exDate;
    int money;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public CreditCard(int limit, double fee, String exDate, int money) {
        this.limit = limit;
        this.fee = fee;
        this.exDate = exDate;
        this.money = money;
    }
}
