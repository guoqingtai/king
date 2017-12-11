package knight.z9_test.dwrtest;
import org.directwebremoting.Browser;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.ui.dwr.Util;  
public class PushMessage {
	public static void sendMsg(final String msg){      
        //WebContext wctx = WebContextFactory.get();  
        //Browser.withPage("/MyDWRSample/",new Runnable(){  
        //针对具体的页面first_test.jsp页面进行推送  
        String page = ServerContextFactory.get().getContextPath() + "/first_test.jsp";  
        //System.out.println(page);  
        Browser.withPage(page ,new Runnable(){  
        public void run(){  
            //ScriptSessions.addFunctionCall("show", msg);  
            //messageid字段是向jsp页面推送时所对应的字段，msg是要推送的消息  
            Util.setValue("messageid", msg);  
        }  
    });  
       
    }  
}
