package Database;

public class PersonDatabase<T> extends Database {
    private PersonDatabase<T> uniqueInstance =null;
    public PersonDatabase() {}

    public PersonDatabase<T> getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PersonDatabase<T>();
        return uniqueInstance;
    }

}
