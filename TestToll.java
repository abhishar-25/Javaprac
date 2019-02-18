	class Tollbooth {
    Tollbooth() 
	{
        initialtruckcount = 0;
        initialreceipts = 0;
    }
    void calToll(Truck T) 
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
    void Rcollect() 
	{
        System.out.print("Total amount of receipts");
        display();
        initialtruckcount = 0;
        initialreceipts = 0;
    }
    void display() 
	{
        System.out.print("Total amount of Receipts: ");
        System.out.println(initialreceipts);
        System.out.print(" Trucks: ");
        System.out.println(initialtruckcount);
    }
    int initialreceipts;
    int initialtruckcount;
	}
class Truck {
    Truck(int axles, int Weight) 
	{
        this.axles = axles;
        this.Weight = Weight;
    }
    int getAxles() 
	{
		return axles;
	}
    int getWeight() 
	{
		return Weight;
	}
    int axles;
    int Weight;
}
class TestToll {
    public static void main(String [] args) 
	{
        Tollbooth t = new Tollbooth();
		
        Truck t1 = new Truck(7, 66000);
        Truck t2 = new Truck(3, 2250);
        Truck t3 = new Truck(6, 21000);
        t.calToll(t1);
        t.display();
        t.calToll(t2);
        t.Rcollect();
        t.calToll(t3);
        t.display();
    }
}