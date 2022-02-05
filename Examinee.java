public class Examinee
{
 private String name, testcode, group, sort;

      // default constructor
    public Examinee()
    {       
        name = "";
        testcode = "";
        group = "";
        sort = "";
    }

 public Examinee(String testcode, String name, String group, String sort)
 {
  this.name = name;
  this.group = group;
  this.testcode = testcode;
  this.sort = sort;
 }

      // setters

 public void setName(String n)
 {
  name = n;  
 }
 public void setGroup(String g)
 {
  group = g;
 }
 public void setCode(String c)
 {
  testcode = c;
 }
public void setSort(String s)
 {
  sort = s;
 }

      // getters
 public String getName()
 {
  return name;
 }

 public String getGroup()
 {
  return group;
 }

 public String getCode()
 {
  return testcode;
 }
 
 public String getSort()
 {
  return sort;
 }

}