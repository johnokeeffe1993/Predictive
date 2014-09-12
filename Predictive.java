import java.util.Scanner;
public class Predictive
{
    public static void main (String args[])
    {
        FileIO reader = new FileIO();
        String[] contents = reader.load("dictionary.txt");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter numbers");
        String input = scan.nextLine();
        String [] chars = new String[input.length()];
        
        for(int i=0;i<chars.length;i++)
        {
            switch(input.charAt(i))
            {
                case '2': chars[i]="abc"; break;
                case '3': chars[i]="def"; break;
                case '4': chars[i]="ghi"; break;
                case '5': chars[i]="jkl"; break;
                case '6': chars[i]="mno"; break;
                case '7': chars[i]="pqrs"; break;
                case '8': chars[i]="tuv"; break;
                case '9': chars[i]="wxyz"; break;
            }
        }
        int [] position = new int[input.length()];
        boolean end = false;
        while(end == false)
        {
            String word = "";
            end = true;
            for(int i=0;i<input.length();i++)
            {
                if(position[i]!=chars[i].length()-1)
                {
                    end = false;
                    break;
                }
            }
            if(end==true)
            {
                break;
            }
            int i=input.length()-1;
            
            for(int j=0;j<input.length();j++)
            {
                
                word = word + chars[j].charAt(position[j]);
            }
            //System.out.println(word);
            
            for(int j=0;j<contents.length;j++)
            {
                //System.out.println(contents[j]+" "+word);
                if(word.equals(contents[j].substring(0,contents[j].length()-1)))
                {
                    System.out.println(contents[j]);
                }
                
            }
            while(true)
            {
                if(position[i]!=chars[i].length()-1)
                {
                    position[i]++;
                    break;
                }
                else
                {
                    position[i]=0;
                    i--;
                }                
            }
        }
    }
}