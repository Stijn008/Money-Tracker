package Database;

public class PersonDatabase<T> extends Database{
    private PersonDatabase<T> uniqueInstance;

    public PersonDatabase(PersonDatabase<T> uniqueInstance) {
        this.uniqueInstance = uniqueInstance;
    }
    public PersonDatabase<T> getInstance(){
        return null;
    }
}
