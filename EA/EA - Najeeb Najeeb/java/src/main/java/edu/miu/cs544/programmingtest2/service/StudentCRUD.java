package edu.miu.cs544.programmingtest2.service;

public class StudentCRUD {

    DBManager dbManager;

    public StudentCRUD(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void create() {
        System.out.println("Saving student ...");
    }

    public void read() {
        System.out.println("Reading student ...");
    }

    public void update() {
        System.out.println("Updating student ...");
    }

    public void delete() {
        System.out.println("Deleting student ...");
    }
}
