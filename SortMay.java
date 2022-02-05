import java.util.*;

public class SortMay implements Comparable<SortMay>
{
 private String code;
 private int grade;
 
 
 public SortMay() 
 {
  setCode("");
  setGrade(0);
 }

 public SortMay(String c, int g) 
 {
  setCode(c);
  setGrade(g);
 }
 
 public void setCode(String c)
 {
  code = c;
 }
 
 public String getCode()
 {
  return code;
 }
 
 public void setGrade(int g) 
 {
  if(g < 0) 
  {
    System.out.println(" Grade error!");
    System.exit(-1);
  }
  else
    grade = g;
 }

 public int getGrade() 
 {
  return grade;
 }
 
 public int compareTo(SortMay other)
 {
  int iValue = this.grade - other.grade;
  if (iValue > 0) iValue = 1;
  if (iValue < 0) iValue = -1;
  return iValue;
 }
 
}
