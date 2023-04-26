import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private Rectangle player;
    private Grid grid;


    //Constructor player
    public Player(Grid grid) {
        this.grid = grid;
        player= new Rectangle(grid.getCellSize()+Grid.PADDING,grid.getCellSize()+Grid.PADDING, grid.getCellSize(), grid.getCellSize());
        fill();
    }

    //GETTER E SETTER
    public Rectangle getPlayer() {
        return player;
    }

    public void setPlayer(Rectangle player) {
        this.player = player;
    }

    public Grid getGrid() {
        return grid;
    }
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    //Methods
    public void fill(){
        player.fill();
        player.setColor(Color.RED);
    }

    public void moveRight(){
        if(player.getX()<grid.getWeight()){
            player.translate(grid.getCellSize(),0);

        }
    }

    public void moveLeft(){
        if(player.getX()> Grid.PADDING){
            player.translate(-grid.getCellSize(),0);
        }
    }

    public void moveUp(){
        if(player.getY()>Grid.PADDING){
            player.translate(0,-grid.getCellSize());
        }
    }

    public void moveDown(){
        if(player.getY()<grid.getHeight()){
            player.translate(0,grid.getCellSize());
        }
    }

    public void paintCel() {

        if (grid.getPainted()[player.getX() / grid.getCellSize()][player.getY() / grid.getCellSize()] == false) {
            grid.getMini()[player.getX() / grid.getCellSize()][player.getY() / grid.getCellSize()].fill();
            grid.setPainted(player.getX() / grid.getCellSize(), player.getY() / grid.getCellSize(), true);

        } else {
            grid.getMini()[player.getX() / grid.getCellSize()][player.getY() / grid.getCellSize()].draw();
            grid.setPainted(player.getX()/ grid.getCellSize(),player.getY()/grid.getCellSize(), false);
        }
    }


}
