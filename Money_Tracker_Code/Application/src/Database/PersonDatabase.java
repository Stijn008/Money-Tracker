package Database;

public class PersonDatabase<T> extends Database{
    private static PersonDatabase uniqueInstance;

    public PersonDatabase() {
        this.uniqueInstance = uniqueInstance;
    }

    public static PersonDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonDatabase();
        }
        return uniqueInstance;
    }
}
