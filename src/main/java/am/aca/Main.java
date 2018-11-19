package am.aca;

import java.lang.reflect.*;
import java.util.Arrays;
import tree.Tree;
import am.aca.tree.shrub.Shrub;
import am.aca.tree.shrub.herbs.Herbs;


class Main{
	public static void main(String[] args) throws Exception{
		Tree t = new Tree();
		Shrub s = new Shrub();
		Herbs h = new Herbs();

		magic(t);
		magic(s);
		magic(h);

	}
	public static void magic(Object o) throws Exception {
		Class<?> sc = o.getClass(); 
		System.out.println(sc.getName());

		Field[] fs = sc.getDeclaredFields();
		if(fs.length == 0){
			System.out.println("\nno fields");
		} else {
			System.out.println("\nfields");
			for(Field f: fs){
				f.setAccessible(true);
				System.out.println(f.getName() + " " +f.get(o));	
			}
		}

		Method[] ms = sc.getDeclaredMethods();
		if(ms.length == 0){
			System.out.println("\nno methods");
		} else {
			System.out.println("\nmethods");
			for(Method m: ms){
				m.setAccessible(true);
				System.out.println(	m.getReturnType()+" "+ m.getName()+"(" +Arrays.deepToString(m.getParameterTypes())+")");	
			}
		}
		
		Constructor[] cs = sc.getDeclaredConstructors();
		System.out.println("\nconstructor");
			for(Constructor c: cs){
				c.setAccessible(true);
				System.out.println(	c.getName()+"(" +Arrays.deepToString(c.getParameterTypes())+") {}");	
			}

	}
}

