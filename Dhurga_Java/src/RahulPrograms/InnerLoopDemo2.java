package RahulPrograms;

public class InnerLoopDemo2 {
public static void main(String[] args) {
	int k=1;
	for(int i=4;i>=1;i--)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(k+" ");
			k++;
		}
		System.out.println();
	}
}
}
