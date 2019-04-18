import java.util.Properties;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive (){
        System.out.println("Yes . I am still alive ;");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No, I am dead!");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            //finalize 方法只会被系统调用一次
            //此方法不推荐使用,用try-finally 更好，更及时
            System.out.println("No, I am dead!");
        }


//        Properties properties = System.getProperties();
    }
}
