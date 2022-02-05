import java.util.*;

public class SortAug implements Comparable<SortAug> 
{
 private String code;
 private double math;
 private double chinese;
 private double english;
 private double total;
 
 public SortAug() 
 {
  setCode("");
  setMath(0.0);
  /*setChinese(0.0);
  setEnglish(0.0);*/
 }

 public SortAug(String c, double m/*, double ch, double e*/) 
 {
  setCode(c);
  setMath(m);
 /*setChinese(ch);
  setEnglish(e);*/
 }
 
 public void setCode(String c)
 {
  code = c;
 }
 
 public String getCode()
 {
  return code;
 }
 
 public void setMath(double m) 
 {
    math = m;
    sumTotal();
 }
 
 /*public void setChinese(double ch) 
 {
    chinese = ch;
    sumTotal();
 }
 
 public void setEnglish(double e) 
 {
    english = e;
    sumTotal();
 }*/

 public void sumTotal() 
 { 
  total = chinese + ((english + math)*2);  
 }
 
 public double getMath() 
 {
  return math;
 }
 
/* public double getChinese() 
 {
  return math;
 }
 
 public double getEnglish() 
 {
  return math;
 }
*/
 public double getTotal()
 {
  return math;
 }
 
 public int compareTo(SortAug other)
 {
  double dValue = this.total - other.total;
  if (dValue > 0.0) 
   {return 1;}
  if(dValue < 0.0)
   {return -1;}
  else
  {
   double g1 = this.english - other.english;
   if (g1 > 0.0)
    {return 1;}
   if(g1 < 0.0)
    {return -1;}
   else
   {
    double g2 = this.math - other.math;
    if (g2 > 0.0)
     {return 1;}
    if(g2 < 0.0)
     {return -1;}
    else
    {
     double g3 = this.chinese - other.chinese;
     if(g3 > 0.0)
      {return 1;}
     else
      {return -1;}   
    }     
   }  
  }
  
  
 }
}
