import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;





public class pegGame extends Application
{
//all necessary data
   GridPane grid = new GridPane();
   int ballCount = 0;
   int moveCount = 0;
   Label labelH = new Label ();
   int progress = 0;
   int x= 0;
   int y = 0;
   String direction = " ";
   //these are for housing multiple buttons on a single circle
   boolean[][] rr = new boolean[4][4];
   boolean[][] ll = new boolean[4][4];
   boolean[][] bb = new boolean[4][4];
   boolean[][] tt = new boolean[4][4];
   boolean[][] state = new boolean[4][4];
//this 2d array holds the board
   GamePane[][] gameBoard = new GamePane[4][4];      


   public void check(){ //checks for buttons
      ballCount =0;//these are reset each time so it does not show incorrctly
      moveCount = 0;
     
     //resets all buttons before drawing
      for(int i = 0;i<4;i++){
         for(int j = 0; j < 4; j++) {
         
            gameBoard[i][j].setFalse();
         }
      }
    //top down
      for(int i = 0;i<4;i++){
         for(int j = 0; j < 2; j++) {
            if(gameBoard[i][j].getPeg() == true && gameBoard[i][j+1].getPeg() ==true&& gameBoard[i][j+2].getPeg() == false){
               gameBoard[i][j].draw( tt[i][j]=true, bb[i][j], ll[i][j], rr[i][j],state[i][j] =true);//t b l r
               gameBoard[i][j].getxy(i,j);
               moveCount++;
            }
         }
      }
   
   
   //down up
      for(int i = 0;i<4;i++){
         for(int j = 2; j < 4; j++) {
           
            if(gameBoard[i][j].getPeg() == true && gameBoard[i][j-1].getPeg() ==true&& gameBoard[i][j-2].getPeg() == false){
               gameBoard[i][j].draw( tt[i][j], bb[i][j]=true, ll[i][j], rr[i][j],state[i][j] =true);       
               gameBoard[i][j].getxy(i,j);
               moveCount++;
            }
         }
      }
   //right left
      for(int i = 2;i<4;i++){
         for(int j = 0; j < 4; j++) {
           
            if(gameBoard[i][j].getPeg() == true && gameBoard[i-1][j].getPeg() ==true&& gameBoard[i-2][j].getPeg() == false){
               gameBoard[i][j].draw( tt[i][j], bb[i][j], ll[i][j], rr[i][j]=true,state[i][j] =true);   
               gameBoard[i][j].getxy(i,j);
               moveCount++;
            }
         }
      }
   //left right
      for(int i = 0;i<2;i++){
         for(int j = 0; j < 4; j++) {
           
            if(gameBoard[i][j].getPeg() == true && gameBoard[i+1][j].getPeg() ==true&& gameBoard[i+2][j].getPeg() == false){
               gameBoard[i][j].draw( tt[i][j], bb[i][j], ll[i][j]=true, rr[i][j],state[i][j] =true);        
               gameBoard[i][j].getxy(i,j);
               moveCount++;
            }
         }
      }
   //this for loop checks every gamepane to see if it is there or not
      for(int i = 0;i<4;i++){
         for(int j = 0; j < 4; j++) {
            if(gameBoard[i][j].getPeg() == true){
               ballCount++;
            }
         }
      
      }
      labelH.setText("Balls Left: "+ballCount+"     Total Moves: "+moveCount);
   //win or lose scenarios
      if(ballCount ==1){
         labelH.setText("YOU WIN");
      
      }
      if(moveCount == 0 && ballCount>1){
         labelH.setText("YOU LOSE");
      
      }
   
   
   
   }
   
   public void click(int x, int y, String direction){ //this section is all related to the three balls that are changed
      this.x = x;
      this.y = y;
      this.direction = direction;
      for(int i = 0;i<4;i++){
         for(int j = 0; j < 4; j++) {
            gameBoard[i][j].setFalse();
         }
      }
   
      if (direction.equals("top")){//top setting
      
         gameBoard[x][y].draw( tt[x][y]=false, bb[x][y]=false, ll[x][y]=false,rr[x][y]=false,state[x][y] =false);//gets x and y and removes it
         gameBoard[x][y+1].draw( tt[x][y+1]=false, bb[x][y+1]=false, ll[x][y+1]=false,rr[x][y+1]=false,state[x][y+1] =false);//removes one under it
         gameBoard[x][y+2].draw(tt[x][y+2]=false, bb[x][y+2]=false, ll[x][y+2]=false,rr[x][y+2]=false,state[x][y+2] =true);//adds where the empty space is
      
         for(int i = 0;i<4;i++){
            for(int j = 0; j < 4; j++) {
               gameBoard[i][j].setFalse();
            }
         } 
         check();//and then checks for all of the buttons to spawn
      
      }
      if (direction.equals("bottom")){
         gameBoard[x][y].draw( tt[x][y]=false, bb[x][y]=false, ll[x][y]=false,rr[x][y]=false,state[x][y] =false);
         gameBoard[x][y-1].draw( tt[x][y-1]=false, bb[x][y-1]=false, ll[x][y-1]=false,rr[x][y-1]=false,state[x][y-1] =false);
         gameBoard[x][y-2].draw(tt[x][y-2]=false, bb[x][y-2]=false, ll[x][y-2]=false,rr[x][y-2]=false,state[x][y-2] =true);
      
         for(int i = 0;i<4;i++){
            for(int j = 0; j < 4; j++) {
               gameBoard[i][j].setFalse();
            }
         } 
         check();
      
      }
      if (direction.equals("left")){
         gameBoard[x][y].draw( tt[x][y]=false, bb[x][y]=false, ll[x][y]=false,rr[x][y]=false,state[x][y] =false);
         gameBoard[x+1][y].draw( tt[x+1][y]=false, bb[x+1][y]=false, ll[x+1][y]=false,rr[x+1][y]=false,state[x+1][y] =false);
         gameBoard[x+2][y].draw(tt[x+2][y]=false, bb[x+2][y]=false, ll[x+2][y]=false,rr[x+2][y]=false,state[x+2][y] =true);
         for(int i = 0;i<4;i++){
            for(int j = 0; j < 4; j++) {
               gameBoard[i][j].setFalse();
            }
         }
         check();
      
      }
      if (direction.equals("right")){
         gameBoard[x][y].draw( tt[x][y]=false, bb[x][y]=false, ll[x][y]=false,rr[x][y]=false,state[x][y] =false);
         gameBoard[x-1][y].draw( tt[x-1][y]=false, bb[x-1][y]=false, ll[x-1][y]=false,rr[x-1][y]=false,state[x-1][y] =false);
         gameBoard[x-2][y].draw(tt[x-2][y]=false, bb[x-2][y]=false, ll[x-2][y]=false,rr[x-2][y]=false,state[x-2][y] =true);
         
         for(int i = 0;i<4;i++){
            for(int j = 0; j < 4; j++) {
               gameBoard[i][j].setFalse();
            }
         }
         check();
      
      
      }
   
   
   
   }
   public void start(Stage stage)
   {
      BorderPane root = new BorderPane();//new bpane
      grid.setPrefSize(600,600);//x y of window
     
      grid.setAlignment(Pos.CENTER);
      root.setCenter(grid);
   
      for(int i = 0;i<4;i++){//sets everythign to false
         for(int j = 0; j < 4; j++) {
            gameBoard[i][j] = new GamePane();
            grid.add(gameBoard[i][j],i,j);
            tt[i][j] =false;
            ll[i][j] =false;
            rr[i][j] =false;
            bb[i][j] =false;
         
         } 
      }
   
      for(int i = 0;i<4;i++){//makes all the pegs
         for(int j = 0; j < 4; j++) {
            gameBoard[i][j].draw(false,false,false,false,true);
         }
      }
      gameBoard[0][2].draw(false,false,false,false,false); //setting first off
      
      check();
   
   
         
   
   
      HBox high = new HBox();
      high.setPrefSize(100,20);
      high.setAlignment(Pos.TOP_CENTER);
      high.getChildren().add(labelH);//adds labelH
      high.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY,Insets.EMPTY)));//sets backround of title
   
      root.setTop(high); 
   
      Scene scene = new Scene(root, 600, 600); 
      stage.setScene(scene);
      stage.setTitle("PEG game");
      stage.show();
      
   }


   public class GamePane extends GridPane
   {
   
      Button left = new Button();
      Button right = new Button();
      Button top = new Button();
      Button bottom = new Button();  
      int x =0;
      int y =0;
      boolean t= true;
      boolean b= true;
      boolean r= true;
      boolean l= true;
      boolean peg = true;
      public GamePane(){
      //setting up all the buttons
      
         top.setPrefSize(80,20);
         bottom.setPrefSize(80,20);
         left.setPrefSize(20,80);
         right.setPrefSize(20,80);
      
         getChildren().add(left);
         setConstraints(left,0,1); 
         getChildren().add(right);
         setConstraints(right,2,1);
         getChildren().add(bottom);
         setConstraints(bottom,1,2);
         getChildren().add(top);
         setConstraints(top,1,0);
         
        
                
      }
      public void draw(boolean t,boolean b,boolean l, boolean r, boolean peg){//this takes in all the necessary things
         left.setOnAction(new ButtonListener()); //individual listeners
         right.setOnAction(new ButtonListener());
         bottom.setOnAction(new ButtonListener());
         top.setOnAction(new ButtonListener());
      
         this.t = t;
         this.b = b;
         this.l =l;
         this.r =r;
         this.peg = peg;
         //this switches the visibility
         left.setVisible(l);
         right.setVisible(r);
         top.setVisible(t);
         bottom.setVisible(b);
         Canvas canvas = new Canvas(80,80);
         GraphicsContext gc = canvas.getGraphicsContext2D();
               
         if(peg == false){
         //sets it to white so it looks more like a pegboard
            gc.setFill( Color.WHITE );
            gc.fillOval(0,0,80,80);
            add(canvas, 1, 1);
         
         
         
         
         }
         if(peg == true){
            gc.fillOval(0,0,80,80);
            add(canvas, 1, 1);
         
         }
       
      
      }
      public void setFalse(){//sets all to false
         left.setVisible(false);
         right.setVisible(false);
         top.setVisible(false);
         bottom.setVisible(false);
      }
      public class ButtonListener implements EventHandler<ActionEvent>
      {
         public void handle(ActionEvent e)//button management
         {
            if(e.getSource() == top) {
            
               click(x,y,"top");//sends x and y and the button pressed
            }
            if(e.getSource() == bottom) {
            
               click(x,y,"bottom");
            
            
            }
         
            if(e.getSource() == left) {
            
               click(x,y,"left");
            
            }
            if(e.getSource() == right) {
            
               click(x,y,"right");
            
            }
         
         }
      
      
      }
   
   
   
      public boolean getPeg(){//a little reduntant but i did not want to change what I already did
         return peg;
      
      }
   
   
      public void getxy(int x,int y){//get x and y
         this.x = x;
         this.y = y;
      
      }
   
   }
     
  
    
   public static void main(String[] args)
   {
      launch(args);
      
   }

}



















































































