public class StudentAugust extends Examinee
{
 private double math;
 private double chinese;
 private double english;
 private double total;

 public StudentAugust() 
 {
  setCode("");
  setName("");
  setGroup("");
  setSort("");  
  setMath(0.0);
 }

 public StudentAugust(String c, String n, String gp, String s, double m) 
 {
  setCode(c);
  setName(n);
  setGroup(gp);
  setSort(s);  
  setMath(m);
 }

 public void setMath(double m) 
 {
    math = m;
    sumTotal();
 }
 public void sumTotal() 
 { 
  total = math;  
 }
 
 public double getMath() 
 {
  return math;
 }
 
 public double getTotal()
 {
  return math;
 }

 public String toString() 
 {
  return getGroup() +" no. " + getCode() + "," + getName() + " 's wanted level is " + (int)getTotal() +" Superpower is " + getSort();
 }
}
    