package hometask04;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Predicate;

public class Library {
    private HashMap<Integer, String> librarians = new HashMap<>();

    Library(){
        addLibrarian();
    }

    private void addLibrarian(){
        librarians.put(123456,"John Smith");
        librarians.put(654214,"Jane Smith");
    }


    public static class GeneralLibraryForm {
        private int readerId;
        private int bookId;

        public GeneralLibraryForm(int readerId, int bookId) {
            this.readerId = readerId;
            this.bookId = bookId;
        }

        @Override
        public String toString() {
            return "GeneralLibraryForm{" + "readerId=" + readerId + ", bookId=" + bookId + '}';
        }
    }

    public class LibraryJournal {
        private String signature = "";
        private GeneralLibraryForm form;


        public LibraryJournal(GeneralLibraryForm form) {
            this.form = form;
        }

        public LibraryJournal(int readerId, int bookId) {
            this.form=new GeneralLibraryForm(readerId,bookId);
        }

        public GeneralLibraryForm getForm() {
            return form;
        }

        public void signJournal(int librarianId) {
            if (!librarians.containsKey(librarianId)) {
                throw new IllegalArgumentException("No such worker found");
            }


            class SignatureAlgorythm {

                String createSignature() {
                    Date d = new Date();
                    return String.valueOf(librarianId) + " #" + d;
                }

            }

            signature = new SignatureAlgorythm().createSignature();

        }


        public boolean isJournalValid() {
            Predicate<LibraryJournal> p = libraryJournal -> (!signature.isEmpty());
            return p.test(this);
        }


    }


    public void printLibrariansList(){
        librarians.entrySet().forEach(System.out::println);
    }



}
