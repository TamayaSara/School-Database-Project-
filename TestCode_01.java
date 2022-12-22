class Abc
{
	public int fun=100;
	int fun()
	{
		return fun;
	}
}
class TestCode_01
{
	public static void main(String args[])
	{
		Abc p=new Abc();
		System.out.println("Value is "+p.fun());
		Course q=new Course(true,777,"CMP",4);
		System.out.println("Course is "+q.toString());
	}
}