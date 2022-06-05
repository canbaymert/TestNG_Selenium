package tests.practices;

import org.testng.annotations.Test;

public class Q1_Priority {


    @Test(priority = 3000)
    public void b() {
        System.out.println("b");
    }

    @Test(priority = 2001, enabled = false)
    public void a() {
        System.out.println("a");
    }

    @Test(priority = 2000)
    public void c() {
        System.out.println("c");
    }

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }

    @Test(enabled = false)
    public void test03() {
        System.out.println("test03");
    }

    @Test(enabled = false)
    public void test04() {
        System.out.println("test04");
    }

    @Test(enabled = false)
    public void test05() {
        System.out.println("test05");
    }

    @Test
    public void test06() {
        System.out.println("test06");
    }

    /*
    test01
    test02
    test06
    c
    b

     */
}


