package telran.people;

import java.util.Arrays;

public class CompanySortedArray extends CompanyArray {
	@Override
	public boolean addEmployee(Employee empl) {
		if (getEmployeeIndex(empl.getId()) >= 0) {
			return false;
		}
		Employee[] tmp = Arrays.copyOf(employees, employees.length + 1);
		int index = -binaryIndexOf(arrayOfId(employees), empl.getId()) - 1;
		System.arraycopy(employees, 0, tmp, 0, index);
		tmp[index] = empl;
		System.arraycopy(employees, index, tmp, index + 1, employees.length - index);
		employees = tmp;
		return true;
	}

	@Override
	protected int getEmployeeIndex(long id) {
		return Arrays.binarySearch(arrayOfId(this.employees), id);
	}

	@Override
	public Employee[] getAllEmployees() {
		return Arrays.copyOf(employees, employees.length);
	}

	public static int binaryIndexOf(long[] ar, long number) {
		int left = 0;
		int right = ar.length - 1;
		int middle = ar.length / 2;
		int res = -1;
		while (left <= right) {
			if (ar[middle] < number) {
				left = middle + 1;
			} else {
				if (ar[middle] == number) {
					res = middle;
				}
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		return res == -1 ? -(left + 1) : res;
	}

	public static long[] arrayOfId(Employee[] employees) {
		long[] idArr = new long[employees.length];
		for (int i = 0; i < employees.length; i++) {
			idArr[i] = employees[i].getId();
		}
		return idArr;
	}
}