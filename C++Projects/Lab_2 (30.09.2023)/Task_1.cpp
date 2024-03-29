#include <iostream>
#include <stdio.h>
#include <cstring>

using namespace std;


int main()
{
    setlocale(LC_ALL, "Rus");

    /*
    �����: �������� �����, ���� ������� � �������
    (������� - ���������� ����, ������� - ����� ����,
    ������ ������� < �������)
    �����: ������� ���� ������� � ���� ��� ������� �����
    (������� + �������) / 2
    + ��������� �������� ������ � ������ ������ ������� � �������
    */

    char name[10], bd_n[10], sd_n[10], be_n[10], se_n[10];
    int n, b_d, s_d, b_e, s_e, bd_m, sd_m, be_m, se_m;

    // ������ ������, ��� ������� �������� ����� ������
    cout << "������� ���������� ������: "; cin >> n; cout << endl;
    if (n) 
    {
        do
        {
            cout << "������� �������� �����: "; cin >> name;

            cout << "������� ���� ������� ������� - "; cin >> b_d;
            if (b_d < 0)
            {
                cout << "�������� ������� �������\n" << endl;
            }
            bd_m = b_d; strcpy_s(bd_n, name);
            
            cout << "������� ���� ������� ������� - "; cin >> s_d;
            if (s_d < 0)
            {
                cout << "�������� ������� �������\n" << endl;
            }
            sd_m = s_d; strcpy_s(sd_n, name);

            cout << "������� ���� ������� ���� - "; cin >> b_e;
            if (b_e < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }
            be_m = b_e; strcpy_s(be_n, name);
            
            cout << "������� ���� ������� ���� - "; cin >> s_e;
            if (s_e < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }
            se_m = s_e; strcpy_s(se_n, name);

        } while ((s_d < 0) || (b_d < 0) || (s_e < 0) || (b_e < 0));
        
        // ����� �������
        printf("\n--------------------------------------------------------------------------------------------------------------");
        printf("\n| N | �������� | ������� (�) | ������� (�) | ������� ���� (�) | ������� (�) | ������� (�) | ������� ���� (�) |");
        printf("\n--------------------------------------------------------------------------------------------------------------");
        printf("\n|%3d|%10s|%13d|%13d|%18d|%13d|%13d|%18d|", 1, name, b_d, s_d, ((s_d + b_d) / 2), b_e, s_e, ((s_e + b_e) / 2));
        printf("\n--------------------------------------------------------------------------------------------------------------");
        cout << endl;
    }

    // ���� ������ � ����������� ������
    for (int i = 2; i <= n; i++)
    {
        do
        {
            cout << "������� �������� �����: "; cin >> name;

            cout << "������� ���� ������� ������� - "; cin >> b_d;
            if (b_d < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }

            cout << "������� ���� ������� ������� - "; cin >> s_d;
            if (s_d < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }

            cout << "������� ���� ������� ���� - "; cin >> b_e;
            if (b_e < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }

            cout << "������� ���� ������� ���� - "; cin >> s_e;
            if (s_e < 0)
            {
                cout << "�������� ������� �������\n" << endl; 
            }

        } while ((s_d < 0) || (b_d < 0) || (s_e < 0) || (b_e < 0));

        // ���������� ������� �����
        // bd
        if (b_d > bd_m) { bd_m = b_d; strcpy_s(bd_n, name); }
        // sd
        if (s_d < sd_m) { sd_m = s_d; strcpy_s(sd_n, name); }
        // be
        if (b_e > be_m) { be_m = b_e; strcpy_s(be_n, name); }
        // se
        if (s_e < se_m) { se_m = s_e; strcpy_s(se_n, name); }

        // ����� �������
        printf("\n--------------------------------------------------------------------------------------------------------------");
        printf("\n| N | �������� | ������� (�) | ������� (�) | ������� ���� (�) | ������� (�) | ������� (�) | ������� ���� (�) |");
        printf("\n--------------------------------------------------------------------------------------------------------------");
        printf("\n|%3d|%10s|%13d|%13d|%18d|%13d|%13d|%18d|", i, name, b_d, s_d, ((s_d + b_d) / 2), b_e, s_e, ((s_e + b_e) / 2));
        printf("\n--------------------------------------------------------------------------------------------------------------");
        cout << endl;
    }

    // ����� ������ ������
    if (n)
    {
        cout << "������ ����� ������\n";
        cout << "������� (�): ���� " << bd_n << " - " << bd_m << endl;
        cout << "������� (�): ���� " << sd_n << " - " << sd_m << endl;
        cout << "������� (�): ���� " << be_n << " - " << be_m << endl;
        cout << "������� (�): ���� " << se_n << " - " << se_m << endl;
    }

    return 0;
}
