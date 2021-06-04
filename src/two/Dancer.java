package two;

/**
 * -*- coding: utf-8 -*-
 *
 * @author 卢升达
 * @version 1.0
 * @date 2021-03-21
 */
public class Dancer {
	public static void DancePartner (Person[] dancer) {//数组dancer中存放跳舞的男女
		int i, n = 0;
		Person p;
		Queues<Person> Mdancers = new Queues<Person>();
		Queues<Person> Fdancers = new Queues<Person>();

		for (Person d : dancer) {//依次将跳舞者依其性别入队
			p = d;
			if (d.GetSex() == 'F') {
				Fdancers.add(d);//排入女队
			} else {
				Mdancers.add(d);//排入男队
			}
		}
		System.out.println("舞伴:");
		while (n != Fdancers.length() && n != Mdancers.length()) {
			n++;
			System.out.println("第" + n + "对舞伴:");
			p = Fdancers.remove();
			Fdancers.add(p);
			System.out.println("女士" + p.GetName());
			p = Mdancers.remove();
			Mdancers.add(p);
			System.out.println("男士" + p.GetName());
		}

		if (n < Fdancers.length()) {
			System.out.println("还有女士几人等待下一轮的舞曲" + (Fdancers.length() - n));
			p = Fdancers.element();
			System.out.println(p.GetName() + " 将是第一个参加下一轮舞曲的女士.");
		} else if (n < Mdancers.length()) {
			System.out.println("还有男士几人等待下一轮的舞曲." + (Mdancers.length() - n));
			p = Mdancers.element();
			System.out.println(p.GetName() + " 将是第一个参加下一轮舞曲的男士.");
		}
	}

	public static void main (String[] args) {
		String[] names = {"张", "王", "黄", "唐", "孙", "贾"};
		char[] sexs = {'F', 'M', 'M', 'F', 'F', 'M'};
		Person[] dancers = new Person[6];
		for (int i = 0; i < names.length; i++) {
			dancers[i] = new Person(names[i], sexs[i]);
			//   	dancers[i].SetName(names[i]);
			//   	dancers[i].SetSex(sexs[i]);
		}
		DancePartner(dancers);
	}
}
