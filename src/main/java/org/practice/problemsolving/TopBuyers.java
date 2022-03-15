package org.practice.problemsolving;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopBuyers {

    List<Transaction> transactions = new ArrayList<>();
//    Map<Integer, Map<Integer>> transactions = new HashMap<>();

//    public void getTopBuyers() {
//        transactions.stream().collect()
//    }

    public void insertTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void saveToFile() {
        try {
            long startTime = System.nanoTime();
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(transactions);
            o.close();
            f.close();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Successfully wrote to the file " + duration/1000000);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Transaction> readFromFile() {
        try {
            long startTime = System.nanoTime();
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            List<Transaction> trans = (List<Transaction>) oi.readObject();
            System.out.println(trans.get(0).getTimestamp());
            oi.close();
            fi.close();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Successfully read from the file " + duration/1000000);
            return trans;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public static Timestamp getRandomTimestamp() {
        long offset = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-03-01 00:00:00").getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long)(Math.random() * diff));
    }

    public static void main(String[] args) {
        TopBuyers obj = new TopBuyers();
        for(int i=0; i<300000; i++) {
            obj.insertTransaction(new Transaction((int) Math.random() * (10000) ,(int) ((Math.random() * (20000 - 10000)) + 10000), TopBuyers.getRandomTimestamp()));
        }
        obj.saveToFile();
        obj.readFromFile();
        obj.getTopBuyers();
    }

    private void getTopBuyers() {
        List<Transaction> trans = readFromFile();
        int sellerId = (int) Math.random() * (10000);

        long startTime = System.nanoTime();
        trans.stream()
                .filter(tran -> tran.getSellerId() == sellerId)
                .collect(
                        Collectors.groupingBy(Transaction::getBuyerId, Collectors.counting())
                ).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Fetched top 10 buyers in " + duration/1000000 + " ms");

    }
}


class Transaction implements Serializable {
    int sellerId;
    int buyerId;
    Date timestamp;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction(int sellerId, int buyerId, Date timestamp) {
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.timestamp = timestamp;
    }
}