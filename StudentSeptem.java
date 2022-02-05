public class StudentSeptem extends Examinee
{
  private String Mis;
  
  public StudentSeptem()
  {
    setCode("");
    setName("");
    setGroup("");
    setSort("");
    setMis(0);
  }
  
  public StudentSeptem(String c, String n, String gp, String s, String g) 
 {
  setCode(c);
  setName(n);
  setGroup(gp); 
  setSort(s);
  setMis(g);
 }



 public int getMis() 
 {
  return mis;
 }

 public String toString() 
{   
return getGroup() + " Member " + getCode() + "," + getName() + " 's superpower is " + getSort() +" sheild  level " + getGrade();
 }
}
    
  