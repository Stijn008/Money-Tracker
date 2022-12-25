package test;

import Expense.Expense;
import Tickets.NoSplit;
import Tickets.Split;
import Tickets.SplitBehaviour;
import Tickets.Ticket;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import java.lang.reflect.Field;
import java.util.*;

public class Ticket_UTest {
    public Ticket_UTest() {}

    @Before
    public void initialize() {}

    @Test
    public void t_getName() throws IllegalAccessException, NoSuchFieldException{
        // Access the private field inside the Hotel class
        Field field = Ticket.class.getDeclaredField("name");
        field.setAccessible(true);

        // Test getting value set via constructor
        Ticket ticketUnderTest = new Ticket("Stijn", "Joppe");
        assertEquals("Testing getting value - set via constructor - expected Stijn", "Stijn", ticketUnderTest.getName());

        // Test getting value set via Field
        field.set(ticketUnderTest, "Stijn");
        assertEquals("Testing getting value - set via Field - expected Stijn", "Stijn", ticketUnderTest.getName());
    }

    @Test
    public void t_addExpense() throws IllegalAccessException, NoSuchFieldException{
        Field field = Ticket.class.getDeclaredField("expenses");
        field.setAccessible(true);

        Ticket ticketUnderTest = new Ticket("Stijn", "Joppe");
        ArrayList<Expense> mockList = new ArrayList<>();
        field.set(ticketUnderTest, mockList);

        // Test function for first time
        ticketUnderTest.addExpense(new Expense("Hamburger",5,"Joppe"));
        assertEquals("Testing size of expenses", 1, mockList.size());
        assertThat(mockList.get(0), instanceOf(Expense.class));

        // Test function for second time
        ticketUnderTest.addExpense(new Expense("Hotdog",4,"Stijn"));
        assertEquals("Testing size of exepense for 2nd time", 2, mockList.size());
        assertThat(mockList.get(0), instanceOf(Expense.class));
        assertThat(mockList.get(1), instanceOf(Expense.class));
        assertNotSame(mockList.get(0), mockList.get(1));
    }

    @Test
    public void t_setSplitBehaviour() throws NoSuchFieldException, IllegalAccessException
    {
        // Access the private field inside the Hotel class
        Field field1 = Ticket.class.getDeclaredField("splitBehaviour");
        Field field2 = Ticket.class.getDeclaredField("expenses");
        field1.setAccessible(true);
        field2.setAccessible(true);

        Ticket ticketUnderTest = new Ticket("ticket", "Joppe");
        SplitBehaviour mockSplit = new Split();
        ArrayList<Expense> mockList = new ArrayList<>();

        // Populate map with rooms
        Expense expense1 = new Expense("Hamburger",5,"Joppe");
        Expense expense2 = new Expense("frieten",4,"Stijn");

        mockList.add(expense1);
        mockList.add(expense2);
        field1.set(ticketUnderTest, mockSplit);
        field2.set(ticketUnderTest, mockList);

        // Test split
        assertEquals("Testing split - should return 4.5 ", -4.5F, (float) ticketUnderTest.getBalance().get("Stijn"), 0.001);

        mockSplit = new NoSplit();
        field1.set(ticketUnderTest, mockSplit);

        // Test no split
        assertEquals("Testing split - should return 4.5 ", -4F, (float) ticketUnderTest.getBalance().get("Stijn"), 0.001);
    }

    @Test
    public void t_getExpenses() throws IllegalAccessException, NoSuchFieldException{
        // Access the private field inside the Hotel class
        Field field = Ticket.class.getDeclaredField("expenses");
        field.setAccessible(true);

        // Test getting value set via constructor
        Ticket ticketUnderTest = new Ticket("Stijn", "Joppe");
        ticketUnderTest.addExpense(new Expense("Hamburger",5,"Joppe"));
        ArrayList<Expense> mocklist = new ArrayList<>();
        mocklist.add(new Expense("Hamburger",5,"Joppe"));
        field.set(ticketUnderTest,mocklist);

        assertEquals("Testing getting value - set via constructor - expected Stijn", mocklist, ticketUnderTest.getExpenses());

        // Test getting value set via Field
        assertEquals("Testing getting value - set via Field - expected Stijn", mocklist, ticketUnderTest.getExpenses());
    }

    @Test
    public void t_getPayer() throws IllegalAccessException, NoSuchFieldException{
        // Access the private field inside the Hotel class
        Field field = Ticket.class.getDeclaredField("payer");
        field.setAccessible(true);

        // Test getting value set via constructor
        Ticket ticketUnderTest = new Ticket("Stijn", "Joppe");
        assertEquals("Testing getting value - set via constructor - expected Joppe", "Joppe", ticketUnderTest.getPayer());

        // Test getting value set via Field
        field.set(ticketUnderTest, "Joppe");
        assertEquals("Testing getting value - set via Field - expected Joppe", "Joppe", ticketUnderTest.getPayer());
    }
}
