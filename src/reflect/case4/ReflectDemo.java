package reflect.case4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *	通过反射获取成员方法并使用
 *
 *	如何获取成员方法呢？
 *
 *	Class类的成员方法
 *		getMethods()：获取所有公共方法
 *		getDeclaredMethods()：获取所有方法
 *
 *		public Method getMethod(String name,Class<?>... parameterTypes)：获取该类一个公共方法
 *		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)：获取该类一个任意方法
 *
 *	
 *
 */
public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		//获取Class对象
		Class c = Class.forName("reflect.Student");
		
		//getDeclaredMethods()：获取所有公共方法
		//会将父类的公共方法都获取到
		Method[] methods1 = c.getMethods();
		for (Method method : methods1) {
			System.out.println(method);
		}
		System.out.println("========================");
		//getDeclaredMethods()：获取所有方法
		//只会获取本类内的方法
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("==========================");
		
		//getDeclaredMethod(String name,Class<?>... parameterTypes)：获取任意方法
		Method method = c.getDeclaredMethod("show");
		System.out.println(method);
		
		Method method2 = c.getDeclaredMethod("method", String.class);
		System.out.println(method2);
		
		Method method3 = c.getDeclaredMethod("method3", String.class);
		System.out.println(method3);
		
		//使用Method方法
		Constructor constructor = c.getConstructor();
		Object object = constructor.newInstance();
		System.out.println(object);
		
		//调用无参无返回值的
		method.invoke(object);
		
		//调用有参无返回值的
		method2.invoke(object, "张三");
		
		//调用有参有返回值的
		//暴力访问
		method3.setAccessible(true);
		Object result = method3.invoke(object, "张三");
		System.out.println(result);
		
	}

}


//public java.lang.String reflect.Student.toString()
//public void reflect.Student.show()
//public java.lang.String reflect.Student.method3(java.lang.String)
//public void reflect.Student.method2(java.lang.String,int)
//public void reflect.Student.method(java.lang.String)
//public final void java.lang.Object.wait() throws java.lang.InterruptedException
//public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//public boolean java.lang.Object.equals(java.lang.Object)
//public native int java.lang.Object.hashCode()
//public final native java.lang.Class java.lang.Object.getClass()
//public final native void java.lang.Object.notify()
//public final native void java.lang.Object.notifyAll()
//========================
//public java.lang.String reflect.Student.toString()
//public void reflect.Student.show()
//public java.lang.String reflect.Student.method3(java.lang.String)
//public void reflect.Student.method2(java.lang.String,int)
//public void reflect.Student.method(java.lang.String)
//private void reflect.Student.hello(java.lang.String)
//==========================
//public void reflect.Student.show()
//public void reflect.Student.method(java.lang.String)
//public java.lang.String reflect.Student.method3(java.lang.String)
//Student [name=null, age=0, address=null]
//张三
//hello,张三
