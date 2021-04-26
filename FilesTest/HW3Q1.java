
public class Main {

   public static void main(String[] args) {

      byte first = 127; //128
      System.out.println("First: " + first);
  
      
      
      for (int i = 7; i>=0; i--)
            System.out.print((first >> i) & 0x01);
//0000 1000

      System.out.println("");
      
      first = (byte)(first + 1);
      System.out.println("First + 1: " + (first));
      for (int i = 7; i>=0; i--)
            System.out.print((first >> i) & 0x01);
     
      System.out.println("\n**********");
     
     System.out.println((byte)0xFF);

      byte a = (byte)0xA7; //1010 0111
      byte b = (byte)0x64; //0110 0100
      byte c = (byte)(a&b); //0010 0100
      byte d = (byte)(a|b); //11100111

       int x = (a|b);

      // int y = 0xD7;

      
      System.out.println(a + " " + b + " " + c + " " + d + " ");
      System.out.printf("%x\n", x);
      System.out.println(x);

      x = x & 0xFF;

     System.out.println(x);

      //on = (picture[i-1][j-1] >> 16) & 0xff;
      
}


private int [] getPixelArray(int pixel)
{
      int temp[] = new int[4];
      temp[0] = (pixel >> 24) & 0xff;
      temp[1] = (pixel >> 16) & 0xff;
      temp[2] = (pixel >> 8) & 0xff;
      temp[3] = (pixel ) & 0xff;
      return temp;

}
/*
* This method takes an array of size 4 and combines the first 8 bits of each to create one integer.
*/
private int getPixels(int rgb[])
{
          int alpha = 0;
          int rgba = (rgb[0] << 24) | (rgb[1] <<16) | (rgb[2] << 8) | rgb[3];
          return rgba;

}
    
}

