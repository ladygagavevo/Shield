public class StudentMay extends Examinee
{
 private int grade;   
 
 public StudentMay() 
 {
  setCode("");
  setName("");
  setGroup("");
  setSort("");
  setGrade(0);
 }

 public StudentMay(String c, String n, String gp, String s, int g) 
 {
  setCode(c);
  setName(n);
  setGroup(gp); 
  setSort(s);
  setGrade(g);
 }

 public void setGrade(int g) 
 {
  if(g < 0) 
  {
    System.out.println(getName() + " Grade error!");
    System.exit(-1);
  }
  else
    grade = g;
 }

 public int getGrade() 
 {
  return grade;
 }

 public String toString() 
{   
return getGroup() + " Member " + getCode() + "," + getName() + " 's superpower is " + getSort() +" sheild  level " + getGrade();
 }
}
    