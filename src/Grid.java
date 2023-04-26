import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int PADDING = 10;
    private static final int cellSize = 15;
    private int cols;
    private int rows;
    private GridColour color;
    private Rectangle rectangle;
    private int height;
    private int weight;
    private Rectangle[][] mini;
    private Boolean[][] painted;


    //grid constructor
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        mini = new Rectangle[cols][rows];
        painted=new Boolean[cols][rows];
        rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rectangle.draw();
        rectangle.setColor(Color.BLUE);
        designRectangles();
    }

    //GETTERS AND SETTERS
    public int getCols() {
        return cols;
    }
    public void setCols(int cols) {
        this.cols = cols;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getCellSize() {
        return cellSize;
    }
    public int getHeight() {
        return rows*cellSize-PADDING;
    }

    public int getWeight() {
        return cols*cellSize-PADDING;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public GridColour getColor() {
        return color;
    }
    public void setColor(GridColour color) {
        this.color = color;
    }
    public Boolean[][] getPainted() {
        return painted;
    }
    public void setPainted(int x, int y, boolean z) {
        painted[x][y]=z;

    }
    public Rectangle[][] getMini() {
        return mini;
    }
    public void setMini(Rectangle[][] mini) {
        this.mini = mini;
    }


    //Methods
    public int rowToX(int col) {
        return PADDING + (col * cellSize);
    }

    public int rowToY(int row) {
        return PADDING + (row * cellSize);
    }

    //create rectangles with black lines
    public void designRectangles() {
        for (int i = 0; i <= (cols-1); i++) {

            for (int j = 0; j <= (rows-1); j++) {
                mini[i][j]=new Rectangle((cellSize * i + PADDING) , (cellSize * j + PADDING), cellSize, cellSize);
                mini[i][j].draw();
                painted[i][j] =false;
                mini[i][j].setColor(Color.BLACK);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Rectangle[] innerArray : mini) {
            for (Rectangle cell : innerArray) {
                builder.append(cell.toString());
            }
            builder.append("\n");
        }
        return builder.toString();
    }


}
