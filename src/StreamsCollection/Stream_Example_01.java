package StreamsCollection;

import java.util.Arrays;
import java.util.List;

class Transaction{
    private int amount;
    private String category;

    public Transaction(int amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
public class Stream_Example_01 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1000, "Grocery"),
                new Transaction(500, "Entertainment"),
                new Transaction(1500, "Grocery"),
                new Transaction(2000, "Utility"),
                new Transaction(100, "Entertainment"),
                new Transaction(5000, "Utility")

        );
        // testing - filter - grocery -> get amount -> sum
        // Use case 1: Calculate the total amount spent on grocery
        int amount =transactions.stream()
                .filter(t -> t.getCategory().equals("Grocery"))
                .mapToInt(Transaction :: getAmount)
                .sum();

        System.out.println("Total amount spent on grocery: " + amount);

        //Use case 2: Find average expense among all categories
        double average = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average().orElse(0.0);

        System.out.println("Average amount: " + average);
    }
}
