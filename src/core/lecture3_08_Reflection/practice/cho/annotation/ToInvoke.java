package core.lecture3_08_Reflection.practice.cho.annotation;

/*7.6 ����� ������, ����������� ����������*

�������������� ������ 6.5 ���, ����� ����� ��������� ������ ���� ��� ����� �������
���������� @Contains � �������� �������� run ��������� @ToInvoke ����� true
(��������������� ��������� ���������� ��������������).*/

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface ToInvoke {
	public boolean run() default false;	
}
