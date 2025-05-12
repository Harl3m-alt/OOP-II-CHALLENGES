import java.util.ArrayList;
import java.util.List;

interface LibraryAction {
    void execute();
}

class BorrowBook implements LibraryAction {
    public void execute() {
        System.out.println("Book has been borrowed.");
    }
}

class ReturnBook implements LibraryAction {
    public void execute() {
        System.out.println("Book has been returned.");
    }
}

class ReadOnly implements LibraryAction {
    public void execute() {
        System.out.println("Reading preview pages.");
    }
}

abstract class Member {
    protected int memberId;
    protected String fullName;

    public Member(int memberId, String fullName) {
        this.memberId = memberId;
        this.fullName = fullName;
    }

    public abstract void performAction(LibraryAction action);
}

class Librarian extends Member {
    private String staffCode;

    public Librarian(int memberId, String fullName, String staffCode) {
        super(memberId, fullName);
        this.staffCode = staffCode;
    }

    public void performAction(LibraryAction action) {
        System.out.print("Librarian " + fullName + ": ");
        action.execute();
    }
}

class Guest extends Member {
    public Guest(int memberId, String fullName) {
        super(memberId, fullName);
    }

    public void performAction(LibraryAction action) {
        System.out.print("Guest " + fullName + ": ");
        action.execute();
    }
}

class Library {
    private List<Member> members;

    public Library() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void listMembers() {
        System.out.println("\nLibrary Members:");
        for (Member m : members) {
            System.out.println("- " + m.fullName);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Librarian mark = new Librarian(101, "Mark Angel", "LIB2025");
        Guest brian = new Guest(202, "Brian Bett");

        Library centralLibrary = new Library();
        centralLibrary.addMember(mark);
        centralLibrary.addMember(brian);

        mark.performAction(new BorrowBook());
        brian.performAction(new ReadOnly());

        centralLibrary.listMembers();
    }
}
