package interface_adapter.home_screen;

public class HomeState {
    private String username = "";

    public HomeState(HomeState copy) {this.username = copy.username;}

    public HomeState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
