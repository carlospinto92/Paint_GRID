import org.academiadecodigo.simplegraphics.pictures.Color;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(45, 40);
        Player player = new Player(grid);

        new Handler(player);

    }
}