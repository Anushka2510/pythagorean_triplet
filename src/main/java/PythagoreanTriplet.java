import java.util.*;
public class PythagoreanTriplet {
	int a;
	int b;
	int c;
	PythagoreanTriplet(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		PythagoreanTriplet other = (PythagoreanTriplet) obj;
		return a == other.a && b == other.b && c == other.c;
	}
	
	boolean isPythagorean() {
		return a * a + b * b == c * c;
	}
	static PythagoreanTripletBuilder makeTripletsList() {
		return new PythagoreanTripletBuilder();
	}
}
class PythagoreanTripletBuilder {
	int total;
	int sum;
	PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int total) {
		this.total = total;
		return this;
	}
	PythagoreanTripletBuilder thatSumTo(int sum) {
		this.sum = sum;
		return this;
	}
	List<PythagoreanTriplet> build() {
		List<PythagoreanTriplet> result = new ArrayList<PythagoreanTriplet>();
		for (int a = 1; a <= total/3; a++) {
			for (int b = a + 1; b <= total/2; b++) {
				int c=sum-a-b;
				
				PythagoreanTriplet pt = new PythagoreanTriplet(a, b, c);
				if (pt.isPythagorean()) {
					result.add(pt);
				}
			}
		}
		return result;
	}
}
