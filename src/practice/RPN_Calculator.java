package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Stack;

public class RPN_Calculator {
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String equation = br.readLine();
		Stack<String> tks = new Stack<String>();
		tks.addAll(Arrays.asList(equation.trim().split("[ \t]+"))); //remove spaces and split into list.
 
        try  {
          double r = evaluaterpn(tks);  
          DecimalFormat numberFormat = new DecimalFormat("#.0000");
          System.out.println(numberFormat.format(r));
        }
        catch (Exception e)  {
        	System.out.println("error");
        }
        }
 
	
	  private static double evaluaterpn(Stack<String> tks) throws Exception  {
	        String tk = tks.pop();
	        double x,y;
	        try  {
	        	x = Double.parseDouble(tk);
	        }
	        catch (Exception e)  {
	          y = evaluaterpn(tks); 
	          x = evaluaterpn(tks);
	          if      (tk.equals("+"))  x += y;
	          else if (tk.equals("-"))  x -= y;
	          else if (tk.equals("*"))  x *= y;
	          else if (tk.equals("/"))  x /= y;
	          else throw new Exception();
	        }
	        return x;
	      }

}
