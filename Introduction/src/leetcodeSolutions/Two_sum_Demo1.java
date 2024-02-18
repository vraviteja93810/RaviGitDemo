package leetcodeSolutions;

public class Two_sum_Demo1 {

public static int[] two_sum(int[] nums, int target)
{
	int n=nums.length;
	for(int i=0;i<n-1;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(nums[i]+nums[j]==target)
			{
				return new int[] {i,j};
			}
		}
	}
	return new int[] {};
}
public static void main(String[] args) {
	
	int[] value = two_sum(new int[]{1,3,4,5,2,4,5,6,7,8}, 10);
	for(int value2:value)
	{
		System.out.println(value2);
	}
}
}
