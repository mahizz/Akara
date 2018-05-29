package pl.shopkeeper.shopkeeper.users;

public class Users {

    private final long id;
    private final String content;

    public Users(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
