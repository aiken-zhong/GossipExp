import java.util.Random;

public class Main {
	private static int MAX = 100;
	private static int SCALE = 1000;
	private static double K = 1.01;

	public static void main(String[] args) {
		double[] node = new double[SCALE];
		double[] interest = new double[SCALE];
		Random random = new Random();
		for (int i = 0; i < node.length; i++) {
			node[i] = random.nextDouble()*MAX;
			interest[i] = 0.99;
		}
		
		double avg = avg(node);
		
		int n = 0;
		while (true) {
			n++;
			int exchange = 0;
			for (int i = 0; i < node.length; i++) {
				if (random.nextDouble() < interest[i]) {
					int j = random.nextInt(SCALE);
					if (node[i] == node[j]){
						interest[i] = interest[i]/K;
					}
					else {
						double temp = (node[i] + node[j])/2;
						node[i] = temp;
						node[j] = temp;
						exchange ++;
					}
				}
			}
			for (int i = 0; i < node.length; i++) {
				System.out.print(node[i] + ",  ");
			}
			System.out.println();
			for (int i = 0; i < interest.length; i++) {
				System.out.print(interest[i] + ",  ");
			}
			System.out.println(exchange);
			if (exchange == 0) {
				break;
			}
		}
		System.out.println(n);
		System.out.println(avg);

	}
	private static double avg(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum/arr.length;
	}

}
