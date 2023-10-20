#include <iostream>
#include <stdio.h>
#include <cstring>

using namespace std;

int main() {
	setlocale(LC_ALL, "Rus"); // Russian language
	srand(time(0)); // Random() init

	/*
	Общее задание:
	1) за каждый день месяца известна температура t, а также был ли дождь d, через rand() взять диапазон температур A B (A <= t <= B d: 0 or 1) + високосный ли год
	2) исходные данные вывести в виде: номер дня, был ли дождь и температуру
	3) Индивидуальное задание: Определить самый длинный период непрерывных дождей, указав начало и конец.
	Подсчитать среднее арифметическое температур и максимум для этого периода
	*/

	int t, d, A, B; // 1)
	int year = rand() % (2023 - 1923 + 1) + 1923; // Current year
	int month = rand() % (12 - 1 + 1) + 1; // Current month

	// Temperature range for current month
	A = -5; B = 20; // Spring and Autumn
	switch (month) {
	case 1: case 2: case 12: A = -30; B = 5; break; // Winter
	case 6: case 7: case 8: A = 10; B = 40; break; // Summer
	}

	// Special year or not
	int fl_special;
	if (year % 4 == 0) fl_special = 1;
	else fl_special = 0;

	// Number of days
	int num_days = 30; // 30 days
	switch (month) {
	case 1: case 3: case 5: case 7: case 8: case 10: case 12: num_days = 31; break; // 31 day
	case 2: if (fl_special) num_days = 29; // Special year
	}

	// Headline
	cout << year << " год, " << month << " месяц\n" << endl;
	printf("------------------------------------\n");
	printf("| День | Дождь (1/0) | Температура |\n");
	printf("------------------------------------\n");

	// temp
	int max_start, max_end, end = 1, start = 1, len = 0, max_len = -1, fl_rained = 0, max_t = -31, max_max_t;
	float max_avr_t, avr_t = 0;

	// Showing data for each day
	for (int day = 1; day <= num_days; day++) {
		t = rand() % (B - A + 1) + A;
		d = rand() % 2;
		printf("|%6d|%13d|%13d|\n", day, d, t);
		printf("------------------------------------\n");

		// Finding the longest period of raining
		if (d) { // If rain
			if (!fl_rained) start = day; // If there was no rain we save new start point
			len++; fl_rained = 1; // ++ lenth of period, rained flag

			// temperature
			avr_t += t;
			if (t > max_t) max_t = t;
		}
		else { // If not rain
			if (!fl_rained) continue;
			end = day - 1;
			if (max_len <= len) {
				max_len = len; max_start = start; max_end = end; max_avr_t = avr_t / len; max_max_t = max_t; // Saving max value
			}
			len = 0; fl_rained = 0; avr_t = 0; max_t = -50; // Setting to default
		}
	}
	
	// Correct output
	char dney[7];
	switch (max_len) {
	case 1: strcpy_s(dney, " день "); break;
	case 2: case 3: case 4: strcpy_s(dney, " дня "); break;
	default: strcpy_s(dney, " дней ");
	}

	// Output the result
	cout << "Самый долгий период дождей длился " << max_len << dney << "с " << max_start << " по " << max_end << " число" << endl;
	cout << "средняя температура за этот период составила: " << max_avr_t << endl;
	cout << "максимальная температура: " << max_max_t << endl;

	return 0;
}
