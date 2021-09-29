public class Ant 
{
    public String name;
    public Ant infront;
    public Ant behind;

    public Ant(String pName)
    {
        name=pName;
        infront= null;
        behind=null;
    }
    public String getNmae()
    {
        return name;
    }
    public Ant getFront()
    {
        return infront;
    }
    public Ant getBehind()
    {
        return behind;
    }
    public void setName(String n)
    {
        name=n;
    }
    public void setFront(Ant obj)
    {
        infront=obj;
    }
    public void setBehind(Ant obj)
    {
        behind=obj;
    }


    
}
