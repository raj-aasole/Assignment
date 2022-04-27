class Shape
{
area:number;
  disp()
  {
	console.log("Area of Square is="+this.area);
  }
  disp1()
  {
	console.log("Area of Rectangle is="+this.area);
  }
  
}
class Square extends Shape
{
	
	side:number;
	constructor(side:number)
	{
		super();
		this.side=side;
		
	}
	Area()
	{
		this.area=this.side * this.side;
		this.disp();
	}	
}
class Rectangle extends Shape
{
	
	l:number;
	w:number;
	constructor(l:number,w:number)
	{
		super();
		this.w=w;
		this.l=l;
		
	}
	Area()
	{
		this.area=this.l * this.w;
		this.disp1();
	}	
}


var objSquare = new Square(2);
objSquare.Area();

var objRectangle= new Rectangle(3,5);
objRectangle.Area();


