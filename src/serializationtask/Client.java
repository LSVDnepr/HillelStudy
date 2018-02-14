package serializationtask;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Client implements Serializable {
    private static int prevClientID = 0;
    private int clientID;
    private String firstName;
    private String lastName;
    private double cardDiscount;
    private LocalDate birthDay;
    private LocalDate firstPurchaseDate;
    private transient boolean checkedIsHoliday =false;
    private static /*transient*/ LocalDate today = LocalDate.now();
    private static final double MAX_DISCOUNT_PERCENT = 0.5;
    private double totalPurchasesSum;
    private transient double holidayDiscount;


    //Просто регистрируем клиента
    public Client(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.length() == 0 || lastName.length() == 0) {
            throw new IllegalArgumentException("Illegal values: First Name=" + firstName + ", Last Name=" + lastName);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        clientID = ++prevClientID;
    }

    public Client(String firstName, String lastName, LocalDate birthDay) {
        this(firstName, lastName);
        this.birthDay = birthDay;

    }


    //регистрация во время покупки
    public Client(String firstName, String lastName, LocalDate birthDay, int currentPurchaseSum) {
        this(firstName, lastName,birthDay);
        if (currentPurchaseSum < 0) throw new IllegalArgumentException("Purchase sum cannot be negative!");
        if (currentPurchaseSum > 0) {
            makePurchase(currentPurchaseSum);
            firstPurchaseDate = today;
        }

    }


    public Client(String firstName, String lastName, int currentPurchaseSum) {
        this(firstName, lastName,null,currentPurchaseSum);
        }



    private double countHolidayDiscount() {
        //Holiday Discount будет 3% - годовщина первой покупки, 5% -День Рождения
        //проверяем - сегодня годовщина первой покупки?

        if (firstPurchaseDate != null) {
            if (firstPurchaseDate.getYear() < today.getYear() && firstPurchaseDate.getMonth() == today.getMonth() && firstPurchaseDate.getDayOfMonth() == today.getDayOfMonth()) {
                holidayDiscount += 0.03;
            }
        } else {
            firstPurchaseDate = today;
            //   return (firstPurchaseDate.getDayOfMonth() == today.getDayOfMonth() && firstPurchaseDate.getMonth() == today.getMonth()&&firstPurchaseDate.YEAR<today.YEAR);
        }

        //проверяем - сегодня ДР клиента?
        if (birthDay != null) {
            if (birthDay.getMonth() == today.getMonth() && birthDay.getDayOfMonth() == today.getDayOfMonth()) {
                holidayDiscount += 0.05;
            }
        }

        checkedIsHoliday =true;
        return holidayDiscount;
    }


    //провести покупку
    public void makePurchase(double currentPurchaseSum) {
        if (currentPurchaseSum < 0)
            throw new IllegalArgumentException("Illegal value: purchase sum=" + currentPurchaseSum);
        if (currentPurchaseSum == 0) {
            System.out.printf("Purchase sum=%.2f%s", currentPurchaseSum, " No changes required");
            return;
        }
        System.out.printf("Сумма покупки= %.2f%s", currentPurchaseSum, "грн\t ");
        double discount= cardDiscount;
        System.out.printf("Скидка по карте = %.0f%s", discount * 100, "%\t ");


       if (!checkedIsHoliday){
           countHolidayDiscount();
       }
        System.out.printf("Праздничная скидка= %.0f%s", holidayDiscount * 100, "%\t");
        discount += holidayDiscount;
        System.out.printf("Скидка всего = %.0f%s", discount * 100, "%\t ");
        System.out.printf("Сумма скидки= %.2f%s",discount*currentPurchaseSum,"грн\t");
        currentPurchaseSum *= (1 - discount);
        System.out.printf("Сумма со скидкой=%.2f%s", currentPurchaseSum, "грн\n"); //Печатать через printf - чтобы было только 2 цифры после запятой
        refreshData(currentPurchaseSum);

    }


    private void refreshData(double currentPurchaseSum) {
        totalPurchasesSum += currentPurchaseSum;//ставлю до проверки на maxDiscount для продолжения учета суммы покупок (на случай, если позже maxDiscount увеличат)
        if (cardDiscount == MAX_DISCOUNT_PERCENT) return;

        cardDiscount = (totalPurchasesSum / 5000) / 100;
        cardDiscount = (cardDiscount >= MAX_DISCOUNT_PERCENT ? MAX_DISCOUNT_PERCENT : cardDiscount);

    }


    public int getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getCardDiscount() {
        return cardDiscount;
    }

    public static double getMaxDiscountPercent() {
        return MAX_DISCOUNT_PERCENT;
    }

    public double getTotalPurchasesSum() {
        return totalPurchasesSum;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        if (this.birthDay == null) {
            this.birthDay = birthDay;
        } else {
            System.out.println("День рождения был указан ранее: " + birthDay);
        }

    }

    public double getHolidayDiscount(){
        return holidayDiscount;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientID == client.clientID &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(birthDay, client.birthDay) &&
                Objects.equals(firstPurchaseDate, client.firstPurchaseDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientID, firstName, lastName, birthDay, firstPurchaseDate);
    }



    @Override
    public String toString() {

       /* String cardDiscStr=String.valueOf(getCardDiscount()*100);
        String holidayDiscStr=String.valueOf(getHolidayDiscount()*100);*/
        String cardDiscStr=String.valueOf(cardDiscount*100);
        String holidayDiscStr=String.valueOf(holidayDiscount*100);

       return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardDiscount=" + cardDiscStr.substring(0,cardDiscStr.indexOf(".")) +
                "%, birthDay=" + birthDay +
                ", firstPurchaseDate=" + firstPurchaseDate +
                ", totalPurchasesSum=" + totalPurchasesSum +
                ", holidayDiscount=" + holidayDiscStr.substring(0,holidayDiscStr.indexOf('.')) +
                "%}";
    }
}
