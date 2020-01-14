package cn.com.mvcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created By xiaoweiping 2020/1/14 17:38
 **/
public class ExceptionPropertyUtil {
    private Properties prop; //属性集合对象

    private InputStream fis; //属性文件输入流

    private void init() throws IOException{
        prop = new Properties();
        fis = this.getClass().getResourceAsStream("/exceptionMapping.properties");
        prop.load(fis);
        fis.close();
    }

    public String getExceptionMsg(String ExceptionCode) throws IOException{
        init();
        String msg = prop.getProperty(ExceptionCode);
        if (msg != null) {
            return msg;
        } else {
            return "未定义异常!!";
        }
    }

}
