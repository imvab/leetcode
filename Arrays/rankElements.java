// Java implementation to find rank of elements
import java.util.Arrays;
import java.util.Comparator;

class Pair
{
// each element having its first and second
int first, second;

public Pair(int first, int second)
{
	this.first = first;
	this.second = second;
}

// Function to find rank
static void rankify_improved(int A[] , int n)
{
	// Rank Vector
	float R[] = new float[n];
	for(int i=0;i<n;i++)
	{
	R[i]=0;
	}

	// Create an auxiliary array of tuples
	// Each tuple stores the data as well
	// as its index in A
	Pair T[] = new Pair[n];

	// for each element of input array create a
	// structure element to store its index and
	// factors count
	for (int i=0; i<n; i++)
	{
	T[i] = new Pair(A[i],i);
	}

	// T[][0] is the data and T[][1] is
	// the index of data in A

	// Sort T according to first element
	Arrays.sort(T,new Comparator<Pair>() {

	@Override
	// compare method for the elements
	// of the structure
	public int compare(Pair e1, Pair e2) {
		// if two elements have the same number
		// of factors then sort them in increasing
		// order of their index in the input array
		if (e1.first == e2.first)
		return e1.second > e2.second ? -1 : 1;

		// sort in decreasing order of number of factors
		return e1.first < e2.first ? -1 : 1;
	}

	});

	float rank = 1, m = 1;
	int i = 0;

	while(i < n){
	int j = i;

	// Get no of elements with equal rank
	while(j < n - 1 && T[j].first == T[j + 1].first)
		j += 1;

	m = j - i + 1;

	for(int k=0;k<m;k++){

		// For each equal element use formula
		// obtain index of T[i+j][0] in A
		int idx = T[i+k].second;
		R[idx] = (float)((float)rank + (float)(m - 1) * 0.5);
	}

	// Increment rank and i
	rank += m;
	i += m;
	}

	for (int k=0; k<n; k++)
	System.out.print((double)R[k]+" ");
}

// Driver code
public static void main(String args[])
{
	int A[] = {1, 2, 5, 2, 1, 25, 2, 1};
	int n = A.length;

	for (int i = 0; i < n; i++)
	System.out.print(A[i] + " ");
	System.out.println();
	rankify_improved(A, n);
}
}

// This code is contributed by Aarti_Rathi
