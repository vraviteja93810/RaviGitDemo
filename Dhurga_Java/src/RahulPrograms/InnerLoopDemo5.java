package RahulPrograms;

public class InnerLoopDemo5 {
public static void main(String[] args) {
	int k=3;
	for(int i=1;i<=4;i++)
	{
		for(int j=0;j<i;j++)
		{
			System.out.print(k+" ");
			k=k+3;
		}
		System.out.println();
	}
}
}
