import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Map {
	public int arr[][];
	public int theWidth;
	public int theHeight;
	public Map(int row,int col){
	arr=new int[row][col];
	for(int i=0;i<arr.length;i++){
	for(int j=0;j<arr[0].length;j++){
	arr[i][j]=1;
	         }
	}
	theWidth=540/col;
	theHeight=150/row;
	}	
	public void letsdraw(Graphics2D g){
		for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[0].length;j++){
			if(arr[i][j]>0){
				g.setColor(Color.blue);
				g.fillRect( j*theWidth+60,i*theHeight+40,theWidth,theHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.red);
				g.drawRect(j*theWidth+60,i*theHeight+40,theWidth,theHeight);
				}
		         }
		}
		}
	public void setValue(int value,int row,int col){
		arr[row][col]=value;
		}
		}
