	import java.awt.*;
	import java.awt.image.BufferedImage;
	import java.io.*;
	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	public class Przyciemnienie {
	 BufferedImage image;
	 int width;
	 int height;

	 public Przyciemnienie() {

	 try {
	 //odczyt obrazu z pliku
	 File input = new File("Ratusz_Bia³ystok_rok_2013.jpg");
	 image = ImageIO.read(input);
	 width = image.getWidth();
	 height = image.getHeight();

	 //odczyt pixeli obrazu w dwóch pêtlach po kolumnach i wierszach
	 for(int i=0; i<height; i++){
	 for(int j=0; j<width; j++){

	 //odczyt sk³adowych koloru RGB
	 Color c = new Color(image.getRGB(j, i));
	 int red = (int)(c.getRed());
	 int green = (int)(c.getGreen());
	 int blue = (int)(c.getBlue());
	 double a = 0.05, n=2;
	 int b =60, dc = 200,  red_pnym = (int)(c.getRed()), green_pnym = (int)(c.getGreen()), blue_pnym = (int)(c.getBlue());
	 double red_pot = Math.pow(a*red, n);
	 red_pnym = (int) ((int) red_pot);
	 double green_pot = Math.pow(a*green, n);
	 green_pnym = (int) ((int) green_pot);
	 double blue_pot = Math.pow(a*blue, n);
	 blue_pnym = (int) ((int) blue_pot);

	 if (red_pnym  >=0 && red_pnym  <=255) red = red_pnym;
	 else red = red;

	 if (green_pnym >=0 && green_pnym <=255) green = green_pnym ;
	 else green = green;

	 if (blue_pnym >=0 && blue_pnym <=255) blue = blue_pnym;
	 else blue = blue;
	 

	 Color newColor = new Color(red, green,blue);
	 image.setRGB(j,i,newColor.getRGB());

	 } //koniec dwóch pêtli po kolumnach i wierszach obrazu
	 }
	 //zapis do pliku zmodyfikowanego obrazu
	 File ouptut = new File("przyciemnienie.jpg");
	 ImageIO.write(image, "jpg", ouptut);

	 } catch (Exception e) {}
	 }

	 static public void main(String args[]) throws Exception
	 {
		 Przyciemnienie obj = new Przyciemnienie();
	 }
	}


