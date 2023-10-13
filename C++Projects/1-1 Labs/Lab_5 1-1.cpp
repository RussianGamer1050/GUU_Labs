#include <iostream>

int main() {
	using namespace std;
	setlocale(LC_ALL, "Rus");

	int K = 2, N; // Numbers 1 < K < 10, N >= 20

	// Enter N
	do {
		cout << "¬ведите N: ";
		cin >> N;
		if (N < 20) cout << "¬ведите N >= 20\n" << endl;
	} while (N < 20);

	int kol = 0; // Counter
	// For every K
	for (; K < 10; K++) {
		// 1 to N
		for (int n = N; n != 0; n--) {
			int t = K * n, k = 0;
			
			// Checking out sum of nums
			while (t) {
				k += t % 10;
				t /= 10;
			}
			
			// Checking out equality
			if (K == k) {
				cout << K * n << endl;
				kol++;
			}
		}
	}
	cout << " оличество удовлетвор€ющих условию задачи чисел: " << kol << endl;

	return 0;
}
