interface Toll
{
	public void display();
	public void calToll(Truck T);
}
	class Tollbooth implements Toll {
    int initialreceipts;
    int initialtruckcount;
	Tollbooth() 
	{
        initialtruckcount = 0;
        initialreceipts = 0;
    }
    public void display() 
	{
        System.out.print("Total amount on Receipts: ");
        System.out.println(initialreceipts);
        System.out.print(" Trucks: ");
        System.out.println(initialtruckcount);
    }
	public void calToll(Truck T) 
	{
        int axles = T.getAxles();
        int Weight = T.getWeight();
        int tollDue = 5*axles + 10*(Weight/2);
        System.out.print("No. of axles: ");
        System.out.println(axles);
        System.out.print("weight of the truck: ");
        System.out.println(Weight);
        System.out.print(" Amount due: ");
        System.out.println(tollDue);
        initialtruckcount = initialtruckcount + 1;
        initialreceipts = initialreceipts + tollDue;
    }
    }
interface Truck
{
	public int getAxles();
	public int getWeight();
}
class Trucks extends Tollbooth implements Truck {
    int axles;
    int Weight;
    Trucks(int axles, int Weight) 
	{
        this.axles = axles;
        this.Weight = Weight;
    }
    public int getAxles() 
	{
		return axles;
	}
    public int getWeight() 
	{
		return Weight;
	}
}
class TestToll {
    public static void main(String [] args) 
	{
        Tollbooth t = new Tollbooth();		
        Trucks t1 = new Trucks(7, 66000);
        Trucks t2 = new Trucks(3, 2250);
        Trucks t3 = new Trucks(6, 21000);
        t.calToll(t1);
        t.display();
        t.calToll(t2);
        t.display();
        t.calToll(t3);
        t.display();
    }
}