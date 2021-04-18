	import java.awt.*;
	import java.awt.image.BufferedImage;
	import java.io.*;
	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	public class Negatyw {
	 BufferedImage image;
	 int width;
	 int height;

	 public Negatyw() {

	 try {
	 //odczyt obrazu z pliku
	 File input = new File("Ratusz_Bia�ystok_rok_2013.jpg");
	 image = ImageIO.read(input);
	 width = image.getWidth();
	 height = image.getHeight();

	 //odczyt pixeli obrazu w dw�ch p�tlach po kolumnach i wierszach
	 for(int i=0; i<height; i++){
	 for(int j=0; j<width; j++){

	 //odczyt sk�adowych koloru RGB
	 Color c = new Color(image.getRGB(j, i));
	 int red = (int)(c.getRed());
	 int green = (int)(c.getGreen());
	 int blue = (int)(c.getBlue());
	 double a = 1;
	 int b =60, dc = 200, red_pnym = (int)(c.getRed()), green_pnym = (int)(c.getGreen()), blue_pnym = (int)(c.getBlue());
	 
	 red_pnym = (int) 255-red;
	 green_pnym = (int) 255-green;
	 blue_pnym = (int) 255-blue;


	 if (red_pnym  >=0 && red_pnym  <=255) red = red_pnym;
	 else red = red;

	 if (green_pnym >=0 && green_pnym <=255) green = green_pnym ;
	 else green = green;

	 if (blue_pnym >=0 && blue_pnym <=255) blue = blue_pnym;
	 else blue = blue;
	 

	 Color newColor = new Color(red, green,blue);
	 image.setRGB(j,i,newColor.getRGB());

	 } //koniec dw�ch p�tli po kolumnach i wierszach obrazu
	 }
	 //zapis do pliku zmodyfikowanego obrazu
	 File ouptut = new File("negatyw.jpg");
	 ImageIO.write(image, "jpg", ouptut);

	 } catch (Exception e) {}
	 }

	 static public void main(String args[]) throws Exception
	 {
		 Negatyw obj = new Negatyw();
	 }
	}
