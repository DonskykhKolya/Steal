package com.gmail.ndonskih63;

import java.util.Arrays;

public class ForVoenkom implements Voenkom {

	@Override
	public Student[] recruits(Group group) {
		Student[] recruits = new Student[0];
		for (int i = 0; i < group.groupSize() - 1; i++) {
			if (group.searchStudent(i + 1) != null) {
				if (group.searchStudent(i + 1).getAge() > 18 && group.searchStudent(i + 1).getSex().equals("male")) {
					Student[] st = Arrays.copyOf(recruits, recruits.length + 1);
					st[st.length - 1] = group.searchStudent(i + 1);
					recruits = st;
				}
			}
		}
		return recruits;
	}

}
