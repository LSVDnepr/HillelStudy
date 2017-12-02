package hometask04;

public class LibraryMainHomeTask0401 {

    public static void main(String[] args) {
        Library l=new Library();//outer class Library
        l.printLibrariansList();//method of outer class
        Library.LibraryJournal lj=l.new LibraryJournal(new Library.GeneralLibraryForm(75342,123457)); //inner non-static class Library Journal
        System.out.println(lj.getForm());//method of non-static inner class+static inner class+method of static inner class
        lj.signJournal(123456);//local class and its method
        System.out.println(lj.isJournalValid()); //anonymous class and its method






    }







}
