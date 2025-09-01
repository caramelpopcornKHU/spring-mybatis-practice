package basic;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotaionTest {
	public static void main(String[] args) {
		// Annotaion 뭘까?
		// 변수는 아니다. 함수, 클래스, 패키지도 아니다.
		// 주로 어노테이션은 마킹용도로 사용한다.
		MyClass myclass = new MyClass();
		Annotation[] annotationList = myclass.getClass().getAnnotations();
		for (Annotation annotation : annotationList) {
			System.out.println(annotation);
		}
	}
}

//Annotation 정의하기
@Retention(RetentionPolicy.RUNTIME)

@interface MyAnnotation {

}

//MyClass라는 클래스는 @MyAnnotation으로 마킹한 것, 도장 찍은 것
@MyAnnotation
class MyClass {

}