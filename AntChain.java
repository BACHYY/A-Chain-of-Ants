public class AntChain 
{
    private Ant start;
    private Ant end;
    private  int numAnts;
    public void rollCallFromStart()
    {
        Ant temp= start;
        if (start==null)
        {
            return;
        }
        while(temp!=null)
        {
            System.out.println(temp.name);
            temp=temp.behind;
        }
    }
    public void rollCallFromEnd()
    {
        Ant temp= end;
        if (end==null)
        {
            return;
        }
        while(temp!=null)
        {
            System.out.println(temp.name);
            temp=temp.infront;
        }
    }
    public  int getNumberOfAnts()
    {
        return numAnts;
    }
    public void addToEnd(String antName)
    {
        Ant a = new Ant(antName);
        if (start==null)
        {
            start=a;
            end=a;
        }
        else if (start==end)
        {
            start.behind=a;
            a.infront=start;
            end=a;

        }
        else  
        {
            Ant temp;
            temp=start;
            while(temp.behind!=null)
            {
                temp=temp.behind;
            }
            temp.behind=a;
            a.infront=temp;
            end=a;
        } 
        numAnts++;
    }
    public void addToStart(String antName)
    {
        Ant a= new Ant(antName);
        if(start==null)
        {
            start=a;
            end=a;

        }
        else
        {
            start.infront=a;
            a.behind=start;
            start=a;

        }
        numAnts++;
    }
    public void addAt(String antName,int index)
    {
        Ant a= new Ant(antName);
        if (start== null)
        {
            if(index==0)
            {
                start=a;
                end=a;
            }
            else
            {
            System.out.println("Cant add an Ant");
            return;
            }
        }
        else if (start==end)
        {
            if(index==0)
            {
                start.infront=a;
                a.behind=start;
                start=a;
            }
            else if(index==1)
            {
                start.behind=a;
                a.infront=start;
                end=a;
            }
           else
           {
                System.out.println("Cant add an Ant");
                return;
            }
        }
        else
        {
            if (index==0)
            {
                start.infront=a;
                a.behind=start;
                start=a;  
            }
            else{
                Ant temp= start;
                for(int i=0; i<index-1;i++)
                {
                    if(temp.behind==null)
                    {
                    System.out.println("Cant add an Ant");
                    return;

                    }
                    else{
                    temp=temp.behind;
                    }

                }
                if(temp.behind!=null)
                {
                temp.behind.infront=a;
                a.behind=temp.behind;
                temp.behind=a;
                a.infront=temp;
                }
                else{
                temp.behind=a;
                a.infront=temp;
                end=a;
                }

            }

        }
        numAnts++;
    }
    
    
    public int positionOf(String antname){
        //check if there is such an ant with this name in the list
        //if it exists then return the index and if it doesnt then 
        //return -1
        Ant temp = start;
        int index =0;
        if(start == null){ //no chain
            index = -1;
            return index;
        }
        else if(start == end){ // if one ant only
            if(start.name== antname){
                return index;
            }
        }
        else{
            //traverse and find out
            while(temp !=null){
                if(temp.name == antname){
                    return index;
                }
                index = index+1;
                temp = temp.behind;
            }
        }
        //if not found
        index = -1;
        return index;
    }

    public void kickout(String antname){
        //this function takes in an argument ant name, it traverses 
        //finds out the ant and removes it from the antchain
        //dont forget to decrease the number of ants by 1
        
        Ant temp = start;
        if(start == null){ //nothing to remove
            return;
        }
        else if(start == end){//only one ant in the chain
            if(start.name == antname){
                //then we need to remove
                start = null;
                end = null;
                numAnts = numAnts -1;
                return;
            }
        }
        else{
            //traverse
            while(temp != null){
                if(temp.name == antname){
                    //found
                    //now we need to kick it out. 
                    //new connections need to be made
                    
                    //special case for head
                    if(temp == start){//but not the end aswell
                        //then we make the second walay ko start
                        //temp.behind.infront = null;
                        start = temp.behind;
                        temp.behind.infront = null;
                        numAnts--;
                        return;
                        
                    }
                    
                    //special case for last ant
                    if(temp.behind == null){
                        temp.infront.behind = null;
                        temp.infront = null;
                        numAnts--;
                        return;
                    }
                    temp.infront.behind = temp.behind;
                    temp.behind.infront = temp.infront;
                    numAnts--;
                }
                temp = temp.behind;
            }
        }
        return;
    }

    public Boolean isSame(AntChain chain){
        //if this chain and the current chain is same then return true
        Ant temp = start;
        Ant temp2 = chain.start;
        if(numAnts == chain.numAnts){
            //then we must check if all names of both are same or na
            while(temp != null){
                if(temp.name != temp2.name){
                    return false;
                }
                temp = temp.behind;
                temp2 = temp2.behind;
            }
        }
        else{
            return false;
        }
        return true;
    }
    
    public void connectToChain(AntChain chain){
        Ant temp1 = chain.start;
        while(temp1 != null){
            addToEnd(temp1.name);
            temp1 = temp1.behind;
        }
        return;
    }

    
}

    