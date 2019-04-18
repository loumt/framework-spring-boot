import com.sun.istack.internal.NotNull;

import java.lang.ref.PhantomReference;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static class Test2{
        private String name;
        @NotNull
        private String realname;

        private Integer age;

        public String toString(){
            return "name:" + this.name + "\nRealName:" + this.realname + "\nAge:" + this.age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Test2 t = new Test2();
        t.setName("Loumt");
        t.setAge(15);

        System.out.println(t);


        Map<String,Object> map = new HashMap<>();
        map.put("age", 17);
        map.put("age", 17);
        map.put("age", 17);

        map.forEach((k,v)-> System.out.println("Key:" + k + " ~" + "Value:" + v) );

    }
}
