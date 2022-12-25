package test;

import Expense.Expense;
import Tickets.Ticket;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ticketAddExpenseITest {
    Ticket ticket;

    public ticketAddExpenseITest() {}

    @Before
    public void initialize()
    {
        System.out.println("Initializing integration test");
        this.ticket = new Ticket("Stijn","Joppe");
        this.ticket.addExpense(new Expense("drink",3,"Joppe"));
        this.ticket.addExpense(new Expense("food",5,"Stijn"));
    }

    @Test
    public void t_getExpense()
    {
        assertEquals("Testing length expenses - should result in 2",
                2, this.ticket.getExpenses().size());
    }

    @Test
    public void t_getExpense1()
    {
        assertEquals("Testing expenses - should result in drink", "drink"
                ,this.ticket.getExpenses().get(0).getName());
        assertEquals("Testing expenses - should result in price",3
                ,this.ticket.getExpenses().get(0).getCost(),0.001);
        assertEquals("Testing expenses - should result in 2 expenses", "Joppe"
                ,this.ticket.getExpenses().get(0).getConsumer());
    }

    @Test
    public void t_getExpense2()
    {
        assertEquals("Testing expenses - should result in drink", "food"
                ,this.ticket.getExpenses().get(1).getName());
        assertEquals("Testing expenses - should result in price",5
                ,this.ticket.getExpenses().get(1).getCost(),0.001);
        assertEquals("Testing expenses - should result in 2 expenses", "Stijn"
                ,this.ticket.getExpenses().get(1).getConsumer());
    }
}
